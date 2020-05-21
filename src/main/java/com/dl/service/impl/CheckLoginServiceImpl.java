package com.dl.service.impl;

import com.dl.mapper.CheckLoginMapper;
import com.dl.service.CheckLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/5/18.
 */
@Service
public class CheckLoginServiceImpl implements CheckLoginService {
    @Autowired
    private CheckLoginMapper checkLoginMapper;
    @Override
    public String getPassword(String username) {
        return checkLoginMapper.findPwdByUname(username);
    }
}
