package com.deepak.demo_deployement_app.controller;

import com.deepak.demo_deployement_app.entity.DemoUser;
import com.deepak.demo_deployement_app.repository.DemoRepo;
import com.deepak.demo_deployement_app.service.IDemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class DemoController {

    private final IDemoService demoService;
    private final DemoRepo demoRepo;

    public DemoController(IDemoService demoService, DemoRepo demoRepo) {
        this.demoService = demoService;
        this.demoRepo = demoRepo;
    }

    // Create User
    @PostMapping
    public DemoUser createUser(@RequestBody DemoUser demoUser) {
        return demoService.createUser(demoUser);
    }

    // Get User by Id
    @GetMapping("/{id}")
    public DemoUser getUserById(@PathVariable Long id) {
        return demoService.getUserById(id);
    }

    // Update User
    @PutMapping("/{id}")
    public DemoUser updateUser(@PathVariable Long id, @RequestBody DemoUser demoUser) {
        return demoService.updateUser(id, demoUser);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return demoService.deleteUser(id);
    }

    //GetAll
    @GetMapping
    public List<DemoUser> getUsers() {
        return demoRepo.findAll();
    }
}