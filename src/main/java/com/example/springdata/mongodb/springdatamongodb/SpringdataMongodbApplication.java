package com.example.springdata.mongodb.springdatamongodb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdataMongodbApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		// save a couple of customers
		repository.save(new Customer("ANGELINA","JOLIE"));
		repository.save(new Customer("JACKIE","DADA"));
		
		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		
		System.out.println();
		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('ANGELINA'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("ANGELINA"));
		
		System.out.println("Customers found with findByLastName('DADA'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("DADA")) {
			System.out.println(customer);
		}
		
		doJAXBSample();
				
	}

	private void doJAXBSample() {

		Student student = new Student();
		student.setId(1);
		student.setName("Arjun");
		student.setSchool("SPHS");
		
		File file = new File("D:\\student.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(student, file);
			jaxbMarshaller.marshal(student, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
