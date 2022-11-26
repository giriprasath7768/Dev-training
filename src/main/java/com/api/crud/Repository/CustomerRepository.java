package com.api.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.Entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long>{

}
