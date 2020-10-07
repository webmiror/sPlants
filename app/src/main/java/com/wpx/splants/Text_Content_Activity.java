package com.wpx.splants;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private int category;
    private int position;
    private int [] array_plants = {R.string.avokado, R.string.aglaonema};
    private int [] array_images = {R.drawable.avokad_1, R.drawable.aglaonema};
    private TextView text_content;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        image = findViewById(R.id.imagePlants);
        recieveIntent();
    }

    private void recieveIntent() {
        Intent i = getIntent();
        if(i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category) {
            case 1:
                text_content.setText(array_plants[position]);
                image.setImageResource(array_images[position]);
                break;
            case 2:

                break;
        }
    }

}
