package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.responses.PaginationResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import com.franhc.pizzeria.remolo.v1.services.impl.SubcategoryService;
import com.franhc.pizzeria.remolo.v1.util.Constants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/v1/subcategories")
public class SubcategoryController {

    private final Log log = LogFactory.getLog(SubcategoryController.class);

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    @ResponseBody
    public PaginationResponse<SubcategoryResponse> getSubcategories(
            @RequestParam(name = "paginationKey", required = false, defaultValue = Constants.DEFAULT_PAGE_KEY)
            @Max(value = Constants.MAX_PAGE_KEY) @Min(value = 0)
            int paginationKey,
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.DEFAULT_PAGE_SIZE)
            @Max(value = Constants.MAX_PAGE_SIZE) @Min(value = 0)
            int pageSize
          ) {
        log.info("... running SubcategoryController.getSubcategories ...");
        return subcategoryService.getCategories(paginationKey, pageSize);
    }


}
