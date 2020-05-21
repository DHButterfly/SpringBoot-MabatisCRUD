package com.dl.exception;

/**
 * Created by Administrator on 2020/5/11.
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("用户不存在!!!");
    }
}
