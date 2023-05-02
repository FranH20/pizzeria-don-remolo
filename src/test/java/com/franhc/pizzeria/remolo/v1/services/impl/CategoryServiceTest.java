package com.franhc.pizzeria.remolo.v1.services.impl;

import com.franhc.pizzeria.remolo.v1.payloads.requests.CategoryRequest;
import com.franhc.pizzeria.remolo.v1.payloads.responses.CategoryResponse;
import com.franhc.pizzeria.remolo.v1.repositories.CategoryRepository;
import com.franhc.pizzeria.remolo.v1.repositories.SubcategoryRepository;
import com.franhc.pizzeria.remolo.v1.util.ObjectMapperReadJson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private SubcategoryRepository subcategoryRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void addCategoryTest() {
        assertNull(null);
    }


}