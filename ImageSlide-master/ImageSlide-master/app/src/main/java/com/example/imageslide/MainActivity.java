package com.example.imageslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
        Button previousImage = findViewById(R.id.previousButton);
        Button nextImage = findViewById(R.id.nextButton);
        final int[] currentImage = {0};

        imageList.add(new SlideModel(R.drawable.image1, "The sky.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.image2, "Sky in evening", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.image3, "Beautiful sky.", ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        imageSlider.stopSliding();

        nextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImage[0] < imageList.size() - 1) {
                    currentImage[0]++;
                    imageSlider.setImageList(Collections.singletonList(imageList.get(currentImage[0])));
                }
            }
        });
        previousImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImage[0] > 0) {
                    currentImage[0]--;
                    imageSlider.setImageList(Collections.singletonList(imageList.get(currentImage[0])));
                }
            }
        });
    }
}