package com.training.service;

import java.util.LinkedList;
import java.util.List;

import com.training.bean.Person;

public class PersonManagement {
	
	private List<Person> persons=new LinkedList<>();

	public PersonManagement() {
		super();
		Person p1=new Person(101, "Ram", 1000.00);
		Person p2=new Person(102, "Shalini", 5000.00);
		Person p3=new Person(103, "Anurag", 4000.00);
		Person p4=new Person(104, "Dinesh", 2000.00);
		Person p5=new Person(105, "Karthick", 3000.00);
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
	}
	
	public List<Person> addPerson(Person p) {
		persons.add(p);
		return persons;
		
	}
	
	public List<Person> deletePerson(Person p) {
		persons.remove(p);
		return persons;
	}
	
	public List<Person> updatePerson(Person p){
		int index=persons.indexOf(p);
		if(index>=0) {
			persons.set(index, p);
		}
		return persons;
		
	}

	public Person getPersonById(int id) {
		Person p=new Person(id);
		int index=persons.indexOf(p);
		if(index>=0) {
			return persons.get(index);
		}
		return null;
	}
		
	public List<Person> getAllPersons() {
		return this.persons;
	}
	

}
