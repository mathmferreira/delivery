package com.devsuperior.delivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.delivery.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("Select Distinct obj From Order obj "
			+ "Join Fetch obj.products "
			+ "Where obj.status = 0 Order By obj.moment ASC")
	public List<Order> findOrdersWithProducts();

}
