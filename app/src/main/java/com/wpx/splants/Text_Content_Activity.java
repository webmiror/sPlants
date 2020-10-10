package com.wpx.splants;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Text_Content_Activity extends AppCompatActivity {
    private ActionBar actionBar;
    private int category;
    private int position;
    private int [] array_plants = {R.string.avokado, R.string.aglaonema};
    private int [] array_images = {R.drawable.avokad_1, R.drawable.aglaonema};
    private String [] array_title_plants = {"Авокадо", "Аглаонема","Адениум","Адромискус"};
    private TextView text_content;
    private ImageView image;
    private Typeface faceMontserrat;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        recieveIntent();
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void recieveIntent() {
        Intent i = getIntent();
        if(i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
            case 1:
                actionBar.setTitle(array_title_plants[position]);
                text_content.setText(array_plants[position]);
                image.setImageResource(array_images[position]);
                break;
            case 2:

                break;
        }
    }

    private void init() {
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        image = findViewById(R.id.imagePlants);
        faceMontserrat = Typeface.createFromAsset(this.getAssets(), "fonts/Montserrat-Regular.ttf");
        text_content.setTypeface(faceMontserrat);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;

    }
}
