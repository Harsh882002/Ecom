package com.build.ecom_project.controller;

import com.build.ecom_project.model.Product;
import com.build.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;



//    To fetch all data
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

//    to fectch single element from database
    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable int id){
        return service.getProductsById(id);
    }


}

