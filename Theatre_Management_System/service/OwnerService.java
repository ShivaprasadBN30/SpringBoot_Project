package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.OwnerDao;
import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.util.ResponseStructure;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	ResponseStructure<Owner> responseStructure;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setMessage("sucessfully inserted");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED );
		
	}

	public ResponseEntity< ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		responseStructure.setMessage("Got the details");
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity< ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		responseStructure.setMessage("Deleted");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
		
	}

	public ResponseEntity< ResponseStructure<Owner>> updateOwnernById(int oldOwnerId, Owner newOwner) {
		responseStructure.setMessage("Successfully Updated");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.updateOwnernById(oldOwnerId, newOwner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
	
	}

	public List<Owner> fetchAllOwner() {
		
		return ownerDao.fetchAllOwner();
	}
	
	public Owner addExistingTheatreToExistingOwner(int ownerId,int theatreId) {
		return ownerDao.addExistingTheatreToExistingOwner(ownerId, theatreId);
	}
}