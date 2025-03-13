package com.example.nhom10;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {
TextView tvDetailC;
ImageView ivDetailImage;
RadioGroup sizeGroup;
Button btnAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        tvDetailC = findViewById(R.id.productName);
        ivDetailImage = findViewById(R.id.product_img);
        sizeGroup = findViewById(R.id.sizeGroup);
        btnAddToCart =findViewById(R.id.btnAddToCart);

        String price = getIntent().getStringExtra("userPrice");
        String name = getIntent().getStringExtra("userName");
        String avatar = getIntent().getStringExtra("userAvatar");
        tvDetailC.setText("Name: "+ name + "\nPrice: "+ price );
        Bitmap bitmap = Utils.convertToBitmapFromAssets(this,avatar);
        if(bitmap != null){
            ivDetailImage.setImageBitmap(bitmap);
        }

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedSizeId = sizeGroup.getCheckedRadioButtonId();
                if(selectedSizeId == -1){
                    Toast.makeText(DetailActivity.this, "Vui long chon kich thuoc giay",Toast.LENGTH_SHORT);
                }else {
                    RadioButton selectedSize = findViewById(selectedSizeId);
                    String size = selectedSize.getText().toString();
                    JSONObject product = new JSONObject();
                    try{
                        product.put("name",name.getText().toString());
                        product.put("price",price.getText().toString());
                        product.put("size",size);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    saveToCart(product);
                    Toast.makeText(DetailActivity.this,"Da them vao gio hang!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}