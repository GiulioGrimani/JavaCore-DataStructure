package com.model;

import java.util.Objects;

public class Account {

	private String businessName;

	private String vatNumber;

	public Account(String businessName, String vatNumber) {
		this.businessName = businessName;
		this.vatNumber = vatNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(businessName, other.businessName) && Objects.equals(vatNumber, other.vatNumber);
	}

}
