package com.mediahub.editorial.controller;

import com.mediahub.editorial.model.EditorialReview;
import com.mediahub.editorial.service.EditorialReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/MediaHub/editorial")
public class EditorialReviewController {

    @Autowired
    private EditorialReviewService service;

    // API 1 — POST /MediaHub/editorial/reviews
    @PostMapping("/reviews")
    public ResponseEntity<Map<String, Object>> submitReview(
            @RequestBody EditorialReview review) {
        Map<String, Object> response = service.submitReview(review);
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // API 2 — GET /MediaHub/editorial/reviews
    @GetMapping("/reviews")
    public ResponseEntity<List<EditorialReview>> getAllReviews() {
        return ResponseEntity.ok(service.getAllReviews());
    }

    // API 3 — GET /MediaHub/editorial/reviews/{reviewID}
    @GetMapping("/reviews/{reviewID}")
    public ResponseEntity<EditorialReview> getReviewById(
            @PathVariable int reviewID) {
        return ResponseEntity.ok(service.getReviewById(reviewID));
    }

    // API 4 — POST /MediaHub/editorial/reviews/{reviewID}/approve
    @PostMapping("/reviews/{reviewID}/approve")
    public ResponseEntity<Map<String, Object>> approveReview(
            @PathVariable int reviewID,
            @RequestBody Map<String, String> body) {
        Map<String, Object> response = service.approveReview(
                reviewID, body.get("remarks"));
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // API 5 — POST /MediaHub/editorial/reviews/{reviewID}/reject
    @PostMapping("/reviews/{reviewID}/reject")
    public ResponseEntity<Map<String, Object>> rejectReview(
            @PathVariable int reviewID,
            @RequestBody Map<String, String> body) {
        Map<String, Object> response = service.rejectReview(
                reviewID, body.get("remarks"));
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }

    // API 6 — POST /MediaHub/editorial/reviews/{reviewID}/revise
    @PostMapping("/reviews/{reviewID}/revise")
    public ResponseEntity<Map<String, Object>> requestRevision(
            @PathVariable int reviewID,
            @RequestBody Map<String, String> body) {
        Map<String, Object> response = service.requestRevision(
                reviewID, body.get("remarks"));
        int code = (int) response.remove("statusCode");
        return ResponseEntity.status(code).body(response);
    }
}
