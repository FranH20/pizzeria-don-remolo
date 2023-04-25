package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.responses.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.repositories.SubcategoryRepository;
import com.franhc.pizzeria.remolo.v1.services.ISubcategoryService;
import com.franhc.pizzeria.remolo.v1.util.mappers.SubcategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcategoryService implements ISubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    @Transactional(readOnly = true)
    public PaginationResponse<SubcategoryResponse> getCategories(int paginationKey, int pageSize) {
        PageRequest page = PageRequest.of(paginationKey, pageSize);
        Page<Subcategory> subcategories = subcategoryRepository.findAll(page);
        return SubcategoryMapper.INSTANCE.pageSubcategoryToPaginationResponse(subcategories);
    }
}