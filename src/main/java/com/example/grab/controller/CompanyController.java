package com.example.grab.controller;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.service.ICompanyService;
import com.example.grab.vo.CompanySaveVo;
import com.example.grab.vo.Response.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @PostMapping("/company/add")
    public ResultDTO addCompany(@RequestBody CompanySaveVo saveVo) {
        ResultDTO flag = companyService.addCompany(saveVo);
        return flag;
    }

    @GetMapping("/company/get")
    public ResultDTO<List<Company>> getCompanyList(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        ResultDTO<List<Company>> flag = companyService.getCompanyList(page, limit);

        return flag;
    }

    @PostMapping("company/update")
    public ResultDTO<Boolean> updateCompanyById(@RequestBody Company company) {
        Boolean flag = companyService.updateCompanyById(company);
        return new ResultDTO(flag);
    }

    @GetMapping("/company/delete")
    public ResultDTO<Boolean> deleteCompanyById(@RequestParam(value = "id") Integer id) {
        Boolean flag = companyService.deleteCompanyById(id);
        return new ResultDTO(flag);
    }

    //=============================
    @GetMapping("company/getExpert")
    public List<Expert> getExpert(@RequestParam(value = "companyId") Integer companyId) {
        List<Expert> flag = companyService.getExpert(companyId);
        return flag;
    }
}
