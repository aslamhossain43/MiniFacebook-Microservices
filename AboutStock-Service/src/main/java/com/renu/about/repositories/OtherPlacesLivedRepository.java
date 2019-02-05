package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.OtherPlacesLived;

public interface OtherPlacesLivedRepository extends JpaRepository<OtherPlacesLived, Long>,JpaSpecificationExecutor<OtherPlacesLived> {

}
