package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.repo.TheatreRepo;

@Repository
public class TheatreDao {
	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	BranchDao branchDao;

	public Theatre saveTheatre(Theatre theatre ) {
		return theatreRepo.save(theatre);
	}

	public Theatre fetchTheatreById(int theatreId) {
		return theatreRepo.findById(theatreId).get();
	}

	public Theatre  deleteTheatreById(int theatreId) {
		Theatre theatre = theatreRepo.findById(theatreId).get();
		theatreRepo.delete(theatre);
		return theatre;
	}

	public Theatre  updateTheatreById(int oldTheatreId, Theatre  newTheatre ) {
		newTheatre .setTheatreId(oldTheatreId);
		return theatreRepo.save(newTheatre);
	}

	public List<Theatre> fetchAllTheatre() {
		return theatreRepo.findAll();
	}
	
	public Theatre addExistingBranchToExistingTheatre(int branchId,int theatreId) {
		Theatre theatre=fetchTheatreById(theatreId);
		Branch branch=branchDao.fetchBranchById(branchId);
		List<Branch>list=theatre.getBranch();
		list.add(branch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
	}
	
	public Theatre addNewBranchToExistingTheatre(Branch newBranch,int theatreId) {
		Theatre theatre=fetchTheatreById(theatreId);
		List<Branch>list=theatre.getBranch();
		list.add(newBranch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
		
		
	}
}
