package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.TheatreDao;
import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Owner;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.util.ResponseStructure;

@Service
public class TheatreService {
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ResponseStructure<Theatre>  responseStructure;
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre ) {
		responseStructure.setMessage("sucessfully inserted");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(theatreDao.saveTheatre(theatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Theatre>>  fetchTheatreById(int theatreId) {
		responseStructure.setMessage("Got the details");
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.FOUND);
	}

	public  ResponseEntity<ResponseStructure<Theatre>>   deleteTheatreById(int theatreId) {
		responseStructure.setMessage("Deleted");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.OK);
	}

	public  ResponseEntity<ResponseStructure<Theatre>>  updateTheatreById(int oldTheatreId, Theatre  newTheatre ) {
		responseStructure.setMessage("Successfully Updated");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
	}

	public List<Theatre > fetchAllTheatre() {
		return theatreDao.fetchAllTheatre();
	}

	public  ResponseEntity<ResponseStructure<Theatre>>  addExistingBranchToExistingTheatre(int branchId,int theatreId) {
		responseStructure.setMessage("Successfully Updated");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theatreDao.addExistingBranchToExistingTheatre(branchId, theatreId));
	 return new	ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
	}
	
	public  ResponseEntity<ResponseStructure<Theatre>>  addNewBranchToExistingTheatre(Branch newBranch,int theatreId) {
		responseStructure.setMessage("Successfully Updated");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(theatreDao.addNewBranchToExistingTheatre(newBranch, theatreId));
	 return new	ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
	 
	
	}
}
