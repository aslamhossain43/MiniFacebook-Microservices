package com.renu.friends.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.renu.friends.models.AddFriendsData;


public interface AddFriendsDataRepository extends JpaRepository<AddFriendsData, Long>,JpaSpecificationExecutor<AddFriendsData>{
	AddFriendsData getByUid(String uid);
	//-----------------------------------------------------------------------------------------------------------
AddFriendsData getById(String id);
//--------------------------------------------------------------------------------------------------------------
 static final String getAllAddFriendsData="FROM AddFriendsData ORDER BY id DESC";
@Query(getAllAddFriendsData)
List<AddFriendsData>getAllAddFriendsData();
}
