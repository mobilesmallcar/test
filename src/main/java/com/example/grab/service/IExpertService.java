package com.example.grab.service;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.vo.ExpertSaveVo;
import com.example.grab.vo.Response.DataVo;
import com.example.grab.vo.Response.ResultDTO;

import java.util.List;


public interface IExpertService {
    ResultDTO  addExpert(ExpertSaveVo saveVo);

    ResultDTO<List<Expert>> getExpertList(Integer page, Integer limit);

    Boolean updateExpertById(Expert expert);

    Boolean deleteExpertById(Integer id);

    Expert findById(Integer id);

    List<DataVo> getUser();

    /**
     * 获取该专家的获奖项目
     * @param expertId
     * @return
     */

    List<Company> getCompany(Integer expertId);
}
