package com.build.ecom_project.service;

import com.build.ecom_project.model.Product;
import com.build.ecom_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
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
        return repo.findById(id).get();
    }

    //    to Add data into database
//    public Product testAddProduct(Product product) {
//        return repo.save(product);
//    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException{
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repo.save(product);
    }

//For Put Method
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException{
        product.setImageDate(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

//To Delete a Element
public  void deleteProduct(int id){
        repo.deleteById(id);
}

public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
}

}