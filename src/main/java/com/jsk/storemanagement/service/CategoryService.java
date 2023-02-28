package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.CategoryDao;
import com.jsk.storemanagement.dto.Category;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

     // find by id(Category)
     public Category findById(int passCategoryId) {
        return categoryDao.findById(passCategoryId);

     }
     // insert a new category
    public void insertCategory(Category passCategory) {
        categoryDao.insertCategory(passCategory);
    }
    // update a category
    public void updateCategory(Category passCategory, int passCategoryId) {
        categoryDao.updateCategory(passCategory, passCategoryId);
    }
    // delete a category
    public void deleteCategory(int passCategoryId) {
        categoryDao.deleteCategory(passCategoryId);
    }
    // display all categories
    public List<Category> displayCategories() {
        return categoryDao.displayCategories();
    }
}
