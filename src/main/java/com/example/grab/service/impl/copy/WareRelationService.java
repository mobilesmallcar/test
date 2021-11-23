package com.example.grab.service.impl.copy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.Relation;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.entity.copy.WareRelation;
import com.example.grab.mapper.RelationMapper;
import com.example.grab.mapper.copy.WareRelationMapper;
import com.example.grab.service.IRelationService;
import com.example.grab.service.copy.IWareRelationService;
import com.example.grab.vo.RelationSaveVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WareRelationService implements IWareRelationService {
    @Autowired
    private WareRelationMapper relationMapper;
    @Autowired
    private WareCompanyService companyService;
    @Autowired
    private WareExpertService expertService;
    @Override
    public Boolean addRelation(RelationSaveVo saveVo) {
        if(saveVo.getCompanyId()==null||saveVo.getExpertId()==null){
            throw new RuntimeException("本次请求异常");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("company_id",saveVo.getCompanyId());
        queryWrapper.eq("expert_id",saveVo.getExpertId());
        WareRelation flag = relationMapper.selectOne(queryWrapper);
        if(flag!=null&&flag.getId()!=null){
            throw new RuntimeException(flag.getName()+"已经抽取过了");
        }
        WareCompany company = companyService.findById(saveVo.getCompanyId());
        WareExpert expert = expertService.findById(saveVo.getExpertId());

        WareRelation relation = this.buildRelationParam(company,expert);
        relationMapper.insert(relation);
        return true;
    }

    @Override
    public List<WareExpert> getExperts(Integer companyId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("company_id",companyId);
        List<WareRelation> relations = relationMapper.selectList(queryWrapper);
        List<WareExpert> responses = Lists.transform(relations,s->{
            Integer expertId = s.getExpertId();
            WareExpert expert = expertService.findById(expertId);
           return expert;
        });
        return responses;
    }

    @Override
    public List<WareCompany> getCompanys(Integer expertId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("expert_id",expertId);
        List<Relation> relations = relationMapper.selectList(queryWrapper);
        List<WareCompany> responses = Lists.transform(relations,s->{
           Integer companyId = s.getCompanyId();
           WareCompany company = companyService.findById(companyId);
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

    private WareRelation buildRelationParam(WareCompany company,WareExpert expert){
        WareRelation relation = new WareRelation();
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
