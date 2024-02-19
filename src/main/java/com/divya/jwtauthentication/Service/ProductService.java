package com.divya.jwtauthentication.Service;

import java.util.List;

import com.divya.jwtauthentication.Model.Product;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    void deleteProduct(String id);
}
