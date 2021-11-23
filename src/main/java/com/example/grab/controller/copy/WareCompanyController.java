package com.example.grab.controller.copy;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.service.ICompanyService;
import com.example.grab.service.copy.IWareCompanyService;
import com.example.grab.vo.CompanySaveVo;
import com.example.grab.vo.Response.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WareCompanyController {

    @Autowired
    private IWareCompanyService companyService;

    @PostMapping("/wareCompany/add")
    public ResultDTO addCompany(@RequestBody CompanySaveVo saveVo) {
        ResultDTO flag = companyService.addCompany(saveVo);
        return flag;
    }

    @GetMapping("/wareCompany/get")
    public ResultDTO<List<WareCompany>> getCompanyList(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        ResultDTO<List<WareCompany>> flag = companyService.getCompanyList(page, limit);

        return flag;
    }

    @PostMapping("wareCompany/update")
    public ResultDTO<Boolean> updateCompanyById(@RequestBody WareCompany company) {
        Boolean flag = companyService.updateCompanyById(company);
        return new ResultDTO(flag);
    }

    @GetMapping("/wareCompany/delete")
    public ResultDTO<Boolean> deleteCompanyById(@RequestParam(value = "id") Integer id) {
        Boolean flag = companyService.deleteCompanyById(id);
        return new ResultDTO(flag);
    }

    //=============================
    @GetMapping("wareCompany/getExpert")
    public List<WareExpert> getExpert(@RequestParam(value = "companyId") Integer companyId) {
        List<WareExpert> flag = companyService.getExpert(companyId);
        return flag;
    }
}
