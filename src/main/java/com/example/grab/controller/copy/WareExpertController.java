package com.example.grab.controller.copy;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.entity.copy.WareCompany;
import com.example.grab.entity.copy.WareExpert;
import com.example.grab.service.IExpertService;
import com.example.grab.service.copy.IWareExpertService;
import com.example.grab.vo.ExpertSaveVo;
import com.example.grab.vo.Response.DataVo;
import com.example.grab.vo.Response.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WareExpertController {
    @Autowired
    private IWareExpertService expertService;
    @PostMapping("/wareExpert/add")
    public ResultDTO addExpert(@RequestBody ExpertSaveVo saveVo){
        ResultDTO flag = expertService.addExpert(saveVo);
        return flag;
    }
    @PostMapping("/wareExpert/update")
    public ResultDTO<Boolean> updateExpertById(@RequestBody WareExpert expert){
        Boolean flag = expertService.updateExpertById(expert);
        return new ResultDTO(flag);
    }
    @GetMapping("/wareExpert/delete")
    public ResultDTO<Boolean> deleteExpertById(@RequestParam(value="id") Integer id){
        Boolean flag = expertService.deleteExpertById(id);
        return new ResultDTO(flag);
    }
    @GetMapping("/wareExpert/get")
    public ResultDTO<List<WareExpert>> getExpertList(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit){
        ResultDTO<List<WareExpert>> flag = expertService.getExpertList(page,limit);
        return flag;
    }

    //=============================
    @GetMapping("/wareExpert/getCompany")
    public List<WareCompany> getCompany(@RequestParam(value = "expertId") Integer expertId) {
        List<WareCompany> flag = expertService.getCompany(expertId);
        return flag;
    }
    @GetMapping("/wareExpert/getUser")
    public List<DataVo> getUser(){
        List<DataVo> flag = expertService.getUser();
        return flag;
    }

}
