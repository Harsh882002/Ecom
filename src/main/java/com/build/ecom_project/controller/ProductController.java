package com.build.ecom_project.controller;

import com.build.ecom_project.model.Product;
import com.build.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    //    To fetch all data
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

//    to fectch single element from database
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable int id) {

        Product product = service.getProductsById(id);
        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
        try {
            Product product1 = service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product = service.getProductsById(productId);
        byte[] imageFile = product.getImageDate();

        return ResponseEntity.ok()
                 .body(imageFile);
    }

    //PUT METHOD
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product ,
                                                @RequestPart MultipartFile imageFile){
        Product product1 = null;
        try{
            product1 = service.updateProduct(id,product,imageFile);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        if(product1 != null)
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            else
                return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
    }

    //DElete code



}

