package com.deepak.demo_deployement_app.service.impl;

import com.deepak.demo_deployement_app.entity.DemoUser;
import com.deepak.demo_deployement_app.repository.DemoRepo;
import com.deepak.demo_deployement_app.service.IDemoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoServiceImpl implements IDemoService {

    private final DemoRepo demoRepo;

    public DemoServiceImpl(DemoRepo demoRepo) {
        this.demoRepo = demoRepo;
    }


    @Override
    public DemoUser createUser(DemoUser demoUser) {
        DemoUser foundUser = demoRepo.findByEmail(demoUser.getEmail());
        if (foundUser != null) {
            throw new RuntimeException("User with email " + demoUser.getEmail() + " already exists");
        }
        demoRepo.save(demoUser);
        return demoUser;
    }

    @Override
    public DemoUser getUserById(Long id) {
        Optional<DemoUser> foundUser = demoRepo.findById(id);
        if (foundUser.isEmpty()) {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
        return foundUser.get();
    }

    @Override
    public DemoUser updateUser(Long id, DemoUser demoUser) {
        Optional<DemoUser> foundUser = demoRepo.findById(id);
        if (foundUser.isEmpty()) {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
        foundUser.get().setFirstName(demoUser.getFirstName());
        foundUser.get().setLastName(demoUser.getLastName());
        foundUser.get().setEmail(demoUser.getEmail());

        demoRepo.save(foundUser.get());
        return foundUser.get();
    }

    @Override
    public String deleteUser(Long id) {
        Optional<DemoUser> foundUser = demoRepo.findById(id);
        if (foundUser.isEmpty()) {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
        demoRepo.delete(foundUser.get());
        return " User Deleted Successfully";
    }
}
