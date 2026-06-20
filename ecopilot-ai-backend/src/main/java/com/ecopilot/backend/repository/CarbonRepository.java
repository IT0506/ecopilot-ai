package com.ecopilot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecopilot.backend.entity.CarbonAssessment;

@Repository
public interface CarbonRepository
        extends JpaRepository<CarbonAssessment, Long> {

    List<CarbonAssessment> findAllByOrderByCreatedAtDesc();

}