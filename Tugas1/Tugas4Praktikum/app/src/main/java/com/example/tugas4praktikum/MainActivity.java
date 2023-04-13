package com.example.tugas4praktikum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText fullName, userName;
    ShapeableImageView profileImage;
    Button submit;
    Uri selectedImage;
    private static final int RESULT_IMG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName = findViewById(R.id.fullName);
        userName = findViewById(R.id.userName);
        profileImage = findViewById(R.id.profileImage);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(view -> {
            if (TextUtils.isEmpty(userName.getText().toString()) && TextUtils.isEmpty(fullName.getText().toString()) && profileImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.profilepic).getConstantState()){
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                userName.setError("This field can't be empty");
                fullName.setError("This field can't be empty");

            } else if (TextUtils.isEmpty(userName.getText().toString()) && TextUtils.isEmpty(fullName.getText().toString())) {
                userName.setError("This field can't be empty");
                fullName.setError("This field can't be empty");
            } else if (profileImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.profilepic).getConstantState() && TextUtils.isEmpty(fullName.getText().toString())) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                fullName.setError("This field can't be empty");
            }else if (profileImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.profilepic).getConstantState() && TextUtils.isEmpty(userName.getText().toString())) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                userName.setError("This field can't be empty");
            }else if (profileImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.profilepic).getConstantState()) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(userName.getText().toString())) {
                userName.setError("This field can't be empty");
            } else if (TextUtils.isEmpty(fullName.getText().toString())) {
                fullName.setError("This field can't be empty");
            }else {
                Intent KePost = new Intent(getApplicationContext(), PostActivity.class);
                String user = userName.getText().toString();
                String name = fullName.getText().toString();
                KePost.putExtra("Uname" , user);
                KePost.putExtra("Fname" , name);
                KePost.putExtra("profile" ,selectedImage);
                startActivity(KePost);
            }
        });
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uplImage = new Intent(Intent.ACTION_PICK);
                uplImage.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(uplImage,RESULT_IMG);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMG && resultCode == RESULT_OK){

            selectedImage = data.getData();
            profileImage.setImageURI(selectedImage);
        }
    }
}