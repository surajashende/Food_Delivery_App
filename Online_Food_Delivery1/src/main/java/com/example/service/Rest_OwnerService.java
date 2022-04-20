package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Rest_Owner;
import com.example.entities.Role;
import com.example.repository.Rest_OwnerRepository;

@Service
public class Rest_OwnerService {
	
	@Autowired
	Rest_OwnerRepository rest_ownerrepo;
	
	public String saveOwnerDetails(Rest_Owner rest_owner) {
		Rest_Owner ownerDetails = rest_ownerrepo.save(rest_owner);
		return ownerDetails.getOwner_name()
				+", you have successfully registerd by Email id : "
				 +ownerDetails.getEmail();
	}
	
	public Rest_Owner ownerLogin(String email, String password) {
		
		return rest_ownerrepo.findOwnerByEmailAndPassword(email, password);
	}

	public Rest_Owner getOwnerById(int owner_id) {
		
		return rest_ownerrepo.findById(owner_id).get();
	}

	
	public Rest_Owner updateOwnerDetails(Rest_Owner rest_owner,int ownerId) {
		
		Rest_Owner rest_owner1=rest_ownerrepo.getOwnerById(ownerId);
		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
		
		    rest_owner1.setPassword(rest_owner.getPassword());
		    rest_owner1.setEmail(rest_owner.getEmail());
		    rest_owner1.setOwner_name(rest_owner.getOwner_name());
		    rest_owner1.setPhoneNo(rest_owner.getPhoneNo());
			Rest_Owner ownerDetails = rest_ownerrepo.save(rest_owner1);
		return ownerDetails;
	}
	
	
	public String deleteOwnerDetails(int ownerId) {
		
		rest_ownerrepo.deleteById(ownerId);
		return "Owner Account deleted successfully with id : "+ownerId;
	}

	public List<Rest_Owner> getOwner() {
		// TODO Auto-generated method stub
		return rest_ownerrepo.findAll();
	}
	
	

}
