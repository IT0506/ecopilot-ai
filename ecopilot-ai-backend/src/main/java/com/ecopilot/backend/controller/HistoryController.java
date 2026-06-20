package com.ecopilot.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecopilot.backend.dto.ApiResponse;
import com.ecopilot.backend.entity.CarbonAssessment;
import com.ecopilot.backend.service.CarbonService;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "http://localhost:5173")
public class HistoryController {

    private final CarbonService carbonService;

    public HistoryController(CarbonService carbonService) {
        this.carbonService = carbonService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CarbonAssessment>>> getHistory() {

        List<CarbonAssessment> history = carbonService.getAllAssessments();

        ApiResponse<List<CarbonAssessment>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("History fetched successfully.");
        response.setData(history);

        return ResponseEntity.ok(response);
    }
}