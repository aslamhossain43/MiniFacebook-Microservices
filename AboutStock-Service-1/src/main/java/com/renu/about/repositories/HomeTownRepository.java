package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.HomeTown;

public interface HomeTownRepository extends JpaRepository<HomeTown,Long>,JpaSpecificationExecutor<HomeTown> {

}
