package com.avazon.ecommerce.repository;


import com.avazon.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByName(String name);

    List<Product> findProductByCategoryId(long categoryId);
}
