package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.entities.Rest_Owner;

@Repository
@EnableJpaRepositories
public interface Rest_OwnerRepository extends JpaRepository<Rest_Owner, Integer> {

	@Query("select a from Rest_Owner a where a.email =:email and a.password =:password")
	Rest_Owner findOwnerByEmailAndPassword(String email, String password);
	  
	
	// String saveOwnerDetails(Rest_Owner rest_owner);
//		
	@Query("select a from Rest_Owner a where a.owner_id=:owner_id")
        Rest_Owner getOwnerById(int owner_id);
        
       //@Query("update set Rest_O")	
	   // Rest_Owner updateownerDetails(Rest_Owner rest_owner);
//			
//	   String deleteOwnerDetails(int rest_owner_id);

}
