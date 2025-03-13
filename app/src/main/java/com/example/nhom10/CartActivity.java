package com.example.nhom10;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
ListView cartListView;
CartAdapter cartAdapter;
ArrayList<CartItem> cartItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cart_list);
        cartItems = loadCartData();

        cartAdapter = new CartAdapter(this,cartItems);
        cartListView.setAdapter(cartAdapter);
    }
    private ArrayList<CartItem> loadCartData(){
        ArrayList<CartItem> items = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("CartData", Context.MODE_PRIVATE);
        String cartString = sharedPreferences.getString("cart", "[]");

        try {
            JSONArray cartArray =new JSONArray(cartString);
            for(int i = 0;i < cartArray.length();i++){
                JSONObject item = cartArray.getJSONObject(i);
                String name = item.getString("name");
                String price = item.getString("price");
                String size = item.getString("size");
                items.add(new CartItem(name,price,size));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}