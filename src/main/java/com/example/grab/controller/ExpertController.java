package com.example.grab.controller;

import com.example.grab.entity.Company;
import com.example.grab.entity.Expert;
import com.example.grab.service.IExpertService;
import com.example.grab.vo.Response.DataVo;
import com.example.grab.vo.ExpertSaveVo;
import com.example.grab.vo.Response.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ExpertController {
    @Autowired
    private IExpertService expertService;
    @PostMapping("/expert/add")
    public ResultDTO addExpert(@RequestBody ExpertSaveVo saveVo){
        ResultDTO flag = expertService.addExpert(saveVo);
        return flag;
    }
    @PostMapping("expert/update")
    public ResultDTO<Boolean> updateExpertById(@RequestBody Expert expert){
        Boolean flag = expertService.updateExpertById(expert);
        return new ResultDTO(flag);
    }
    @GetMapping("/expert/delete")
    public ResultDTO<Boolean> deleteExpertById(@RequestParam(value="id") Integer id){
        Boolean flag = expertService.deleteExpertById(id);
        return new ResultDTO(flag);
    }
    @GetMapping("/expert/get")
    public ResultDTO<List<Expert>> getExpertList(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit){
        ResultDTO<List<Expert>> flag = expertService.getExpertList(page,limit);
        return flag;
    }

    //=============================
    @GetMapping("company/getCompany")
    public List<Company> getCompany(@RequestParam(value = "expertId") Integer expertId) {
        List<Company> flag = expertService.getCompany(expertId);
        return flag;
    }
    @GetMapping("/expert/getUser")
    public List<DataVo> getUser(){
        List<DataVo> flag = expertService.getUser();
        return flag;
    }

}
