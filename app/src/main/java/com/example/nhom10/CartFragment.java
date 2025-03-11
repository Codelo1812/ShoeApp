package com.example.nhom10;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    private ListView cartList;
    private Button btnCheckout;
    private DatabaseHelper databaseHelper;
    private ArrayList<CartItem> cartItems;
    private CartAdapter cartAdapter;

    public CartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        cartList = view.findViewById(R.id.cart_list);
        btnCheckout = view.findViewById(R.id.btn_checkout);
        databaseHelper = new DatabaseHelper(getContext());

        loadCartData();

        btnCheckout.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private void loadCartData() {
        cartItems = new ArrayList<>();
        Cursor cursor = databaseHelper.getCartItems();
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            double price = cursor.getDouble(2);
            int quantity = cursor.getInt(3);
            String imageUrl = cursor.getString(4); // Lấy đường dẫn ảnh
            cartItems.add(new CartItem(name, price, quantity, imageUrl));
        }
        cursor.close();

        cartAdapter = new CartAdapter(getContext(), cartItems);
        cartList.setAdapter(cartAdapter);
    }
}