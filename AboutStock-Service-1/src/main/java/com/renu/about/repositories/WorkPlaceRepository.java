package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.Workplace;

public interface WorkPlaceRepository extends JpaRepository<Workplace,Long>,JpaSpecificationExecutor<Workplace> {
Workplace getById(Long id);
// GET BY UID
static final String getAllWorkplacesByUID ="FROM Workplace WHERE uid=:uid ORDER BY id DESC";
@Query(getAllWorkplacesByUID)
public List<Workplace>getAllWorkplacesByUID(@Param("uid")String uid);

}
