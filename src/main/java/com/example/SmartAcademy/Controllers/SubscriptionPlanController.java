package com.example.SmartAcademy.Controllers;

import com.example.SmartAcademy.Models.SubscriptionPlan;
import com.example.SmartAcademy.Repositories.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return subscriptionPlanRepository.findAll();
    }

    @PostMapping
    public SubscriptionPlan createPlan(@RequestBody SubscriptionPlan plan) {
        return subscriptionPlanRepository.save(plan);
    }
}
