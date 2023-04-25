package com.franhc.pizzeria.remolo.v1.repositories;

import com.franhc.pizzeria.remolo.v1.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

}
