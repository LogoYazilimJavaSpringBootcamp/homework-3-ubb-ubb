package com.logo.model.company;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private String province;
	private String address;

	protected Address() {}

	public Address(String country, String province, String address) {
		super();
		this.country = country;
		this.province = province;
		this.address = address;
	}



}
