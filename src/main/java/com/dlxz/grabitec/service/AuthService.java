package com.dlxz.grabitec.service;

import com.dlxz.grabitec.entity.EcUser;

import java.util.Map;

public interface AuthService {

    Map<String, Object> login(String username, String password);

    Map<String, Object> register(String username, String password);
}
