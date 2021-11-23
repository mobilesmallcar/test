package com.example.grab.service;

import com.example.grab.vo.Response.DataVo;

import java.util.List;

public interface IUserService {
    List<DataVo> getAllPeople();
}
