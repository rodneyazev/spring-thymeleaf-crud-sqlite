package com.project.contacts;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository <Contacts, Integer>{
	
	Contacts findById(int id); 
	void deleteById(int id);
	Iterable<Contacts> findAll(Sort sort);
	
}
