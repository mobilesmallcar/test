package com.example.grab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.grab.Utils.MyUtils;
import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.mapper.CompanyMapper;
import com.example.grab.service.ICompanyService;
import com.example.grab.vo.CompanySaveVo;
import com.example.grab.vo.Response.CompanyResponse;
import com.example.grab.vo.Response.ResultDTO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private RelationService relationService;

    @Override
    public ResultDTO addCompany(CompanySaveVo saveVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("project_no",saveVo.getProjectNo());
        Company check = companyMapper.selectOne(queryWrapper);
        if(check!=null){
            return MyUtils.buildFalse("项目编号应当唯一");
        }
        Company company = new Company();
        BeanUtils.copyProperties(saveVo, company);
        int result = companyMapper.insertCompany(company);
        return MyUtils.getResponse(result,
                String.valueOf(company.getId()),
                "新增失败");
    }

    @Override
    public ResultDTO<List<Company>> getCompanyList(Integer page, Integer limit) {
        IPage<Company> companyPage = new Page<>(page, limit);
//        PageHelper.startPage(page, limit);

        IPage<Company> result = companyMapper.selectPage(companyPage, null);
        List<Company> records = result.getRecords();
        List<CompanyResponse> responses =Lists.transform(records, s->{
            CompanyResponse response = new CompanyResponse();
            BeanUtils.copyProperties(s,response);
            Integer companyId = s.getId();
            List<Expert> experts = this.getExpert(companyId);
            String info = "";
            for(Expert expert:experts){
                info += "姓名："+expert.getName()+",专家号:"+expert.getExpertNo()+",手机号"+expert.getMobile()+";";
            }
            response.setExperts(info);
            return response;
        });
        ResultDTO res = MyUtils.getResultDTO(result);
        res.setData(responses);
        return res;
    }


    @Override
    public Boolean updateCompanyById(Company update) {
        Company company = companyMapper.selectById(update.getId());
        if (company == null) {
            throw new RuntimeException("非法请求，请求id为:" + update.getId());
        }
        int result = companyMapper.updateById(update);
        return result == 1 ? true : false;
    }

    @Override
    public Boolean deleteCompanyById(Integer id) {
        int result = companyMapper.deleteById(id);
        if (result != 1) {
            throw new RuntimeException("删除失败，请求id为:" + id);
        }
        return result == 1 ? true : false;
    }

//    @Override
//    public List<DataVo> getCompanyUserList() {
//        List<Company> companyList = companyMapper.selectList(null);
//        List<DataVo> responses = new ArrayList<>();
//        companyList.forEach(e -> {
//            DataVo response = new DataVo();
//            response.setName(e.getProjectName());
//            response.setPhone(e.getProjectNo());
//            responses.add(response);
//        });
//        return responses;
//    }

    @Override
    public Company findById(Integer id) {
        Company company = companyMapper.selectById(id);
        if (company.getId() == null) {
            throw new RuntimeException("非法请求,请求id为" + id);
        }
        return company;
    }

    /**
     * 获取该活动下的专家信息
     *
     * @return
     */
    @Override
    public List<Expert> getExpert(Integer companyId) {

        List<Expert> responses = relationService.getExperts(companyId);
        return responses == null ? new ArrayList<>() : responses;
    }

}
