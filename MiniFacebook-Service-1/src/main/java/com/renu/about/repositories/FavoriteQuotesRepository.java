package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.FavoriteQoutes;

public interface FavoriteQuotesRepository extends JpaRepository<FavoriteQoutes, Long>,JpaSpecificationExecutor<FavoriteQoutes>{
	 FavoriteQoutes getById(Long id);
		// GET BY UID
		static final String getAllFavoriteQoutesByUID ="FROM FavoriteQoutes WHERE uid=:uid ORDER BY id DESC";
		@Query(getAllFavoriteQoutesByUID)
		public List<FavoriteQoutes>getAllWorkplacesByUID(@Param("uid")String uid);

}
