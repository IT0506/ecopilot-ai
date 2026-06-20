package com.ecopilot.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    /**
     * Total number of assessments submitted
     */
    private long totalAssessments;

    /**
     * Average carbon footprint score
     */
    private double averageCarbonScore;

    /**
     * Lowest recorded carbon footprint
     */
    private double lowestCarbonScore;

    /**
     * Highest recorded carbon footprint
     */
    private double highestCarbonScore;

    /**
     * Overall sustainability grade (A-E)
     */
    private String sustainabilityGrade;

    /**
     * Total trees required to offset all emissions
     */
    private int totalTreesNeeded;

    /**
     * Most common emission source among all assessments
     */
    private String mostCommonEmissionSource;

	public long getTotalAssessments() {
		return totalAssessments;
	}

	public void setTotalAssessments(long totalAssessments) {
		this.totalAssessments = totalAssessments;
	}

	public double getAverageCarbonScore() {
		return averageCarbonScore;
	}

	public void setAverageCarbonScore(double averageCarbonScore) {
		this.averageCarbonScore = averageCarbonScore;
	}

	public double getLowestCarbonScore() {
		return lowestCarbonScore;
	}

	public void setLowestCarbonScore(double lowestCarbonScore) {
		this.lowestCarbonScore = lowestCarbonScore;
	}

	public double getHighestCarbonScore() {
		return highestCarbonScore;
	}

	public void setHighestCarbonScore(double highestCarbonScore) {
		this.highestCarbonScore = highestCarbonScore;
	}

	public String getSustainabilityGrade() {
		return sustainabilityGrade;
	}

	public void setSustainabilityGrade(String sustainabilityGrade) {
		this.sustainabilityGrade = sustainabilityGrade;
	}

	public int getTotalTreesNeeded() {
		return totalTreesNeeded;
	}

	public void setTotalTreesNeeded(int totalTreesNeeded) {
		this.totalTreesNeeded = totalTreesNeeded;
	}

	public String getMostCommonEmissionSource() {
		return mostCommonEmissionSource;
	}

	public void setMostCommonEmissionSource(String mostCommonEmissionSource) {
		this.mostCommonEmissionSource = mostCommonEmissionSource;
	}
    

}