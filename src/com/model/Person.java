package com.model;

import java.util.Objects;

public class Person {

	private String firstName;

	public Person(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * Piuttosto che confrontare le aree di memoria, questo override del metodo
	 * equals confronta i valori delle proprieta'
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(firstName, other.firstName);
	}

	@Override
	public String toString() {
		return "(nome: " + firstName + ")";
	}

}
