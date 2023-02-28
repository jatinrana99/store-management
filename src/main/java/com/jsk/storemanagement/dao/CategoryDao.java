package com.jsk.storemanagement.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Category;
import com.jsk.storemanagement.dto.Product;
import com.jsk.storemanagement.repository.CategoryRepository;

@Repository
public class CategoryDao {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductDao productDao;
    @Autowired
    StoreDao storeDao;


    // find by id(Category)
    public Category findById(int passCategoryId) {
        Optional<Category> optional = categoryRepository.findById(passCategoryId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // insert a new category
    public void insertCategory(Category passCategory) {
        categoryRepository.save(passCategory);
    }

    // update a category
    public void updateCategory(Category passCategory, int passCategoryId) {
        Category dbCategory = categoryRepository.findById(passCategoryId).get();
        if (passCategory.getCategoryName() != null) {
            dbCategory.setCategoryName(passCategory.getCategoryName());
        }
        if (passCategory.getCategoryType() != null) {
            dbCategory.setCategoryType(passCategory.getCategoryType());
        }
        if(passCategory.getProduct() != null){

            List<Product> passProducts = passCategory.getProduct();
            
            List<Product> updatedProducts= new LinkedList<Product>() ;
            for(Product passProduct : passProducts){
                productDao.updateProduct(passProduct,passProduct.getProductId());
                updatedProducts.add(productDao.findById(passProduct.getProductId()));
            }
            
            dbCategory.setProduct(updatedProducts);
        }
        if(passCategory.getStore()!=null){
            storeDao.updateStore(passCategory.getStore(), passCategory.getStore().getStoreId());
            dbCategory.setStore(storeDao.findById(passCategory.getStore().getStoreId()));
        }
        categoryRepository.save(dbCategory);
    }

    // delete a category
    public void deleteCategory(int passCategoryId) {
        categoryRepository.deleteById(passCategoryId);
    }

    // display all categories
    public List<Category> displayCategories() {
        return categoryRepository.findAll();
    }

}
