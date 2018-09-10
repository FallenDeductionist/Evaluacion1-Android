package com.fallendeductionist.evaluacion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class InformationActivity extends AppCompatActivity {

    private int[] photos = {
            R.drawable.picture1,
            R.drawable.picture2,
            R.drawable.picture3,
    };

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        imageView = (ImageView)findViewById(R.id.imageView1);


    }
}
