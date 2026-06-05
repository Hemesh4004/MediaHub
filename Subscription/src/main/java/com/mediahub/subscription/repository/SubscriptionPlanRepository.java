package com.mediahub.subscription.repository;

import com.mediahub.subscription.model.SubscriptionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionPlanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save new plan
    public int save(SubscriptionPlan plan) {
        String sql = "INSERT INTO SubscriptionPlan " +
                     "(Name, Price, BillingCycle, ContentAccessLevel, " +
                     "MaxDevices, DownloadAllowed, Status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                plan.getName(),
                plan.getPrice(),
                plan.getBillingCycle(),
                plan.getContentAccessLevel(),
                plan.getMaxDevices(),
                plan.isDownloadAllowed(),
                plan.getStatus());
    }

    // Find all plans
    public List<SubscriptionPlan> findAll() {
        String sql = "SELECT * FROM SubscriptionPlan";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SubscriptionPlan p = new SubscriptionPlan();
            p.setPlanID(rs.getInt("PlanID"));
            p.setName(rs.getString("Name"));
            p.setPrice(rs.getDouble("Price"));
            p.setBillingCycle(rs.getString("BillingCycle"));
            p.setContentAccessLevel(rs.getString("ContentAccessLevel"));
            p.setMaxDevices(rs.getInt("MaxDevices"));
            p.setDownloadAllowed(rs.getBoolean("DownloadAllowed"));
            p.setStatus(rs.getString("Status"));
            return p;
        });
    }

    // Find plan by ID
    public SubscriptionPlan findById(int planID) {
        String sql = "SELECT * FROM SubscriptionPlan WHERE PlanID = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            SubscriptionPlan p = new SubscriptionPlan();
            p.setPlanID(rs.getInt("PlanID"));
            p.setName(rs.getString("Name"));
            p.setPrice(rs.getDouble("Price"));
            p.setBillingCycle(rs.getString("BillingCycle"));
            p.setStatus(rs.getString("Status"));
            return p;
        }, planID);
    }

    // Update plan status
    public int updateStatus(int planID, String status) {
        String sql = "UPDATE SubscriptionPlan SET Status = ? WHERE PlanID = ?";
        return jdbcTemplate.update(sql, status, planID);
    }

    // Delete plan
    public int delete(int planID) {
        String sql = "DELETE FROM SubscriptionPlan WHERE PlanID = ?";
        return jdbcTemplate.update(sql, planID);
    }
}
