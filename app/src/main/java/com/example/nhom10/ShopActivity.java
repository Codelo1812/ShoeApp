package com.example.nhom10;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {
    RecyclerView rvListC;
    ArrayList<User> lstUser;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);
        rvListC = findViewById(R.id.product);
        LoadData();
        userAdapter = new UserAdapter(lstUser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListC.setAdapter(userAdapter);
        rvListC.setLayoutManager(linearLayoutManager);
    }
    void LoadData(){
        lstUser = new ArrayList<>();
        lstUser.add(new User("1","Giay 1","1.jpg","2.500.000"));
    }
}