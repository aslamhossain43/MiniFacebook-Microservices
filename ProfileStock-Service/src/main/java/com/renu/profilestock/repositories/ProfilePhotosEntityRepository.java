package com.renu.profilestock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.profilestock.models.ProfilePhotosEntity;

public interface ProfilePhotosEntityRepository extends JpaRepository<ProfilePhotosEntity, Long>,JpaSpecificationExecutor<ProfilePhotosEntity> {
ProfilePhotosEntity getById(Long id);
//GET ALL PROFILE PHOTOS USING UID
static final String ALL_PROFILE_PHOTOS_BY_UID="FROM ProfilePhotosEntity where uid=:uid";
@Query(ALL_PROFILE_PHOTOS_BY_UID)
List<ProfilePhotosEntity>getAllProfilePhotosByUid(@Param("uid") String uid);
//GET SINGLE PROFILE PHOTO USING UID
static final String SINGLE_PROFILE_PHOTO_BY_UID="FROM ProfilePhotosEntity where uid=:uid";
@Query(SINGLE_PROFILE_PHOTO_BY_UID)
List<ProfilePhotosEntity> getSingleProfilePhotoByUid(@Param("uid") String uid);
}
