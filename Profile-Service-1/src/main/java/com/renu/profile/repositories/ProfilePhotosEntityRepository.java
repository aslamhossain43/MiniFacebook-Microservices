package com.renu.profile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.profile.models.ProfilePhotosEntity;

public interface ProfilePhotosEntityRepository extends JpaRepository<ProfilePhotosEntity, Long>,JpaSpecificationExecutor<ProfilePhotosEntity> {
ProfilePhotosEntity getById(Long id);
}
