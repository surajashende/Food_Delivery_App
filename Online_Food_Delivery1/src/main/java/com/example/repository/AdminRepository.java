package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.entities.Admin;


@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
	@Query("select a from Admin a where a.email_id =:email_id and a.password =:password")
   	Admin findByEmailandPassword(String email_id,String password);


}
