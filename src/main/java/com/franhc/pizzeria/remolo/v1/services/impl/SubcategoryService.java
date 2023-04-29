package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.dto.Pagination;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.repositories.SubcategoryRepository;
import com.franhc.pizzeria.remolo.v1.services.ISubcategoryService;
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
public class SubcategoryService implements ISubcategoryService {

    private final Log log = LogFactory.getLog(SubcategoryService.class);
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    @Transactional(readOnly = true)
    public PaginationResponse<SubcategoryResponse> getSubcategories(int paginationKey, int pageSize) {
        log.info("... running SubcategoryService.getCategories ...");
        PageRequest page = PageRequest.of(paginationKey, pageSize);
        Page<Subcategory> subcategories = subcategoryRepository.findAll(page);
        List<SubcategoryResponse> subcategoryResponse = SubcategoryMapper.INSTANCE.pageSubcategoryToPaginationResponse(subcategories);
        return new PaginationResponse<>(subcategoryResponse, new Pagination(subcategories));
    }

    @Override
    @Transactional
    public void deleteSubcategory(Long subcategoryId) {
        log.info("... running SubcategoryService.deleteSubcategory ...");
        subcategoryRepository.deleteById(subcategoryId);
    }
}
