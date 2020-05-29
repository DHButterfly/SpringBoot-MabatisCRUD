package com.dl.service.impl;

import com.dl.mapper.RegisterMapper;
import com.dl.service.CheckRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckRegisterImpl implements CheckRegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public void RegisterUser(String username, String password) {
        registerMapper.RegisterUser(username,password);
    }

    @Override
    public String CheckRegister(String username) {
        return registerMapper.CheckRegister(username);
    }
}
