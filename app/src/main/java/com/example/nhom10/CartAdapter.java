package com.example.nhom10;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CartItem> cartItems;

    public CartAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        }

        ImageView imgProduct = convertView.findViewById(R.id.img_product);
        TextView txtName = convertView.findViewById(R.id.txt_name);
        TextView txtPrice = convertView.findViewById(R.id.txt_price);
        TextView txtQuantity = convertView.findViewById(R.id.txt_quantity);

        CartItem item = cartItems.get(position);
        txtName.setText(item.getName());
        txtPrice.setText("Giá: " + item.getPrice() + " VND");
        txtQuantity.setText("Số lượng: " + item.getQuantity());
        File imgFile = new File(item.getImageUrl());
        if (imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imgProduct.setImageBitmap(bitmap);
        } else {
            imgProduct.setImageResource(R.drawable.ic_launcher_background); // Ảnh mặc định nếu không có ảnh
        }


        return convertView;
    }

}
