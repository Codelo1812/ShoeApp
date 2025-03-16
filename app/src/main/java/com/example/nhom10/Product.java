package com.example.nhom10;

public class Product {
    private String id;
    private String name;
    private String description;
    private String price;
    private String image;

    public Product(String id,String name, String description, String price,String image) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
