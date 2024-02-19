package com.divya.jwtauthentication.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.divya.jwtauthentication.Model.Product;
import com.divya.jwtauthentication.Repository.ProductRepository;
import com.divya.jwtauthentication.Service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(String id) {
        productRepository.deleteById(id);
	}
    
}
