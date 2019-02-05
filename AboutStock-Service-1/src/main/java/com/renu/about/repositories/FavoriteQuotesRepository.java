package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.FavoriteQoutes;

public interface FavoriteQuotesRepository extends JpaRepository<FavoriteQoutes, Long>,JpaSpecificationExecutor<FavoriteQoutes>{

}
