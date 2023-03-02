package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.CategoryDao;
import com.jsk.storemanagement.dao.ProductDao;
import com.jsk.storemanagement.dto.Product;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    CategoryDao categoryDao;

    // find by id of product
    public Product findById(int productId) {
        return productDao.findById(productId);
    }

    // insert product
    public String insertProduct(Product passProduct) {
        if (findById(passProduct.getProductId()) != null) {
            productDao.insertProduct(passProduct);
            return "product inserted";
        }
        return "Product with this Id already exists";
    }

    // update product
    public String updateProduct(Product passProduct, int productId) {
        if (findById(productId) != null) {
            Product dbProduct = findById(productId);

            if (passProduct.getCategory() != null) {
                if (passProduct.getCategory().getCategoryId() != dbProduct.getCategory().getCategoryId()) {
                    categoryDao.insertCategory(passProduct.getCategory());
                }
            }

            productDao.updateProduct(passProduct, productId);
            return "Product Updated";

        }
        return "Product not found with this id ";

    }

    // delete product
    public String deleteProduct(int productId) {
        if (findById(productId) != null) {
            productDao.deleteProduct(productId);
            return "product Id is deleted";
        }
        return "Product with this Id does not exist";
    }

    // display product
    public List<Product> displayProduct() {

        if (productDao.displayProduct() != null) {
            return productDao.displayProduct();

        }
        return null;

    }
}
