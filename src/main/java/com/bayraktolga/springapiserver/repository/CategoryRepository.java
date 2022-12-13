package com.bayraktolga.springapiserver.repository;

import com.bayraktolga.springapiserver.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
