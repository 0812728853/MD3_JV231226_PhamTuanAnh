package com.ra.models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "StudentName")
    private String productName;
    @Column(name = "phoneNumber")
    private Double price;
    @Column(name = "image")
    private String image;
    @Column(name = "birthday")
    private String description;
    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private Category category;

    public Product(){

    }

    public Product(Integer id, String productName, Double price, String image, String description, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.description = description;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
