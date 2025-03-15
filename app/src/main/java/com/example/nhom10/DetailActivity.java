package com.example.nhom10;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
TextView tvDetailC;
ImageView ivDetailImage;
Button btnAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        tvDetailC = findViewById(R.id.productName);
        ivDetailImage = findViewById(R.id.product_img);
        String id = getIntent().getStringExtra("userId");
        String name = getIntent().getStringExtra("userName");
        String avatar = getIntent().getStringExtra("userAvatar");

        tvDetailC.setText("ID: " + id + "\nName: "+ name);
        Bitmap bitmap = Utils.convertToBitmapFromAssets(this,avatar);
        if(bitmap != null){
            ivDetailImage.setImageBitmap(bitmap);
        }

        btnAddToCart=findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}