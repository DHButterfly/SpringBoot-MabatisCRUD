package com.dl.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface RegisterMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
    void RegisterUser(String username,String password);

    @Select("select * from user where username=#{username}")
    String CheckRegister(String username);
}
