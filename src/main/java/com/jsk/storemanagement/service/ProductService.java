package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.ProductDao;
import com.jsk.storemanagement.dto.Product;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;
    // find by id of product
    public Product findById(int productId) {
        return productDao.findById(productId);
    }

    // insert product
    public void insertProduct(Product passProduct) {
        productDao.insertProduct(passProduct);
    }

    // update product
    public void updateProduct(Product passProduct, int productId) {
      productDao.updateProduct(passProduct, productId);

    }

    // delete product
    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    // display product
    public List<Product> displayProduct() {
        return productDao.displayProduct();
    }
}
