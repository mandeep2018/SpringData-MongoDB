package com.example.springdata.mongodb.springdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstname);
	public List<Customer> findByLastName(String lastname);
}
