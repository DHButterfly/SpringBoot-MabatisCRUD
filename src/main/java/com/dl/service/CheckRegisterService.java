package com.dl.service;

public interface CheckRegisterService {
    void RegisterUser(String username,String password);
    String CheckRegister(String username);
}
