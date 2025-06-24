package com.project.Theatre_Management_System.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.repo.OwnerRepo;



@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	TheatreDao theatreDao;
	public Owner saveOwner(Owner owner) {
		return  ownerRepo.save(owner);
		
	}

	public Owner fetchOwnerById(int ownerId) {
		return ownerRepo.findById(ownerId).get();
	}

	public Owner deleteOwnerById(int ownerId) {
		Owner owner= ownerRepo.findById(ownerId).get();
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner updateOwnernById(int oldOwnerId, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
		return ownerRepo.save(newOwner);
	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}

	public Owner addExistingTheatreToExistingOwner(int ownerId,int theatreId) {
		Owner owner =fetchOwnerById(ownerId);
		Theatre theatre=theatreDao.fetchTheatreById(theatreId);
		owner.setTheatre(theatre);
	    return	saveOwner(owner);
		
	}
 
}

