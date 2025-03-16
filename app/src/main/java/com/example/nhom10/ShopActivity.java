package com.example.nhom10;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements ProductAdapter.ProductCallback {
    RecyclerView rvListC;
    ArrayList<Product> lstProduct;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);
        rvListC = findViewById(R.id.product);

        LoadData();

        productAdapter = new ProductAdapter(lstProduct,this);
        rvListC.setLayoutManager(new GridLayoutManager(this,2));
        rvListC.setAdapter(productAdapter);
    }
    @Override
    public void onItemClick(String id){
        Product selectedProduct = null;
        for(Product product : lstProduct){
            if(product.getId().equals(id)){
                selectedProduct = product;
                break;
            }
        }
        if (selectedProduct != null){
            Intent i =new Intent(this, DetailActivity.class);
            i.putExtra("userPrice",selectedProduct.getPrice());
            i.putExtra("userName",selectedProduct.getName());
            i.putExtra("userAvatar",selectedProduct.getImage());
            startActivity(i);
        }
    }

    void LoadData(){
        lstProduct = new ArrayList<>();
        lstProduct.add(new Product("1","Giay 1","...","2.500.000","1.jpg"));
        lstProduct.add(new Product("2","Giay 2","...","2.500.000","2.jpg"));
        lstProduct.add(new Product("3","Giay 3","...","2.500.000","3.jpg"));
        lstProduct.add(new Product("4","Giay 4","...","2.500.000","4.jpg"));
        lstProduct.add(new Product("5","Giay 5","...","2.500.000","5.jpg"));
        lstProduct.add(new Product("6","Giay 6","...","2.500.000","6.jpg"));
        lstProduct.add(new Product("7","Giay 7","...","2.500.000","7.jpg"));
        lstProduct.add(new Product("8","Giay 8","...","2.500.000","8.jpg"));
        lstProduct.add(new Product("9","Giay 9","...","2.500.000","9.jpg"));
        lstProduct.add(new Product("10","Giay 10","...","2.500.000","10.jpg"));
    }
}