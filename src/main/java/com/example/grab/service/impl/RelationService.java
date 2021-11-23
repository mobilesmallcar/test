package com.example.grab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.Relation;
import com.example.grab.mapper.CompanyMapper;
import com.example.grab.mapper.RelationMapper;
import com.example.grab.service.IRelationService;
import com.example.grab.vo.RelationSaveVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RelationService implements IRelationService {
    @Autowired
    private RelationMapper relationMapper;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ExpertService expertService;
    @Override
    public Boolean addRelation(RelationSaveVo saveVo) {
        if(saveVo.getCompanyId()==null||saveVo.getExpertId()==null){
            throw new RuntimeException("本次请求异常");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("company_id",saveVo.getCompanyId());
        queryWrapper.eq("expert_id",saveVo.getExpertId());
        Relation flag = relationMapper.selectOne(queryWrapper);
        if(flag!=null&&flag.getId()!=null){
            throw new RuntimeException(flag.getName()+"已经抽取过了");
        }
        Company company = companyService.findById(saveVo.getCompanyId());
        Expert expert = expertService.findById(saveVo.getExpertId());

        Relation relation = this.buildRelationParam(company,expert);
        relationMapper.insert(relation);
        return true;
    }

    @Override
    public List<Expert> getExperts(Integer companyId) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper();
        queryWrapper.eq("company_id",companyId);
        List<Relation> relations = relationMapper.selectList(queryWrapper);
        List<Expert> responses = Lists.transform(relations,s->{
            Integer expertId = s.getExpertId();
            Expert expert = expertService.findById(expertId);
           return expert;
        });
        return responses;
    }

    @Override
    public List<Company> getCompanys(Integer expertId) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper();
        queryWrapper.eq("expert_id",expertId);
        List<Relation> relations = relationMapper.selectList(queryWrapper);
        List<Company> responses = Lists.transform(relations,s->{
           Integer companyId = s.getCompanyId();
           Company company = companyService.findById(companyId);
           return company;
        });
        return responses;
    }

    @Override
    public Boolean deleteRelation(Integer companyId) {
//        for(Integer id:ids){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("company_id",companyId);
        int result = relationMapper.delete(queryWrapper);
        log.info("删除了"+result+"条记录");
        return null;
    }

    private Relation buildRelationParam(Company company,Expert expert){
        Relation relation = new Relation();
        relation.setExpertId(expert.getId());
        relation.setCompanyId(company.getId());

        relation.setName(expert.getName());
        relation.setExpertNo(expert.getExpertNo());
        relation.setMobile(expert.getMobile());

        relation.setProjectNo(company.getProjectNo());
        relation.setProjectName(company.getProjectName());

        return relation;
    }
}
