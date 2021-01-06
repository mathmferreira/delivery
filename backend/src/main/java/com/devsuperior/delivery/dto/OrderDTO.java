package com.devsuperior.delivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.delivery.entities.Order;
import com.devsuperior.delivery.entities.enums.OrderStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@SuppressWarnings("serial")
public class OrderDTO implements Serializable {

	private Long id;

	private String address;

	private Double latitude;

	private Double longitude;

	private Instant moment;

	private OrderStatus status;
	
	private List<ProductDTO> products = new ArrayList<>();

	public OrderDTO(Order entity) {
		id = entity.getId();
		address = entity.getAddress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		products = entity.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
	}
	

}
