package com.api.crud.Client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.api.crud.Entity.Employee;





public class Restclient {
	
	private static final String GET_Employee_URL="http://localhost:8080/api/Employees";
	
	private RestTemplate rt=new RestTemplate();
	
	
	private void getEmployees()
	{
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String>entity=new HttpEntity<String>("parameters",headers);
		
		ResponseEntity<List<Employee>>result=rt.exchange(GET_Employee_URL, HttpMethod.GET,entity,
				new ParameterizedTypeReference<List<Employee>>() {});
		
		
		     List<Employee>empdata=result.getBody();
		
		 for (Employee emp : empdata) {
			 
			 System.out.println(emp.getId());
			 System.out.println(emp.getFirstName());
			 System.out.println(emp.getLastName());
			 System.out.println(emp.getEmail());
			
		}
		     
		     
	}
	
	

	public static void main(String[] args) {
		
		
		Restclient rc=new Restclient();
		rc.getEmployees();

	}

}
