package com.example.grab.vo.Response;

import com.example.grab.entity.Company;
import lombok.Data;

@Data
public class CompanyResponse extends Company {
    private String experts;
}
