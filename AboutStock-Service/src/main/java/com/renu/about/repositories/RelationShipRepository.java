package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.RelationShip;

public interface RelationShipRepository  extends JpaRepository<RelationShip, Long>,JpaSpecificationExecutor<RelationShip>{

}
