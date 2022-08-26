package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruitList ;

    private Context context;

    public FruitAdapter(List<Fruit> list){
        fruitList = list;
    }

//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(context == null){
//            context = parent.getContext();
//        }
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
//        return new ViewHolder(view);
//    }
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if(context == null){
        context = parent.getContext();
    }
    View view = LayoutInflater.from(context).inflate(R.layout.fruit_item,parent,false);
    final ViewHolder holder = new ViewHolder(view);
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = holder.getAdapterPosition();
            Fruit fruit = fruitList.get(position);
            Intent intent = new Intent(context,FruitActivity.class);
            intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
            intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImageID());
            context.startActivity(intent);
        }
    });
    return holder;
}

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        //holder.imageView.setImageResource(fruit.getImageId());
        //自动压缩图片，不用担心像素过高
        Glide.with(context).load(fruit.getImageID()).into(holder.imageView);
        holder.textView.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = itemView.findViewById(R.id.fruit_image);
            textView = itemView.findViewById(R.id.fruit_name);
        }
    }
}

