package com.ecopilot.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecopilot.backend.dto.ApiResponse;
import com.ecopilot.backend.dto.CarbonRequest;
import com.ecopilot.backend.dto.CarbonResponse;
import com.ecopilot.backend.dto.DashboardResponse;
import com.ecopilot.backend.entity.CarbonAssessment;
import com.ecopilot.backend.service.CarbonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carbon")
@CrossOrigin(origins = "http://localhost:5173")
public class CarbonController {

    private final CarbonService carbonService;

    public CarbonController(CarbonService carbonService) {
        this.carbonService = carbonService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<ApiResponse<CarbonResponse>> calculateCarbonFootprint(
            @Valid @RequestBody CarbonRequest request) {

        CarbonResponse result = carbonService.calculateAndSaveAssessment(request);

        ApiResponse<CarbonResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Carbon footprint calculated successfully.");
        response.setData(result);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<DashboardResponse>> getDashboard() {

        DashboardResponse dashboard = carbonService.getDashboardData();

        ApiResponse<DashboardResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Dashboard loaded successfully.");
        response.setData(dashboard);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<List<CarbonAssessment>>> getHistory() {

        List<CarbonAssessment> history = carbonService.getAllAssessments();

        ApiResponse<List<CarbonAssessment>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("History fetched successfully.");
        response.setData(history);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CarbonAssessment>> getAssessment(@PathVariable Long id) {

        CarbonAssessment assessment = carbonService.getAssessmentById(id);

        ApiResponse<CarbonAssessment> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Assessment found.");
        response.setData(assessment);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteAssessment(@PathVariable Long id) {

        carbonService.deleteAssessment(id);

        ApiResponse<String> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Assessment deleted successfully.");
        response.setData("Deleted Successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public String health() {
        return "EcoPilot AI Backend Running Successfully 🚀";
    }
}