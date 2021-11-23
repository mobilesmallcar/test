package com.example.grab.service.copy;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.vo.CompanySaveVo;
import com.example.grab.vo.Response.ResultDTO;

import java.util.List;

public interface IWareCompanyService {
    ResultDTO addCompany(CompanySaveVo saveVo);

    ResultDTO<List<WareCompany>> getCompanyList(Integer page, Integer limit);

    Boolean updateCompanyById(WareCompany company);

    Boolean deleteCompanyById(Integer id);


    WareCompany findById(Integer id);

    /**
     * 获取该活动下的专家信息
     * @param companyId
     * @return
     */
    List<WareExpert> getExpert(Integer companyId);
}
