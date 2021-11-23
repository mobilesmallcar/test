package com.example.grab.controller.copy;

import com.example.grab.service.IRelationService;
import com.example.grab.service.copy.IWareRelationService;
import com.example.grab.vo.RelationSaveVo;
import com.example.grab.vo.Response.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WareRelationController {

    @Autowired
    private IWareRelationService relationService;
    @PostMapping("/wareRelation/add")
    public ResultDTO addRelation(@RequestBody RelationSaveVo saveVo){
        Boolean flag = relationService.addRelation(saveVo);
        return new ResultDTO(flag);
    }
    @GetMapping("/wareRelation/delete")
    public ResultDTO deleteRelation(@RequestParam("companyId")Integer companyId){
        Boolean flag = relationService.deleteRelation(companyId);
        return new ResultDTO(flag);
    }
}
