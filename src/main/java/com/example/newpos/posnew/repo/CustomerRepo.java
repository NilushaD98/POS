package com.example.newpos.posnew.repo;

import com.example.newpos.posnew.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByCustomerNameEquals(String customerName);
}
