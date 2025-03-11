package com.example.nhom10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class ShopFragment extends Fragment {
    RecyclerView rvListC;
    ArrayList<User> lstUser;
    UserAdapter userAdapter;

    public ShopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        rvListC = view.findViewById(R.id.product);
        LoadData();
        rvListC.setLayoutManager(new LinearLayoutManager(getContext()));
        userAdapter = new UserAdapter(lstUser);
        rvListC.setAdapter(userAdapter);
        return view;
    }
    private void LoadData(){
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