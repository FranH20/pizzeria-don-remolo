package com.franhc.pizzeria.remolo.v1.util.mappers;

import com.franhc.pizzeria.remolo.v1.models.Category;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.requests.SubcategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryPostResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper
public interface SubcategoryMapper {

    SubcategoryMapper INSTANCE = Mappers.getMapper(SubcategoryMapper.class);

    @Mapping(target = "name", source = "subcategoryRequest.name")
    @Mapping(target = "category", source = "category")
    Subcategory subcategoryRequestWithCategoryToSubcategory(Category category, SubcategoryRequest subcategoryRequest);


    default List<Subcategory> addCategoryInSubcategory(Category category, List<SubcategoryRequest> subcategoryRequests) {
        return subcategoryRequests.stream()
                .filter(Objects::nonNull)
                .map(subcategoryRequest -> subcategoryRequestWithCategoryToSubcategory(category, subcategoryRequest)).collect(Collectors.toList());
    }

    @Mapping(target = "id", source = "subcategoryId")
    @Mapping(target = "name", source = "name")
    SubcategoryResponse subcategoryToSubcategoryResponse(Subcategory subcategory);

    default List<SubcategoryResponse> subcategoryRequestToSubcategoryResponse(List<Subcategory> subcategories) {
        return subcategories.stream().filter(Objects::nonNull).map(this::subcategoryToSubcategoryResponse).collect(Collectors.toList());
    }
    default List<SubcategoryResponse> pageSubcategoryToPaginationResponse(Page<Subcategory> subcategories) {
        List<Subcategory> content = subcategories.getTotalElements() > 0 ? subcategories.getContent() : Collections.emptyList();
        return subcategoryRequestToSubcategoryResponse(content);
    }

    @Mapping(target = "name", source = "subcategoryRequest.name")
    void mapSubcategoryRequestToSubcategory(@MappingTarget Subcategory subcategory, SubcategoryRequest subcategoryRequest);

    @Mapping(target = "id", source = "subcategoryId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "categoryId", source = "category.categoryId")
    SubcategoryPostResponse subcategoryToSubcategoryPostResponse(Subcategory save);
}
