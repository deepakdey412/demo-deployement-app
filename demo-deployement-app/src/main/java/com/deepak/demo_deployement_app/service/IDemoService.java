package com.deepak.demo_deployement_app.service;

import com.deepak.demo_deployement_app.entity.DemoUser;
import org.apache.catalina.User;

public interface IDemoService {
    DemoUser createUser(DemoUser demoUser);
    DemoUser getUserById(Long id);
    DemoUser updateUser(Long id , DemoUser demoUser);
    String deleteUser(Long id);
}
