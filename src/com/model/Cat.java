package com.model;

import java.util.Objects;

public class Cat {

	private String name;

	public Cat(String name) {
		this.name = name;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}

}
