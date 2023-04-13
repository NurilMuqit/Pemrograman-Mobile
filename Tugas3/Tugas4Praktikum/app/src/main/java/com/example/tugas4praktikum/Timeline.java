package com.example.tugas4praktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class Timeline extends AppCompatActivity {

    ShapeableImageView profile;
    TextView user, name, capt;
    ImageView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        profile = findViewById(R.id.profile);
        user = findViewById(R.id.user);
        name = findViewById(R.id.name);
        capt = findViewById(R.id.capt);
        post = findViewById(R.id.post);

        Intent keline = getIntent();
        String data= getIntent().getStringExtra("Uname");
        String data1= getIntent().getStringExtra("Fname");
        Uri uri = (Uri) keline.getParcelableExtra("img");
        Uri uri1 = (Uri) keline.getParcelableExtra("profile");
        String putCapt = keline.getStringExtra(PostActivity.Key1);
        user.setText(data);
        name.setText(data1);
        capt.setText(putCapt);
        post.setImageURI(uri);
        profile.setImageURI(uri1);
    }
}