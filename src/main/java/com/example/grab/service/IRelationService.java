package com.example.grab.service;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.vo.RelationSaveVo;

import java.util.List;

public interface IRelationService {
    Boolean addRelation(RelationSaveVo saveVo);

    List<Expert> getExperts(Integer companyId);
    List<Company> getCompanys(Integer expertId);

    Boolean deleteRelation(Integer companyId);
}
