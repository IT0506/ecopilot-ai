package com.ecopilot.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarbonRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 10, message = "Age must be at least 10")
    @Max(value = 120, message = "Age cannot exceed 120")
    private Integer age;

    @NotBlank(message = "Transport mode is required")
    private String transport;

    @NotNull(message = "Distance is required")
    @Positive(message = "Distance must be greater than 0")
    private Double distance;

    @NotNull(message = "Electricity consumption is required")
    @Positive(message = "Electricity consumption must be greater than 0")
    private Double electricity;

    @NotBlank(message = "Diet type is required")
    private String diet;

    @NotNull(message = "Number of flights is required")
    @Min(value = 0, message = "Flights cannot be negative")
    private Integer flights;

    @NotBlank(message = "Plastic usage level is required")
    private String plasticUsage;

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
    

}