package com.jsk.storemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Product;
import com.jsk.storemanagement.repository.ProductRepository;

@Repository
public class ProductDao {

    @Autowired
    ProductRepository productRepository;

    // find by id of product
    public Product findById(int productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    //insert product
    public void insert(Product passProduct) {
        productRepository.save(passProduct);
    }

    //update product
    public void update(Product passProduct ,int productId) {
    Product dbProduct=productRepository.findById(productId).get();
    if(passProduct.getProductPrice()!=0.0){
        dbProduct.setProductPrice(passProduct.getProductPrice());

    }
    if(dbProduct.getProductName()!=null){
        dbProduct.setProductName(passProduct.getProductName());
    }   
    
    if(dbProduct.getProductAvailability()!=false){
        dbProduct.setProductAvailability(passProduct.getProductAvailability());
    }
    if (dbProduct.getProductQuantity()!=null){
        dbProduct.setProductQuantity(passProduct.getProductQuantity());
    }
    
    productRepository.save(dbProduct);

    }
    // delete product
    public void deleteProduct(int productId){
        productRepository.deleteById(productId);

    }
    //display product
    public List<Product> displayProduct(){
        return productRepository.findAll();
    }
}