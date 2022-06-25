package com.logo.model.company;

import com.logo.model.Order;
import com.logo.model.enums.FirmType;
import com.logo.model.enums.Status;
import com.logo.model.invoice.Invoice;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	protected Customer(){}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@Transient
	private Address address;

	private FirmType firmType;
	private Status status;

	@Transient
	private Account account;

	@Transient
	private List<Account> accountList;






}
