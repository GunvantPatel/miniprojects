package com.gunvant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gunvant.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
