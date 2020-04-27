package com.shankardesigner.poudelveterinary.repositiory;

import com.shankardesigner.poudelveterinary.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositiory extends JpaRepository<Customer, Long> {
    public Customer findByEmail(String email);
    public boolean existsById(long id);
}
