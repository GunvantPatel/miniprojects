package com.gunvant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunvant.entity.Contact;
import com.gunvant.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo; 
	
	@Override
	public String upsert(Contact contact) {
			 repo.save(contact);
	
		return "Success ";
	}

	@Override
	public List<Contact> getAllContact() {

		return repo.findAll();
	}

	@Override
	public Contact getContact(int cid) {
		Optional<Contact> findById = repo.findById(cid);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String deleteContact(int cid) {
		repo.deleteById(cid);
			return "Success";
	}

}
