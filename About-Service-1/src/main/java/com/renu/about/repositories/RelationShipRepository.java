package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.RelationShip;

public interface RelationShipRepository  extends JpaRepository<RelationShip, Long>,JpaSpecificationExecutor<RelationShip>{
	RelationShip getById(Long id);
	// GET BY UID
	static final String getAllRelationShipByUID ="FROM RelationShip WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllRelationShipByUID)
	public List<RelationShip>getAllRelationShipByUID(@Param("uid")String uid);

}
