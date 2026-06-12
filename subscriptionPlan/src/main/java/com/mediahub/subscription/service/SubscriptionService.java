package com.mediahub.subscription.service;

import com.mediahub.subscription.model.SubscriptionPlan;
import com.mediahub.subscription.model.UserSubscription;
import com.mediahub.subscription.repository.SubscriptionPlanRepository;
import com.mediahub.subscription.repository.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionPlanRepository planRepository;

    @Autowired
    private UserSubscriptionRepository subscriptionRepository;

    // ── SubscriptionPlan operations ──────────────────────────────────────────

    // Create new plan
    public Map<String, Object> createPlan(SubscriptionPlan plan) {
        Map<String, Object> response = new HashMap<>();
        if (plan.getName() == null || plan.getName().isEmpty()) {
            response.put("error", "Plan name is required");
            response.put("statusCode", 400);
            return response;
        }
        int result = planRepository.save(plan);
        if (result > 0) {
            response.put("name", plan.getName());
            response.put("price", plan.getPrice());
            response.put("billingCycle", plan.getBillingCycle());
            response.put("status", "Active");
            response.put("message", "Subscription plan created successfully");
            response.put("statusCode", 201);
        } else {
            response.put("error", "Failed to create plan");
            response.put("statusCode", 500);
        }
        return response;
    }

    // Get all plans
    public List<SubscriptionPlan> getAllPlans() {
        return planRepository.findAll();
    }

    // Get plan by ID
    public SubscriptionPlan getPlanById(int planID) {
        return planRepository.findById(planID);
    }

    // Discontinue a plan
    public Map<String, Object> discontinuePlan(int planID) {
        Map<String, Object> response = new HashMap<>();
        int result = planRepository.updateStatus(planID, "Discontinued");
        if (result > 0) {
            response.put("planID", planID);
            response.put("status", "Discontinued");
            response.put("message", "Plan discontinued successfully");
            response.put("statusCode", 200);
        } else {
            response.put("error", "Plan not found");
            response.put("statusCode", 404);
        }
        return response;
    }

    // Delete a plan
    public Map<String, Object> deletePlan(int planID) {
        Map<String, Object> response = new HashMap<>();
        int result = planRepository.delete(planID);
        if (result > 0) {
            response.put("planID", planID);
            response.put("message", "Plan deleted successfully");
            response.put("statusCode", 200);
        } else {
            response.put("error", "Plan not found");
            response.put("statusCode", 404);
        }
        return response;
    }

    // ── UserSubscription operations ──────────────────────────────────────────

    // Create new subscription
    public Map<String, Object> createSubscription(UserSubscription subscription) {
        Map<String, Object> response = new HashMap<>();
        if (subscription.getUserID() == 0) {
            response.put("error", "UserID is required");
            response.put("statusCode", 400);
            return response;
        }
        if (subscription.getPlanID() == 0) {
            response.put("error", "PlanID is required");
            response.put("statusCode", 400);
            return response;
        }
        if (subscription.getStartDate() == null) {
            subscription.setStartDate(new Date());
        }
        subscription.setStatus("Active");
        int result = subscriptionRepository.save(subscription);
        if (result > 0) {
            response.put("userID", subscription.getUserID());
            response.put("planID", subscription.getPlanID());
            response.put("startDate", subscription.getStartDate());
            response.put("renewalType", subscription.getRenewalType());
            response.put("status", "Active");
            response.put("message", "Subscription created successfully");
            response.put("statusCode", 201);
        } else {
            response.put("error", "Failed to create subscription");
            response.put("statusCode", 500);
        }
        return response;
    }

    // Get all subscriptions
    public List<UserSubscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // Get subscription by ID
    public UserSubscription getSubscriptionById(int subscriptionID) {
        return subscriptionRepository.findById(subscriptionID);
    }

    // Cancel subscription
    public Map<String, Object> cancelSubscription(int subscriptionID) {
        Map<String, Object> response = new HashMap<>();
        int result = subscriptionRepository.updateStatus(subscriptionID, "Cancelled");
        if (result > 0) {
            response.put("subscriptionID", subscriptionID);
            response.put("status", "Cancelled");
            response.put("message", "Subscription cancelled successfully");
            response.put("statusCode", 200);
        } else {
            response.put("error", "Subscription not found");
            response.put("statusCode", 404);
        }
        return response;
    }

    // Suspend subscription
    public Map<String, Object> suspendSubscription(int subscriptionID) {
        Map<String, Object> response = new HashMap<>();
        int result = subscriptionRepository.updateStatus(subscriptionID, "Suspended");
        if (result > 0) {
            response.put("subscriptionID", subscriptionID);
            response.put("status", "Suspended");
            response.put("message", "Subscription suspended successfully");
            response.put("statusCode", 200);
        } else {
            response.put("error", "Subscription not found");
            response.put("statusCode", 404);
        }
        return response;
    }

    // Renew subscription
    public Map<String, Object> renewSubscription(int subscriptionID) {
        Map<String, Object> response = new HashMap<>();
        int result = subscriptionRepository.updateStatus(subscriptionID, "Active");
        if (result > 0) {
            response.put("subscriptionID", subscriptionID);
            response.put("status", "Active");
            response.put("message", "Subscription renewed successfully");
            response.put("statusCode", 200);
        } else {
            response.put("error", "Subscription not found");
            response.put("statusCode", 404);
        }
        return response;
    }
}
