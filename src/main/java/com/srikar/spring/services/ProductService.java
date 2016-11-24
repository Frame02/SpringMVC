package com.srikar.spring.services;

import com.srikar.spring.domain.Product;
import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdate(Product product);

    void delete(Integer id);
}
