package com.ecopilot.backend.service;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String generateRecommendation(String majorSource,
                                         String grade) {

        StringBuilder recommendation = new StringBuilder();

        switch (majorSource) {

            case "Transportation":

                recommendation.append(
                        "Use public transport, carpool, cycle, or walk whenever possible. ");

                break;

            case "Electricity":

                recommendation.append(
                        "Reduce electricity consumption by switching off appliances and using LED lighting. ");

                break;

            case "Diet":

                recommendation.append(
                        "Reduce red meat consumption and include more plant-based meals every week. ");

                break;

            case "Air Travel":

                recommendation.append(
                        "Reduce unnecessary flights and choose trains for shorter distances whenever possible. ");

                break;

            case "Plastic Usage":

                recommendation.append(
                        "Replace single-use plastics with reusable bottles, bags, and containers. ");

                break;

            default:

                recommendation.append(
                        "Maintain your sustainable lifestyle and continue reducing emissions. ");

        }

        switch (grade) {

            case "A":

                recommendation.append(
                        "Excellent work! Continue inspiring others.");

                break;

            case "B":

                recommendation.append(
                        "You are doing well. Small improvements can make a big difference.");

                break;

            case "C":

                recommendation.append(
                        "Focus on reducing your biggest emission source over the next month.");

                break;

            case "D":

                recommendation.append(
                        "Your emissions are above average. Start with transport and electricity savings.");

                break;

            default:

                recommendation.append(
                        "Immediate lifestyle changes are recommended to reduce your environmental impact.");

        }

        return recommendation.toString();
    }
}
