package com.franhc.pizzeria.remolo.v1.controllers.impl;

import com.franhc.pizzeria.remolo.v1.controllers.ISubcategoryController;
import com.franhc.pizzeria.remolo.v1.payloads.responses.pagination.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.SubcategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubcategoryController implements ISubcategoryController {

    private final Log log = LogFactory.getLog(SubcategoryController.class);

    @Autowired
    private SubcategoryService subcategoryService;


    @Override
    public ResponseEntity<PaginationResponse<SubcategoryResponse>> getSubcategories(int paginationKey,int pageSize) {
        log.info("... running SubcategoryController.getSubcategories ...");
        PaginationResponse<SubcategoryResponse> response = subcategoryService.getSubcategories(paginationKey, pageSize);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteSubcategory(Long id) {
        log.info("... running SubcategoryController.deleteSubcategory ...");
        subcategoryService.deleteSubcategory(id);
        return new ResponseEntity<>("Successful Operation", HttpStatus.OK);
    }


}
