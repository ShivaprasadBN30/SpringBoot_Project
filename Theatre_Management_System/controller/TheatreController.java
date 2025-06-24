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

import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.service.TheatreService;
import com.project.Theatre_Management_System.util.ResponseStructure;

@RestController
public class TheatreController {
	@Autowired
	TheatreService theatreService;

	@PostMapping("/saveTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre theatre ) {
		return theatreService.saveTheatre(theatre);
	}

	@GetMapping("/fetchTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> fetchTheatreById(@RequestParam int theatreId) {
		return theatreService.fetchTheatreById(theatreId);
	}

	@DeleteMapping("/deleteTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>>  deleteTheatreById(@RequestParam  int theatreId) {
		return theatreService.deleteTheatreById(theatreId);
	
	}

	@PutMapping("updateTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>>  updateTheatreById(@RequestParam int oldTheatreId,@RequestBody Theatre  newTheatre ) {
		return theatreService.updateTheatreById(oldTheatreId, newTheatre);
	}

	@GetMapping("/fetchAllTheatre")
	public List<Theatre > fetchAllTheatre() {
		return theatreService.fetchAllTheatre();
	}
	
	@PutMapping("/addExistingBranchToExistingTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addExistingBranchToExistingTheatre(int branchId,int theatreId) {
		 return	theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
		}


	@PutMapping("/addNewBranchToExistingTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addNewBranchToExistingTheatre(Branch newBranch,int theatreId) {
	      return theatreService.addNewBranchToExistingTheatre(newBranch, theatreId);
		}

}
