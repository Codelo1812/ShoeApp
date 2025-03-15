package com.example.nhom10;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<CartItem> {
    private Context context;
    private ArrayList<CartItem> cartItems;
    private DatabaseHelper cartDatabaseHelper;

    public CartAdapter(Context context, ArrayList<CartItem> cartItems, DatabaseHelper cartDatabaseHelper) {
        super(context, 0, cartItems);
        this.context = context;
        this.cartItems = cartItems;
        this.cartDatabaseHelper = cartDatabaseHelper;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        }

        CartItem cartItem = cartItems.get(position);

        TextView productName = convertView.findViewById(R.id.product_name);
        TextView productQuantity = convertView.findViewById(R.id.product_quantity);
        TextView productPrice = convertView.findViewById(R.id.product_price);
        Button btnIncrease = convertView.findViewById(R.id.btn_increase);
        Button btnDecrease = convertView.findViewById(R.id.btn_decrease);
        Button btnRemove = convertView.findViewById(R.id.btn_remove);

        productName.setText(cartItem.getName());
        productQuantity.setText("Số lượng: " + cartItem.getQuantity());
        productPrice.setText("Giá: " + (cartItem.getPrice() * cartItem.getQuantity()) + " VND");

        btnIncrease.setOnClickListener(v -> {
            cartDatabaseHelper.updateQuantity(cartItem.getId(), cartItem.getQuantity() + 1);
            refreshCart();
        });

        btnDecrease.setOnClickListener(v -> {
            if (cartItem.getQuantity() > 1) {
                cartDatabaseHelper.updateQuantity(cartItem.getId(), cartItem.getQuantity() - 1);
            } else {
                cartDatabaseHelper.removeFromCart(cartItem.getId());
            }
            refreshCart();
        });

        btnRemove.setOnClickListener(v -> {
            cartDatabaseHelper.removeFromCart(cartItem.getId());
            Toast.makeText(context, "Đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
            refreshCart();
        });

        return convertView;
    }

    private void refreshCart() {
        cartItems.clear();
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
        notifyDataSetChanged();

        if (context instanceof CartActivity) {
            ((CartActivity) context).updateTotalPrice();
        }
    }
}
