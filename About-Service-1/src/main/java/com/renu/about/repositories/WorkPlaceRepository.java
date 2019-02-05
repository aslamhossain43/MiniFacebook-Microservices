package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.Workplace;

public interface WorkPlaceRepository extends JpaRepository<Workplace,Long>,JpaSpecificationExecutor<Workplace> {

}
