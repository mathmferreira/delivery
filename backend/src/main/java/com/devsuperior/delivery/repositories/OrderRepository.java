package com.devsuperior.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.delivery.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
