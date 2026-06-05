package com.mediahub.subscription.controller;

import com.mediahub.subscription.model.SubscriptionPlan;
import com.mediahub.subscription.model.UserSubscription;
import com.mediahub.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/MediaHub/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    // ── SubscriptionPlan APIs ────────────────────────────────────────────────

    // POST /MediaHub/subscription/plans — Create new plan
    @PostMapping("/plans")
    public ResponseEntity<Map<String, Object>> createPlan(
            @RequestBody SubscriptionPlan plan) {
        Map<String, Object> response = service.createPlan(plan);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // GET /MediaHub/subscription/plans — Get all plans
    @GetMapping("/plans")
    public ResponseEntity<List<SubscriptionPlan>> getAllPlans() {
        return ResponseEntity.ok(service.getAllPlans());
    }

    // GET /MediaHub/subscription/plans/{planID} — Get plan by ID
    @GetMapping("/plans/{planID}")
    public ResponseEntity<SubscriptionPlan> getPlanById(
            @PathVariable int planID) {
        return ResponseEntity.ok(service.getPlanById(planID));
    }

    // POST /MediaHub/subscription/plans/{planID}/discontinue — Discontinue plan
    @PostMapping("/plans/{planID}/discontinue")
    public ResponseEntity<Map<String, Object>> discontinuePlan(
            @PathVariable int planID) {
        Map<String, Object> response = service.discontinuePlan(planID);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // DELETE /MediaHub/subscription/plans/{planID} — Delete plan
    @DeleteMapping("/plans/{planID}")
    public ResponseEntity<Map<String, Object>> deletePlan(
            @PathVariable int planID) {
        Map<String, Object> response = service.deletePlan(planID);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // ── UserSubscription APIs ────────────────────────────────────────────────

    // POST /MediaHub/subscription/subscriptions — Create new subscription
    @PostMapping("/subscriptions")
    public ResponseEntity<Map<String, Object>> createSubscription(
            @RequestBody UserSubscription subscription) {
        Map<String, Object> response = service.createSubscription(subscription);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // GET /MediaHub/subscription/subscriptions — Get all subscriptions
    @GetMapping("/subscriptions")
    public ResponseEntity<List<UserSubscription>> getAllSubscriptions() {
        return ResponseEntity.ok(service.getAllSubscriptions());
    }

    // GET /MediaHub/subscription/subscriptions/{subscriptionID} — Get by ID
    @GetMapping("/subscriptions/{subscriptionID}")
    public ResponseEntity<UserSubscription> getSubscriptionById(
            @PathVariable int subscriptionID) {
        return ResponseEntity.ok(service.getSubscriptionById(subscriptionID));
    }

    // POST /MediaHub/subscription/subscriptions/{subscriptionID}/cancel
    @PostMapping("/subscriptions/{subscriptionID}/cancel")
    public ResponseEntity<Map<String, Object>> cancelSubscription(
            @PathVariable int subscriptionID) {
        Map<String, Object> response = service.cancelSubscription(subscriptionID);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // POST /MediaHub/subscription/subscriptions/{subscriptionID}/suspend
    @PostMapping("/subscriptions/{subscriptionID}/suspend")
    public ResponseEntity<Map<String, Object>> suspendSubscription(
            @PathVariable int subscriptionID) {
        Map<String, Object> response = service.suspendSubscription(subscriptionID);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // POST /MediaHub/subscription/subscriptions/{subscriptionID}/renew
    @PostMapping("/subscriptions/{subscriptionID}/renew")
    public ResponseEntity<Map<String, Object>> renewSubscription(
            @PathVariable int subscriptionID) {
        Map<String, Object> response = service.renewSubscription(subscriptionID);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }
}
