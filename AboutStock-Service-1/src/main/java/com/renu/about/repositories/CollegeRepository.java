package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.College;

public interface CollegeRepository extends JpaRepository<College,Long>,JpaSpecificationExecutor<College> {

}
