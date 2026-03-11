package com.deepak.demo_deployement_app.repository;

import com.deepak.demo_deployement_app.entity.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepo extends JpaRepository<DemoUser , Long> {
    DemoUser findByEmail(String email);
}
