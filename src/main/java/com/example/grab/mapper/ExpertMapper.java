package com.example.grab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertMapper extends BaseMapper<Expert> {
}
