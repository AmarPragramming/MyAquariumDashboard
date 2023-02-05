package com.fishfarming.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public class Customer {
	@Column
	private String name;



	@Column
	private String emailId;

	@Column @Id
	private String loginId;

	@Column
	private String password;
	
	//private Address address;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return loginId.equals(customer.loginId) && password.equals(customer.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(loginId, password);
	}

}
