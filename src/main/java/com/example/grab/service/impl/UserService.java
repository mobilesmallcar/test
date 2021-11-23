package com.example.grab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.grab.entity.User;
import com.example.grab.mapper.UserMapper;
import com.example.grab.service.IUserService;
import com.example.grab.vo.Response.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<DataVo> getAllPeople() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<User> users = userMapper.selectList(queryWrapper);
        List<DataVo> responses = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            DataVo dataVo = new DataVo();
            User user = users.get(i);
            dataVo.setName(user.getName());
            if(user.getName()==null){
                dataVo.setName("shaw"+i);
            }
            dataVo.setPhone(user.getEmail());
            responses.add(dataVo);
        }
        return responses;
    }
}
