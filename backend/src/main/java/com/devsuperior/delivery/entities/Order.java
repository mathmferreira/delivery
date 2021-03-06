package com.devsuperior.delivery.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.devsuperior.delivery.entities.enums.OrderStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order")
@Data @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("serial")
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String address;
	
	private Double latitude;
	
	private Double longitude;
	
	private Instant moment;
	
	private OrderStatus status;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_order_product", joinColumns = 
	@JoinColumn(name = "order_id"), inverseJoinColumns = 
	@JoinColumn(name = "product_id"))
	private Set<Product> products = new HashSet<>();

	public Order(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	
	public Double getTotal() {
		return products.stream().mapToDouble(Product::getPrice).sum();
	}

}
