package com.example.nhom10;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ListView cartListView;
    private TextView totalTextView;
    private Button checkoutButton;
    private CartAdapter cartAdapter;
    private DatabaseHelper cartDatabaseHelper;
    private ArrayList<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cart_list_view);
        totalTextView = findViewById(R.id.total_price);
        checkoutButton = findViewById(R.id.checkout_button);
        cartDatabaseHelper = new DatabaseHelper(this);

        loadCartData();

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartItems.isEmpty()) {
                    Toast.makeText(CartActivity.this, "Giỏ hàng trống!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CartActivity.this, "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
                    cartDatabaseHelper.clearCart();
                    loadCartData();
                }
            }
        });
    }

    private void loadCartData() {
        cartItems = new ArrayList<>();
        Cursor cursor = cartDatabaseHelper.getAllCartItems();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int quantity = cursor.getInt(2);
                double price = cursor.getDouble(3);
                cartItems.add(new CartItem(id, name, quantity, price));
            }
            cursor.close();
        }

        cartAdapter = new CartAdapter(this, cartItems, cartDatabaseHelper);
        cartListView.setAdapter(cartAdapter);
        updateTotalPrice();
    }

    public void updateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        totalTextView.setText("Tổng tiền: " + total + " VND");
    }
}
