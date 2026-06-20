package com.ecopilot.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecopilot.backend.dto.ApiResponse;
import com.ecopilot.backend.dto.DashboardResponse;
import com.ecopilot.backend.service.CarbonService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    private final CarbonService carbonService;

    public DashboardController(CarbonService carbonService) {
        this.carbonService = carbonService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<DashboardResponse>> getDashboard() {

        DashboardResponse dashboard = carbonService.getDashboardData();

        ApiResponse<DashboardResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Dashboard loaded successfully.");
        response.setData(dashboard);

        return ResponseEntity.ok(response);
    }
}