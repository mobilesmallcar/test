package com.example.grab.controller;

import com.example.grab.service.IRelationService;
import com.example.grab.vo.ExpertSaveVo;
import com.example.grab.vo.RelationSaveVo;
import com.example.grab.vo.Response.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelationController {

    @Autowired
    private IRelationService relationService;
    @PostMapping("/relation/add")
    public ResultDTO addRelation(@RequestBody RelationSaveVo saveVo){
        Boolean flag = relationService.addRelation(saveVo);
        return new ResultDTO(flag);
    }
    @GetMapping("/relation/delete")
    public ResultDTO deleteRelation(@RequestParam("companyId")Integer companyId){
        Boolean flag = relationService.deleteRelation(companyId);
        return new ResultDTO(flag);
    }
}
