package com.jsk.storemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Category;
import com.jsk.storemanagement.repository.CategoryRepository;

@Repository
public class CategoryDao {
    @Autowired
    CategoryRepository categoryRepository;

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
        // 2 if
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
