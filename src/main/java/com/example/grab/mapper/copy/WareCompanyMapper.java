package com.example.grab.mapper.copy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.grab.entity.Company;
import com.example.grab.entity.copy.WareCompany;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface WareCompanyMapper extends BaseMapper<WareCompany> {
    Integer insertCompany(WareCompany company);
}
