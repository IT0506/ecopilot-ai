package com.ecopilot.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarbonResponse {

    /**
     * Total calculated carbon footprint
     */
    private Double carbonScore;

    /**
     * Sustainability Grade (A-E)
     */
    private String sustainabilityGrade;

    /**
     * Highest emission contributor
     */
    private String majorEmissionSource;

    /**
     * Trees required to offset emissions
     */
    private Integer treesNeeded;

    /**
     * AI-generated sustainability recommendation
     */
    private String aiRecommendation;

	public Double getCarbonScore() {
		return carbonScore;
	}

	public void setCarbonScore(Double carbonScore) {
		this.carbonScore = carbonScore;
	}

	public String getSustainabilityGrade() {
		return sustainabilityGrade;
	}

	public void setSustainabilityGrade(String sustainabilityGrade) {
		this.sustainabilityGrade = sustainabilityGrade;
	}

	public String getMajorEmissionSource() {
		return majorEmissionSource;
	}

	public void setMajorEmissionSource(String majorEmissionSource) {
		this.majorEmissionSource = majorEmissionSource;
	}

	public Integer getTreesNeeded() {
		return treesNeeded;
	}

	public void setTreesNeeded(Integer treesNeeded) {
		this.treesNeeded = treesNeeded;
	}

	public String getAiRecommendation() {
		return aiRecommendation;
	}

	public void setAiRecommendation(String aiRecommendation) {
		this.aiRecommendation = aiRecommendation;
	}
    

}