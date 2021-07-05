package com.abcode.products.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Float price;
    private String description;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}


