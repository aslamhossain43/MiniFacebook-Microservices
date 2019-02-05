package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.CurrentCity;

public interface CurrentCityRepository extends JpaRepository<CurrentCity,Long>,JpaSpecificationExecutor<CurrentCity> {

}
