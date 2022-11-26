package com.api.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.Entity.Customers;
import com.api.crud.Exception.ResourceNotFoundException;
import com.api.crud.Repository.CustomerRepository;

@RestController	
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository cusrepo;
	
	
	//get all customer
	@GetMapping
	public List<Customers>getAllCustomers()
	{
		return this.cusrepo.findAll();
		
	}
	
	//Add new Customers
	@PostMapping
	public Customers createcustomer(@RequestBody Customers cust)
	{
		return this.cusrepo.save(cust);
		
	}
	
	//Get customer By id
	@GetMapping("/{id}")
	public Customers getCustomerById(@PathVariable(value="id")long cusid)
	{
		return this.cusrepo.findById(cusid).orElseThrow(()->new ResourceNotFoundException("Id dose not exsits"));
		
	}
	
	//Update customer
	@PutMapping("/{id}")
	public Customers updateCustomers(@RequestBody Customers cust,@PathVariable("id")long cusid)
	{
		Customers existingcustomer=this.cusrepo.findById(cusid).orElseThrow(()->new ResourceNotFoundException("Id dose not exsits"));
		
		existingcustomer.setCusname(cust.getCusname());
		existingcustomer.setCusaddress(cust.getCusaddress());
		existingcustomer.setCusphno(cust.getCusphno());
		
		
		return this.cusrepo.save(existingcustomer);
		
	}
	
	//Delete customer By id
	@DeleteMapping("/{id}")
	public ResponseEntity<Customers>deletecustomer(@PathVariable("id")long cusid)
	{
		Customers existingcustomer=this.cusrepo.findById(cusid).orElseThrow(()->new ResourceNotFoundException("Id dose not exsits"));
		this.cusrepo.delete(existingcustomer);
		
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	
	
	

}
