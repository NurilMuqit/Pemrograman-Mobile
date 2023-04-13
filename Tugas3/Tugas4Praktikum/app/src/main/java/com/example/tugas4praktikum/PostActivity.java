package com.example.tugas4praktikum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class PostActivity extends AppCompatActivity {
    ImageView post;
    EditText capt;
    Button upload;
    public static final String Key1 = "capt";
    private static final int RESULT_IMGUPL =1;
    Uri selectedImage1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        post = findViewById(R.id.post);
        capt = findViewById(R.id.capt);
        upload = findViewById(R.id.upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((post.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.profilepic).getConstantState())){
                    Toast.makeText(PostActivity.this, "Upload Image First", Toast.LENGTH_SHORT).show();
                }else {
                    String user= getIntent().getStringExtra("Uname");
                    String name= getIntent().getStringExtra("Fname");
                    Uri selectedImage = getIntent().getParcelableExtra("profile");
                    String caption = capt.getText().toString() ;
                    Intent Keline = new Intent(getApplicationContext(), Timeline.class);
                    Keline.putExtra(Key1 , caption);
                    Keline.putExtra("profile", selectedImage);
                    Keline.putExtra("Uname", user);
                    Keline.putExtra("Fname", name);
                    Keline.putExtra("img" ,selectedImage1);
                    startActivity(Keline);
                }
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upIMG = new Intent(Intent.ACTION_PICK);
                upIMG.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(upIMG,RESULT_IMGUPL);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMGUPL && resultCode == RESULT_OK){

            selectedImage1 = data.getData();
            post.setImageURI(selectedImage1);
        }
    }
}