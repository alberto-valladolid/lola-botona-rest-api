package com.lolabotona.restapi.repository;

import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lolabotona.restapi.model.Group;
import com.lolabotona.restapi.model.User;
import com.lolabotona.restapi.model.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {	

//  ejemplo funcionando con nativeQuery	
//	@Query(value = "SELECT * FROM user_group  WHERE groupid = ?1 and userid = ?2 and type = ?3", nativeQuery = true)
//	 UserGroup asdf(  String group, String user ,String type );
	
//ejemplo funcionando con JPQL
//	@Query("SELECT u FROM UserGroup u WHERE u.group = ?1 and u.user = ?2 and u.type = ?3")
//	List<UserGroup> asdf(  Group group, User user ,String type );
	
	Optional<UserGroup> findByUserAndGroupAndType(User user, Group group, String type);	
	Optional<UserGroup> findByUserAndGroupAndTypeAndDateat(User user, Group group, String type,Timestamp dateAt);
	
	
	@Query(value = "SELECT * FROM user_group ", nativeQuery = true)
	List<UserGroup> getAllCustom();
	
	List<UserGroup> findByGroupIn(List<Group> group);	
	
	//List<UserGroup> findByGroupAndUserAndType(Group group,User user,  String type);	
	List<UserGroup> findByUserAndGroup(User user, Group group);	
	
	List<UserGroup> findByGroupAndType( Group group, String type );
	List<UserGroup> findByGroupAndTypeAndDateat( Group group, String type,Timestamp dateAt );
		
	int countByTypeAndUserAndRetrievedAndDateatBetween(String type,User user,boolean retrieve,Timestamp start,Timestamp end );	 
	Optional<UserGroup> findTop1ByTypeAndUserAndRetrievedAndDateatBetweenOrderByDateat(String type,User user,boolean retrieve,Timestamp start,Timestamp end );
	List<UserGroup> findByTypeAndUserAndRetrievedAndDateatBetween(String type,User user,boolean retrieve,Timestamp start,Timestamp end );	
	
	List<UserGroup> findByGroupInAndUserInAndTypeInAndDateatBetweenOrderByDateat( List<Group> groups,List<User> users, List<String> types,Timestamp start,Timestamp end );
	List<UserGroup> findByGroupInAndUserInAndType( List<Group> groups,List<User> users, String type );

	
}