package com.example.testapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testapplication.LazyLoader.ImageLoader;
import com.example.testapplication.Models.FoodMenuModel;
import com.example.testapplication.Utils.SingletonClass;

import java.io.File;

public class MenuDetailsActivity extends AppCompatActivity {
    private static final String TAG = "MenuDetailsActivity";
    TextView textViewTitle, textViewDescription;
    ImageView foodImage;
    FoodMenuModel model;
    ImageLoader imageLoader;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);

        textViewDescription = findViewById(R.id.textViewDescription);
        textViewTitle = findViewById(R.id.textViewTitle);
        foodImage = findViewById(R.id.imageViewFoodDetails);

        Intent intent = getIntent();
        if (intent.hasExtra("model")) {
            //get the serialized model from intent
            model = (FoodMenuModel) intent.getSerializableExtra("model");

            //set Image
            String url = "http:" + model.getImage();
            imageLoader = new ImageLoader(getApplicationContext());
            imageLoader.DisplayImage(url, foodImage);

            //set Title
            textViewTitle.setText(model.getTitle());

            //set Description
            textViewDescription.setText(model.getStory());
        }else{

        }
    }
}
