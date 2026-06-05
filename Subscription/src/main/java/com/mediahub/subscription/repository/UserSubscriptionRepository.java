package com.mediahub.subscription.repository;

import com.mediahub.subscription.model.UserSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSubscriptionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save new subscription
    public int save(UserSubscription subscription) {
        String sql = "INSERT INTO UserSubscription " +
                     "(UserID, PlanID, StartDate, EndDate, RenewalType, Status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                subscription.getUserID(),
                subscription.getPlanID(),
                subscription.getStartDate(),
                subscription.getEndDate(),
                subscription.getRenewalType(),
                subscription.getStatus());
    }

    // Find all subscriptions
    public List<UserSubscription> findAll() {
        String sql = "SELECT * FROM UserSubscription";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserSubscription s = new UserSubscription();
            s.setSubscriptionID(rs.getInt("SubscriptionID"));
            s.setUserID(rs.getInt("UserID"));
            s.setPlanID(rs.getInt("PlanID"));
            s.setStartDate(rs.getDate("StartDate"));
            s.setEndDate(rs.getDate("EndDate"));
            s.setRenewalType(rs.getString("RenewalType"));
            s.setStatus(rs.getString("Status"));
            return s;
        });
    }

    // Find by subscriptionID
    public UserSubscription findById(int subscriptionID) {
        String sql = "SELECT * FROM UserSubscription WHERE SubscriptionID = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UserSubscription s = new UserSubscription();
            s.setSubscriptionID(rs.getInt("SubscriptionID"));
            s.setUserID(rs.getInt("UserID"));
            s.setPlanID(rs.getInt("PlanID"));
            s.setStatus(rs.getString("Status"));
            return s;
        }, subscriptionID);
    }

    // Update subscription status
    public int updateStatus(int subscriptionID, String status) {
        String sql = "UPDATE UserSubscription SET Status = ? WHERE SubscriptionID = ?";
        return jdbcTemplate.update(sql, status, subscriptionID);
    }
}
