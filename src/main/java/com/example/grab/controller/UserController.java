package com.example.grab.controller;

import com.example.grab.service.IUserService;
import com.example.grab.vo.Response.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;
    @GetMapping("/get")
    public List<DataVo> get(){
        List<DataVo> list = userService.getAllPeople();
        return list;
    }
}
