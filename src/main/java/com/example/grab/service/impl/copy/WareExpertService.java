package com.example.grab.service.impl.copy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.grab.Utils.MyUtils;
import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.mapper.ExpertMapper;
import com.example.grab.mapper.copy.WareExpertMapper;
import com.example.grab.service.IExpertService;
import com.example.grab.service.copy.IWareExpertService;
import com.example.grab.vo.ExpertSaveVo;
import com.example.grab.vo.Response.DataVo;
import com.example.grab.vo.Response.ResultDTO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WareExpertService implements IWareExpertService {
    @Autowired
    private WareExpertMapper expertMapper;

    @Autowired
    private WareRelationService relationService;

    @Override
    public ResultDTO addExpert(ExpertSaveVo saveVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", saveVo.getName());
        queryWrapper.eq("mobile", saveVo.getMobile());
        List<Expert> experts = expertMapper.selectList(queryWrapper);
        if (experts.size() > 0) {
            return MyUtils.buildFalse("不可重复新增");
        }
        WareExpert expert = new WareExpert();
        BeanUtils.copyProperties(saveVo, expert);
        expert.setDeleted(1);

        int result = expertMapper.insert(expert);
        return MyUtils.getResponse(result,"新增成功","新增失败");
    }

    @Override
    public ResultDTO<List<WareExpert>> getExpertList(Integer page, Integer limit) {
        IPage<WareExpert> expertPage = new Page<>();
        final IPage<WareExpert> list = expertMapper.selectPage(expertPage, null);
        return MyUtils.getResultDTO(list);
    }

    @Override
    public Boolean updateExpertById(WareExpert expert) {
        int result = expertMapper.updateById(expert);
        return MyUtils.getBoolean(result);
    }

    @Override
    public Boolean deleteExpertById(Integer id) {
        WareExpert expert = expertMapper.selectById(id);
        expert.setDeleted(0);
        int result = expertMapper.updateById(expert);
//        int result = expertMapper.deleteById(id);
        if (result != 1) {
            throw new RuntimeException("删除失败，请求id为:" + id);
        }
        return MyUtils.getBoolean(result);
    }

    @Override
    public WareExpert findById(Integer id) {
        WareExpert expert = expertMapper.selectById(id);
        if (expert.getId() == null) {
            throw new RuntimeException("非法请求,请求id为" + id);
        }
        return expert;
    }

    @Override
    public List<DataVo> getUser() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deleted",1);
        List<WareExpert> expertList = expertMapper.selectList(queryWrapper);
        List<DataVo> dataVos = new ArrayList<>();
        List<DataVo> responses = Lists.transform(expertList, s -> {
            DataVo dataVo = new DataVo();
            dataVo.setId(s.getId());
            dataVo.setName(s.getName());
            dataVo.setExpertNo(s.getExpertNo());
            dataVo.setPhone(s.getMobile());
            return dataVo;
        });
        dataVos.addAll(responses);
        while(dataVos.size()<100){
            dataVos = this.getResponse(dataVos,expertList);
        }
        return dataVos;
    }
    public List<DataVo> getResponse(List<DataVo> dataVos,List<WareExpert> expertList){
        List<DataVo> response = Lists.transform(expertList, s -> {
            DataVo dataVo = new DataVo();
            dataVo.setId(s.getId());
            dataVo.setName(s.getName());
            dataVo.setPhone(s.getMobile());
            dataVo.setExpertNo(s.getExpertNo());
            return dataVo;
        });
        dataVos.addAll(response);
        return dataVos;
    }
    @Override
    public List<WareCompany> getCompany(Integer expertId) {
        List<WareCompany> responses = relationService.getCompanys(expertId);
        return responses == null ? new ArrayList<>() : responses;
    }
}
