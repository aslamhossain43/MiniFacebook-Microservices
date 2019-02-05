package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.HighSchool;

public interface HighSchoolRepository extends JpaRepository<HighSchool, Long>,JpaSpecificationExecutor<HighSchool>{

}
