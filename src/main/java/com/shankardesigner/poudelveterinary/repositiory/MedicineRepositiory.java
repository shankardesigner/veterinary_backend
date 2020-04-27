package com.shankardesigner.poudelveterinary.repositiory;

import com.shankardesigner.poudelveterinary.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepositiory extends JpaRepository<Medicine, Long> {
}
