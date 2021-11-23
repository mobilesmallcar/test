package com.example.grab.service.copy;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.vo.RelationSaveVo;

import java.util.List;

public interface IWareRelationService {
    Boolean addRelation(RelationSaveVo saveVo);

    List<WareExpert> getExperts(Integer companyId);
    List<WareCompany> getCompanys(Integer expertId);

    Boolean deleteRelation(Integer companyId);
}
