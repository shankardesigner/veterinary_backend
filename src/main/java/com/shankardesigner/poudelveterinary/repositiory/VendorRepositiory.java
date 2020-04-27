package com.shankardesigner.poudelveterinary.repositiory;

import com.shankardesigner.poudelveterinary.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepositiory  extends JpaRepository<Vendor, Long> {
}
