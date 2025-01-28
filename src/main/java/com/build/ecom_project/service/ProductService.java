package com.build.ecom_project.service;

import com.build.ecom_project.model.Product;
import com.build.ecom_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class ProductService {
@Autowired
    private ProductRepo repo;

//to fetch all element
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    //to fetch single element
    public Product getProductsById(int id) {
        return repo.findById(id).orElseGet(
                () -> {
                    Product notFoundProduct = new Product();
                    notFoundProduct.setName("Not Found");
                    return notFoundProduct;
                }


        );
    }


}