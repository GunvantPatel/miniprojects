package com.gunvant.service;

import java.util.List;

import com.gunvant.entity.Contact;

public interface ContactService {

	String upsert(Contact contact);
	List<Contact> getAllContact();
	Contact getContact(int cid);
	String deleteContact(int cid);
}
