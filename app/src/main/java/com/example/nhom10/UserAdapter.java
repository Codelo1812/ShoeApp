package com.example.nhom10;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> lstUser;
    Context context;
    public UserAdapter(ArrayList<User> lstUser){
        this.lstUser = lstUser;
    }

    //Ham gan layoutitem vao Adapter
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.layoutitem,parent,false);
        UserViewHolder viewHolder = new UserViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder,int position){
        User item = lstUser.get(position);
        holder.imAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context, item.getAvatar()));
        holder.tvPrice.setText(item.getPrice());
        holder.tvName.setText(item.getName());
    }
    @Override
    public int getItemCount(){
        return lstUser.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView imAvatar;
        TextView tvName;
        TextView tvPrice;
        public UserViewHolder(@NonNull View itemview){
            super(itemview);
            imAvatar = itemview.findViewById(R.id.ivAvatar);
            tvName = itemview.findViewById(R.id.name);
            tvPrice = itemview.findViewById(R.id.price);
        }
    }
}
