package com.avazon.ecommerce.repository;


import com.avazon.ecommerce.model.entity.Category;
import com.avazon.ecommerce.model.entity.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
