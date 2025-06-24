package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	public Address saveAddress(Address address) {
		return  addressRepo.save(address);		
	}

	public Address fetchAddressById(int addressId) {
		return addressRepo.findById(addressId).get();
	}

	public Address deleteAddressById(int addressId) {
		Address address= addressRepo.findById(addressId).get();
		addressRepo.delete(address);
		return address;
	}

	public Address updateAddressById(int oldAddressId, Address newAddress) {
		newAddress.setAddressId(oldAddressId);
		return addressRepo.save(newAddress);
	}

	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
