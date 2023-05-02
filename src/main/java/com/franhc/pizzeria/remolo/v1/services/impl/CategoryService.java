package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.exceptions.ResourceNotFoundException;
import com.franhc.pizzeria.remolo.v1.models.Category;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.dtos.Pagination;
import com.franhc.pizzeria.remolo.v1.payloads.dtos.basics.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryPostResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.repositories.CategoryRepository;
import com.franhc.pizzeria.remolo.v1.repositories.SubcategoryRepository;
import com.franhc.pizzeria.remolo.v1.services.ICategoryService;
import com.franhc.pizzeria.remolo.v1.util.mappers.CategoryMapper;
import com.franhc.pizzeria.remolo.v1.util.mappers.SubcategoryMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final Log log = LogFactory.getLog(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    @Transactional
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        log.info("... running CategoryService.addCategory ...");
        // Save the category
        Category category = CategoryMapper.INSTANCE.categoryRequestToCategory(categoryRequest);
        Category newCategory = categoryRepository.save(category);
        // Save the subcategory with the category identifier
        List<Subcategory> subcategories = subcategoryRepository.saveAll(
                SubcategoryMapper.INSTANCE.addCategoryInSubcategory(newCategory, categoryRequest.getSubcategories()));
        // Set the subcategories in category entity
        newCategory.setSubcategories(subcategories);
        // Mapping the response of the category
        return CategoryMapper.INSTANCE.categoryToCategoryResponse(newCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public PaginationResponse<CategoryResponse> getCategories(int paginationKey, int pageSize) {
        log.info("... running CategoryService.getCategories ...");
        PageRequest page = PageRequest.of(paginationKey, pageSize);
        Page<Category> categories = categoryRepository.findAll(page);
        List<CategoryResponse> categoryResponse = CategoryMapper.INSTANCE.pageCategoryToPaginationResponse(categories);
        return new PaginationResponse<>(categoryResponse, new Pagination(categories));
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(Long categoryId, CategoryDto categoryRequest) {
        log.info("... running CategoryService.updateCategory ...");
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found."));
        CategoryMapper.INSTANCE.mapCategoryDtoToCategory(foundCategory, categoryRequest);
        return CategoryMapper.INSTANCE.categoryToCategoryResponse(categoryRepository.save(foundCategory));
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
        log.info("... running CategoryService.deleteCategory ...");
        categoryRepository.deleteById(categoryId);
    }

    @Override
    @Transactional
    public SubcategoryPostResponse addSubcategoryWithinCategory(Long categoryId, SubcategoryRequest subcategoryRequest) {
        log.info("... running CategoryService.addSubcategoryWithinCategory ...");
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Subcategory subcategory = SubcategoryMapper.INSTANCE.subcategoryRequestWithCategoryToSubcategory(category, subcategoryRequest);
        return SubcategoryMapper.INSTANCE.subcategoryToSubcategoryPostResponse(subcategoryRepository.save(subcategory));
    }


}
