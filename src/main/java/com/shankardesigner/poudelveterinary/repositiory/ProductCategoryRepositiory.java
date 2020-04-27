package com.shankardesigner.poudelveterinary.repositiory;

import com.shankardesigner.poudelveterinary.model.ProductCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepositiory extends JpaRepository<ProductCat, Long> {

}
