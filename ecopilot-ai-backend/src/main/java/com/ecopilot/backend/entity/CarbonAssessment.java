package com.ecopilot.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carbon_assessments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarbonAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 30)
    private String transport;

    @Column(nullable = false)
    private Double distance;

    @Column(nullable = false)
    private Double electricity;

    @Column(nullable = false, length = 30)
    private String diet;

    @Column(nullable = false)
    private Integer flights;

    @Column(nullable = false, length = 20)
    private String plasticUsage;

    @Column(nullable = false)
    private Double carbonScore;

    @Column(nullable = false, length = 2)
    private String grade;

    @Column(nullable = false, length = 50)
    private String majorSource;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * Automatically sets creation timestamp
     */
    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getElectricity() {
		return electricity;
	}

	public void setElectricity(Double electricity) {
		this.electricity = electricity;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public Integer getFlights() {
		return flights;
	}

	public void setFlights(Integer flights) {
		this.flights = flights;
	}

	public String getPlasticUsage() {
		return plasticUsage;
	}

	public void setPlasticUsage(String plasticUsage) {
		this.plasticUsage = plasticUsage;
	}

	public Double getCarbonScore() {
		return carbonScore;
	}

	public void setCarbonScore(Double carbonScore) {
		this.carbonScore = carbonScore;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajorSource() {
		return majorSource;
	}

	public void setMajorSource(String majorSource) {
		this.majorSource = majorSource;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    

}