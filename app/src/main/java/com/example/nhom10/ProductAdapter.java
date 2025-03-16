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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    ArrayList<Product> lstProduct;
    Context context;
    ProductAdapter.ProductCallback productCallback;

    public ProductAdapter(ArrayList<Product> lstProduct, ProductAdapter.ProductCallback productCallback){
        this.lstProduct = lstProduct;
        this.productCallback=productCallback;
    }

    //Ham gan layoutitem vao Adapter
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.layoutitem,parent,false);
        ProductAdapter.ProductViewHolder viewHolder = new ProductAdapter.ProductViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  ProductAdapter.ProductViewHolder holder, int position){
        Product item = lstProduct.get(position);
        holder.imAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context, item.getImage()));
        holder.tvPrice.setText(item.getPrice());
        holder.tvName.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.itemView.setOnClickListener(view -> productCallback.onItemClick(item.getId()));
    }
    @Override
    public int getItemCount(){
        return lstProduct.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imAvatar;
        TextView tvName;
        TextView tvPrice;
        TextView description;
        public ProductViewHolder(@NonNull View itemview){
            super(itemview);
            imAvatar = itemview.findViewById(R.id.ivAvatar);
            tvName = itemview.findViewById(R.id.name);
            tvPrice = itemview.findViewById(R.id.price);
            description= itemview.findViewById(R.id.description);
        }
    }
    public interface ProductCallback{
        void onItemClick(String id);
    }
}
