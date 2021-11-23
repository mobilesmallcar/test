package com.example.grab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.grab.entity.Company;
import com.example.grab.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
    Integer insertCompany(Company company);
}
