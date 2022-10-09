package com.example.newpos.posnew.repo;

import com.example.newpos.posnew.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Repository
@Transactional
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {
}
