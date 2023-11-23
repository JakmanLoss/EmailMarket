package com.example.email;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.email.databinding.ActivityMainBinding;

public class Secondary extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + binding.phone.getText().toString()));
                startActivity(intent);
            }
        });
        binding.send.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: "));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                intent.putExtra(Intent.EXTRA_EMAIL, "12345@yadex.ru");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Доставка");
                startActivity(intent);
            }
        });
    }
}
