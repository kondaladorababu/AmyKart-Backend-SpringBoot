package com.category.category_service.category;

import jakarta.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;

    @Lob
    private byte[] image;

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Product> products;

    public Category() {
    }

    public Category(int id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

//    public Category(int id, String name, byte[] image, List<Product> products) {
//        this.id = id;
//        this.name = name;
//        this.image = image;
//        this.products = products;
//    }

    public Category(String name, byte[] bytes) {
        this.name = name;
        this.image = bytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
