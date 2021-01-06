package com.devsuperior.delivery.dto;

import java.io.Serializable;

import com.devsuperior.delivery.entities.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@SuppressWarnings("serial")
public class ProductDTO implements Serializable {

	private Long id;

	private String name;

	private Double price;

	private String description;

	private String imageUri;

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		description = entity.getDescription();
		imageUri = entity.getImageUri();
	}

}
