package com.example.springdata.mongodb.springdatamongodb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	private String name;
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	@XmlElement
	public void setSchool(String school) {
		this.school = school;
	}
	private int id;
	private String school;
}
