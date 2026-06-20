package com.ecopilot.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecopilot.backend.dto.CarbonRequest;
import com.ecopilot.backend.dto.CarbonResponse;
import com.ecopilot.backend.dto.DashboardResponse;
import com.ecopilot.backend.entity.CarbonAssessment;
import com.ecopilot.backend.exception.ResourceNotFoundException;
import com.ecopilot.backend.repository.CarbonRepository;

@Service
public class CarbonService {

    private final CarbonRepository carbonRepository;
    private final RecommendationService recommendationService;

    public CarbonService(CarbonRepository carbonRepository,
                         RecommendationService recommendationService) {
        this.carbonRepository = carbonRepository;
        this.recommendationService = recommendationService;
    }

    public CarbonResponse calculateAndSaveAssessment(CarbonRequest request) {

        double transportEmission =
                calculateTransportEmission(
                        request.getTransport(),
                        request.getDistance());

        double electricityEmission =
                calculateElectricityEmission(
                        request.getElectricity());

        double dietEmission =
                calculateDietEmission(
                        request.getDiet());

        double flightEmission =
                calculateFlightEmission(
                        request.getFlights());

        double plasticEmission =
                calculatePlasticEmission(
                        request.getPlasticUsage());

        double totalScore =
                transportEmission
                + electricityEmission
                + dietEmission
                + flightEmission
                + plasticEmission;

        String majorSource = "Transportation";
        double max = transportEmission;

        if (electricityEmission > max) {
            max = electricityEmission;
            majorSource = "Electricity";
        }

        if (dietEmission > max) {
            max = dietEmission;
            majorSource = "Diet";
        }

        if (flightEmission > max) {
            max = flightEmission;
            majorSource = "Air Travel";
        }

        if (plasticEmission > max) {
            max = plasticEmission;
            majorSource = "Plastic Usage";
        }

        String grade = calculateGrade(totalScore);

        int treesNeeded = (int) Math.ceil(totalScore / 25.0);

        String recommendation =
                recommendationService.generateRecommendation(
                        majorSource,
                        grade);

        CarbonAssessment assessment =
                new CarbonAssessment();

        assessment.setName(request.getName());
        assessment.setAge(request.getAge());
        assessment.setTransport(request.getTransport());
        assessment.setDistance(request.getDistance());
        assessment.setElectricity(request.getElectricity());
        assessment.setDiet(request.getDiet());
        assessment.setFlights(request.getFlights());
        assessment.setPlasticUsage(request.getPlasticUsage());

        assessment.setCarbonScore(totalScore);
        assessment.setGrade(grade);
        assessment.setMajorSource(majorSource);

        carbonRepository.save(assessment);

        CarbonResponse response =
                new CarbonResponse();

        response.setCarbonScore(
                Math.round(totalScore * 100.0) / 100.0);

        response.setSustainabilityGrade(grade);
        response.setMajorEmissionSource(majorSource);
        response.setTreesNeeded(treesNeeded);
        response.setAiRecommendation(recommendation);

        return response;
    }

    /**
     * Transport emission
     */
    private double calculateTransportEmission(String transport, Double distance) {

        if (transport == null || distance == null)
            return 0;

        switch (transport.toLowerCase()) {

        case "car":
            return distance * 0.18;

        case "bike":
            return distance * 0.02;

        case "bus":
            return distance * 0.08;

        case "metro":
            return distance * 0.05;

        case "bicycle":
            return 0;

        case "walk":
            return 0;

        default:
            return distance * 0.10;
    }
    }

    /**
     * Electricity emission
     */
    private double calculateElectricityEmission(
            Double electricity) {

        if (electricity == null)
            return 0;

        return electricity * 0.18;
    }

    /**
     * Diet emission
     */
    private double calculateDietEmission(
            String diet) {

        if (diet == null)
            return 0;

        switch (diet.toLowerCase()) {

        case "vegan":
            return 20;

        case "vegetarian":
            return 40;

        case "mixed":
            return 70;

        case "heavy meat":
            return 120;

        default:
            return 60;
    }
    }
    /**
     * Flight emission
     */
    private double calculateFlightEmission(Integer flights) {

        if (flights == null)
            return 0;

        return flights * 150;
    }

    /**
     * Plastic usage emission
     */
    private double calculatePlasticEmission(String plasticUsage) {

        if (plasticUsage == null)
            return 0;

        switch (plasticUsage.toLowerCase()) {

        case "low":
            return 10;

        case "medium":
            return 30;

        case "high":
            return 60;

        default:
            return 20;
    }
    }

    /**
     * Sustainability Grade
     */
    private String calculateGrade(double score) {

        if (score < 100)
            return "A";

        if (score < 180)
            return "B";

        if (score < 260)
            return "C";

        if (score < 350)
            return "D";

        return "E";
    }

    /**
     * Get all assessments
     */
    public List<CarbonAssessment> getAllAssessments() {

        return carbonRepository.findAll();

    }

    /**
     * Get assessment by ID
     */
    public CarbonAssessment getAssessmentById(Long id) {

        return carbonRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Assessment not found with id : " + id));

    }

    /**
     * Delete assessment
     */
    public void deleteAssessment(Long id) {

        CarbonAssessment assessment =
                getAssessmentById(id);

        carbonRepository.delete(assessment);

    }

    /**
     * Dashboard Statistics
     */
    public DashboardResponse getDashboardData() {

        List<CarbonAssessment> assessments =
                carbonRepository.findAll();

        DashboardResponse dashboard =
                new DashboardResponse();

        if (assessments.isEmpty()) {

            dashboard.setTotalAssessments(0);
            dashboard.setAverageCarbonScore(0);
            dashboard.setLowestCarbonScore(0);
            dashboard.setHighestCarbonScore(0);
            dashboard.setSustainabilityGrade("N/A");
            dashboard.setTotalTreesNeeded(0);
            dashboard.setMostCommonEmissionSource("N/A");

            return dashboard;
        }

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        int trees = 0;

        java.util.Map<String, Integer> sourceCount =
                new java.util.HashMap<>();

        for (CarbonAssessment assessment : assessments) {

            total += assessment.getCarbonScore();

            if (assessment.getCarbonScore() > highest)
                highest = assessment.getCarbonScore();

            if (assessment.getCarbonScore() < lowest)
                lowest = assessment.getCarbonScore();

            trees += (int) Math.ceil(
                    assessment.getCarbonScore() / 25.0);

            sourceCount.put(
                    assessment.getMajorSource(),
                    sourceCount.getOrDefault(
                            assessment.getMajorSource(),
                            0) + 1);

        }

        String commonSource = "";

        int maxCount = 0;

        for (java.util.Map.Entry<String, Integer> entry
                : sourceCount.entrySet()) {

            if (entry.getValue() > maxCount) {

                maxCount = entry.getValue();

                commonSource = entry.getKey();

            }

        }

        double average = total / assessments.size();

        dashboard.setTotalAssessments(
                assessments.size());

        dashboard.setAverageCarbonScore(
                Math.round(average * 100.0) / 100.0);

        dashboard.setLowestCarbonScore(lowest);

        dashboard.setHighestCarbonScore(highest);

        dashboard.setSustainabilityGrade(
                calculateGrade(average));

        dashboard.setTotalTreesNeeded(trees);

        dashboard.setMostCommonEmissionSource(
                commonSource);

        return dashboard;

    }

}

    // ---------- Continue below ----------