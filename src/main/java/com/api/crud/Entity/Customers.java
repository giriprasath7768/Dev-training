package com.api.crud.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cusid;
	
	@Column(name="cus_name")
	private String cusname;
	
	@Column(name="cus_address")
	private String cusaddress;
	
	@Column(name="cus_phno")
	private long cusphno;
	
	
	
	public Customers()
	{
		
	}



	public Customers(String cusname, String cusaddress, long cusphno) {
		super();
		this.cusname = cusname;
		this.cusaddress = cusaddress;
		this.cusphno = cusphno;
	}



	public long getCusid() {
		return cusid;
	}



	public void setCusid(long cusid) {
		this.cusid = cusid;
	}



	public String getCusname() {
		return cusname;
	}



	public void setCusname(String cusname) {
		this.cusname = cusname;
	}



	public String getCusaddress() {
		return cusaddress;
	}



	public void setCusaddress(String cusaddress) {
		this.cusaddress = cusaddress;
	}



	public long getCusphno() {
		return cusphno;
	}



	public void setCusphno(long cusphno) {
		this.cusphno = cusphno;
	}
	
	
	

}
