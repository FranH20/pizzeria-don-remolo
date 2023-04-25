package com.franhc.pizzeria.remolo.v1.util.mappers;

import com.franhc.pizzeria.remolo.v1.models.Category;
import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import com.franhc.pizzeria.remolo.v1.payloads.dto.CategoryDto;
import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.payloads.responses.SubcategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    @Mapping(target = "name", source = "name")
    Category categoryRequestToCategory(CategoryRequest categoryRequest);


    @Mapping(target = "id", source = "categoryId")
    @Mapping(target = "name", source = "name")
    CategoryResponse categoryToCategoryResponse(Category category);

    @Mapping(target = "id", source = "subcategoryId")
    @Mapping(target = "name", source = "name")
    SubcategoryResponse subcategoryToSubcategoryResponse(Subcategory subcategory);

    default List<CategoryResponse> categoryListToCategoryResponseList(List<Category> categories) {
        return categories.stream().filter(Objects::nonNull).map(this::categoryToCategoryResponse).collect(Collectors.toList());
    }

    @Mapping(target = "category.name", source = "categoryRequest.name")
    void mapCategoryRequestToCategory(@MappingTarget Category category, CategoryRequest categoryRequest);

    @Mapping(target = "category.name", source = "categoryRequest.name")
    void mapCategoryDtoToCategory(@MappingTarget Category category, CategoryDto categoryRequest);
}