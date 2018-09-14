package com.fallendeductionist.evaluacion1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.net.Proxy.Type.HTTP;

public class InformationActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent intent = getIntent();
        ExampleEmployee exampleEmployee = intent.getParcelableExtra("Example Employee");

        int imageRes = exampleEmployee.getImageResource();
        String line1 = exampleEmployee.getText1();
        String line2 = exampleEmployee.getText2();
        String line3 = exampleEmployee.getText3();
        String line4 = exampleEmployee.getText4();
        String line5 = exampleEmployee.getText5();

        ImageView imageView = findViewById(R.id.portrait);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.name);
        textView1.setText(line1);

        TextView textView2 = findViewById(R.id.charge);
        textView2.setText(line2);

        TextView textView3 = findViewById(R.id.phone);
        textView3.setText(line3);

        TextView textView4 = findViewById(R.id.email);
        textView4.setText(line4);

        TextView textView5 = findViewById(R.id.website);
        textView5.setText(line5);

    }

    public void onClick(View v) {

        TextView phone = findViewById(R.id.phone);
        String number = phone.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        startActivity(intent);
        finish();
    }

    public void onClick2(View v){

        TextView address = findViewById(R.id.email);
        String email = address.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {email}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
            finish();
        }else{
            Toast.makeText(this, "No cuenta con el activity", Toast.LENGTH_SHORT).show();
        }


    }

    public void onClick3(View v){

        TextView web = findViewById(R.id.website);
        String website = web.getText().toString();

        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + website));
        startActivity(webIntent);
        finish();
    }

}


