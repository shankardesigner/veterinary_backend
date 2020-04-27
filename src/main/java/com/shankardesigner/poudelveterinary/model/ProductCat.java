package com.shankardesigner.poudelveterinary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ProductCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long catId;

    @Valid
    @NotNull(message = "Category can't be a blank")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCat")
    private List<Product> products;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
