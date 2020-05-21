package com.dl.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2020/5/18.
 */

public interface CheckLoginMapper {
    @Select("select password from user where username=#{username}")
    public String findPwdByUname(String username);
}
