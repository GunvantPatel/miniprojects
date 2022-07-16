package com.gunvant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gunvant.entity.Contact;
import com.gunvant.service.ContactService;

@RestController
public class ContactsController {
	@Autowired
	private ContactService service;

	@PostMapping("/add")
	public ResponseEntity<String> upsert(@RequestBody  Contact contact) {
		
		String status = service.upsert(contact);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Contact>> getAllContact(){
		
		List<Contact> allContact = service.getAllContact();
		
		return new ResponseEntity<>(allContact,HttpStatus.OK);
	}
	
	
	@GetMapping("edit/{cid}")
	public ResponseEntity<Contact> editContact (@PathVariable int cid) {
		 Contact contact = service.getContact(cid);
		 
		 return  new ResponseEntity<>( contact, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable("cid") int cid) {
		
		String deleteContact = service.deleteContact(cid);
		
		return  new ResponseEntity<>(deleteContact ,HttpStatus.OK);
	}
}
