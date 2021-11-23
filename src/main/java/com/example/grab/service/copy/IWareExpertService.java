package com.example.grab.service.copy;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.vo.ExpertSaveVo;
import com.example.grab.vo.Response.DataVo;
import com.example.grab.vo.Response.ResultDTO;

import java.util.List;


public interface IWareExpertService {
    ResultDTO  addExpert(ExpertSaveVo saveVo);

    ResultDTO<List<WareExpert>> getExpertList(Integer page, Integer limit);

    Boolean updateExpertById(WareExpert expert);

    Boolean deleteExpertById(Integer id);

    WareExpert findById(Integer id);

    List<DataVo> getUser();

    /**
     * 获取该专家的获奖项目
     * @param expertId
     * @return
     */

    List<WareCompany> getCompany(Integer expertId);
}
