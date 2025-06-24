package com.project.Theatre_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.service.OwnerService;
import com.project.Theatre_Management_System.util.ResponseStructure;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
    @PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody  Owner owner) {
		return  ownerService.saveOwner(owner);
	}

    @GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam  int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

    @DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam   int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
		
	}
    @PutMapping("/updateOwnernById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnernById(@RequestParam  int oldOwnerId,@RequestBody Owner newOwner) {
		
		return ownerService.updateOwnernById(oldOwnerId, newOwner);	
	}

    @GetMapping("/fetchAllOwner")
	public List<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}
    
    @PutMapping("/addExistingTheatreToExistingOwner")
    public Owner addExistingTheatreToExistingOwner(int ownerId,int theatreId) {
		return ownerService.addExistingTheatreToExistingOwner(ownerId, theatreId);
	}
}
