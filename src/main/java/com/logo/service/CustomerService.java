package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.logo.model.enums.Status;
import com.logo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.company.Customer;
import com.logo.model.Order;
import com.logo.model.item.Product;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerRepository customerRepository;






	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer findById(long id) {
		return customerRepository.findById(id);
	}


	public Iterable<Customer> findByStatusAndName(Optional<Status> status, Optional<String> name) {

		if (status.isEmpty() || name.isEmpty()) {
			return customerRepository.findByStatusOrName(status,name);
		}

		return customerRepository.findByStatusAndName(status, name);
	}

	public Iterable<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}



	public Iterable<Customer> findByStatus(Status status) {
		return customerRepository.findByStatus(status);
	}

	public Customer deleteById(long id) {
		return customerRepository.deleteById(id);
	}





	private List<Customer> prepareCustomerList() {
		List<Customer> customers = new ArrayList<>();
		return customers;
	}

	private List<Order> prepareOrderList() {
		List<Order> orders = new ArrayList<>();
		int randomOrderNumber = new Random().nextInt(5);
		for (int i = 0; i < randomOrderNumber; i++) {
			Order order = new Order(prepareProductList(randomOrderNumber));
			orders.add(order);
		}
		return orders;
	}

	private List<Product> prepareProductList(int randomOrderNumber) {
		List<Product> products = new ArrayList<>();
		/**
		Random random = new Random();
		products.add(new Product("MacBook Pro", random.nextDouble(1000)));
		products.add(new Product("MacBook air", random.nextDouble(1000)));
		products.add(new Product("Mac Mini", random.nextDouble(1000)));
		products.add(new Product("iPhone 11", random.nextDouble(1000)));
		products.add(new Product("iPhone 12", random.nextDouble(1000)));
*/
		return products.stream().limit(randomOrderNumber).toList();
	}

}
