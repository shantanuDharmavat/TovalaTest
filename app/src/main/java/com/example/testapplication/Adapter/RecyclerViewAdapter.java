package com.example.testapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.LazyLoader.ImageLoader;
import com.example.testapplication.MainActivity;
import com.example.testapplication.MenuDetailsActivity;
import com.example.testapplication.R;
import com.example.testapplication.Models.FoodMenuModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>   {
    private static ArrayList<FoodMenuModel> menuList;
    private ImageLoader imageLoader;
    private static Context context;
    private AdapterView.OnItemClickListener itemClickListener;
    private static String TAG = "RecyclerViewAdapter";
    private static FoodMenuModel model;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        CardView cardView;
        TextView textViewTitle;
        ImageView foodImage;

        public MyViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view);
            textViewTitle = v.findViewById(R.id.info_text);
            foodImage = v.findViewById(R.id.imageView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e(TAG,"ITEM CLICK: " + getLayoutPosition());
            Intent intent = new Intent(context, MenuDetailsActivity.class);
            model = menuList.get(getLayoutPosition());
            intent.putExtra("model",model);

            context.startActivity(intent);
        }
    }

    public RecyclerViewAdapter(ArrayList<FoodMenuModel> menuList) {
        this.menuList = menuList;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        model = menuList.get(position);

        //get Title of the model
        holder.textViewTitle.setText(model.getTitle());
        //get image url of the model
        String url = "http:"+model.getImage();

        imageLoader = new ImageLoader(context.getApplicationContext());
        imageLoader.DisplayImage(url,holder.foodImage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
