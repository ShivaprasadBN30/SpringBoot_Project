package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.AddressDao;
import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address>responseStructure;
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setMessage("sucessfully inserted");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		responseStructure.setMessage("Got the details");
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		responseStructure.setMessage("Deleted");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress) {
		responseStructure.setMessage("Successfully Updated");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
	}

	public List<Address> fetchAllAddress() {
		return addressDao.fetchAllAddress();
	}
}
