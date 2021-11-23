package com.example.grab.service;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.vo.CompanySaveVo;
import com.example.grab.vo.Response.ResultDTO;

import java.util.List;

public interface ICompanyService {
    ResultDTO addCompany(CompanySaveVo saveVo);

    ResultDTO<List<Company>> getCompanyList(Integer page, Integer limit);

    Boolean updateCompanyById(Company company);

    Boolean deleteCompanyById(Integer id);


    Company findById(Integer id);

    /**
     * 获取该活动下的专家信息
     * @param companyId
     * @return
     */
    List<Expert> getExpert(Integer companyId);
}
