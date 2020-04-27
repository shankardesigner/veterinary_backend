package com.shankardesigner.poudelveterinary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productDesc;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private ProductCat productCat;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
