package com.shankardesigner.poudelveterinary.repositiory;

import com.shankardesigner.poudelveterinary.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositiory extends JpaRepository<Address, Long> {
}
