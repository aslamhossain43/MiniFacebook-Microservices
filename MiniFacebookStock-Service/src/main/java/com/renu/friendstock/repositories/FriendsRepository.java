package com.renu.friendstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.friendstock.models.FriendsEntity;

public interface FriendsRepository extends JpaRepository<FriendsEntity, Long>,JpaSpecificationExecutor<FriendsEntity> {
FriendsEntity getById(Long id);
//------------------------------------------------------------------------------------------------------------------
String GET_FROM_AGREE="FROM FriendsEntity WHERE fromUid=:fromUid AND toUid=:toUid";
@Query(GET_FROM_AGREE)
FriendsEntity getFromAgree(@Param("fromUid")String fromUid,@Param("toUid")String toUid);
//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------

}
