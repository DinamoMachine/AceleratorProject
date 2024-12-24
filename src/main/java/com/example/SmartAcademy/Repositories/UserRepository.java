package com.example.SmartAcademy.Repositories;

import com.example.SmartAcademy.Models.Lesson;
import com.example.SmartAcademy.Models.SubscriptionPlan;
import com.example.SmartAcademy.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

