package com.example.email;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.email.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EditText editText = findViewById(R.id.phone);
        double value = Double.parseDouble(editText.getText().toString());
        binding.tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + binding.tel.getText().toString()));
                startActivity(intent);
            }
        });
        binding.send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String s = "";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: "));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Доставка");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"12345@yadex.ru"});
                intent.putExtra(Intent.EXTRA_TEXT, "Продукты:");
                s += "Продукты: " + '\n';
                if(binding.fr.isChecked()) s += "Фрукты" + '\n';
                if(binding.ov.isChecked()) s += "Овощи" + '\n';
                if(binding.ot.isChecked()) s += "Отчёты" + '\n';
                if(binding.av.isChecked()) s += "Автоматы" + '\n';
                if(binding.la.isChecked()) s += "Лабы" + '\n';
                if(binding.dos.isChecked()) s += "Дошики" + '\n';
                s += "Забрать: ";
                if(binding.dos.isChecked()) s += "Доставка" + '\n';
                if(binding.sam.isChecked()) s += "Самовывоз" + '\n';
                s += "Комментарий: " + binding.phone.getText();
                intent.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(intent);
            }
        });
        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phone.getText().clear();
                binding.grp.clearCheck();
                binding.fr.setChecked(false);
                binding.ov.setChecked(false);
                binding.ot.setChecked(false);
                binding.av.setChecked(false);
                binding.la.setChecked(false);
                binding.dos.setChecked(false);
            }
        });
    }
}