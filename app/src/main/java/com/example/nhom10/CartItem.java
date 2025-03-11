package com.example.nhom10;

public class CartItem {
    private String name;
    private double price;
    private int quantity;
    private String imageUrl; // Thêm biến này để lưu ảnh sản phẩm

    public CartItem(String name, double price, int quantity, String imageUrl) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getImageUrl() { return imageUrl; }
}
