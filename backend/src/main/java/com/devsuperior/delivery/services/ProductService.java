package com.devsuperior.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.delivery.dto.ProductDTO;
import com.devsuperior.delivery.entities.Product;
import com.devsuperior.delivery.repositories.ProductRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(ProductDTO::new).collect(Collectors.toList());
	}
	
}
