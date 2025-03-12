package com.example.nhom10;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements UserAdapter.UserCallback {
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
        userAdapter = new UserAdapter(lstUser,this);
        rvListC.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvListC.setAdapter(userAdapter);
    }
    @Override
    public void onItemClick(String id){
        User selectedUser = null;
        for(User user : lstUser){
            if(user.getId().equals(id)){
                selectedUser = user;
                break;
            }
        }
        if (selectedUser != null){
            Intent i =new Intent(this, DetailActivity.class);
            i.putExtra("userId",selectedUser.getId());
            i.putExtra("userName",selectedUser.getName());
            i.putExtra("userAvatar",selectedUser.getAvatar());
            startActivity(i);
        }
    }

    void LoadData(){
        lstUser = new ArrayList<>();
        lstUser.add(new User("1","Giay 1","1.jpg","2.500.000"));
        lstUser.add(new User("2","Giay 2","2.jpg","2.500.000"));
        lstUser.add(new User("3","Giay 3","3.jpg","2.500.000"));
        lstUser.add(new User("4","Giay 4","4.jpg","2.500.000"));
        lstUser.add(new User("5","Giay 5","5.jpg","2.500.000"));
        lstUser.add(new User("6","Giay 6","6.jpg","2.500.000"));
        lstUser.add(new User("7","Giay 7","7.jpg","2.500.000"));
        lstUser.add(new User("8","Giay 8","8.jpg","2.500.000"));
        lstUser.add(new User("9","Giay 9","9.jpg","2.500.000"));
        lstUser.add(new User("10","Giay 10","10.jpg","2.500.000"));
    }
}