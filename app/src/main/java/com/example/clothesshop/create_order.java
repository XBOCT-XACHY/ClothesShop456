package com.example.clothesshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class create_order extends AppCompatActivity {

    Spinner spinner;
    ImageView image;
    RadioButton rWhite;
    RadioButton rBlack;
    TextView textPrice;
    String priceProduct;
    String typeProduct;
    String colorsProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.imageProduct);
        rWhite = findViewById(R.id.radioWhite);
        rBlack = findViewById(R.id.radioBlack);
        textPrice = findViewById(R.id.textPrice);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                refresh();
            }
        });
    }
    void setinfo(){
        priceProduct = textPrice.getText().toString();
        typeProduct = spinner.getSelectedItem().toString();
        if (rWhite.isChecked()){
            colorsProduct = "Белый";
        }
        else{
            colorsProduct = "Чёрный";
        }

    }

    void refresh(){
        if (spinner.getSelectedItemPosition() == 0){
            rWhite.setVisibility(View.VISIBLE);
            if (rWhite.isChecked()){
                image.setImageResource(R.drawable.mfutwhite);
                textPrice.setText("500 руб");
            }
            else if (rBlack.isChecked()){
                image.setImageResource(R.drawable.mfutblack);
                textPrice.setText("500 руб");
            }
        }

        else if (spinner.getSelectedItemPosition() == 1){
            rWhite.setVisibility(View.GONE);
            rBlack.setChecked(true);
            image.setImageResource(R.drawable.mshortblack);
            textPrice.setText("700 руб");
        }

        else if (spinner.getSelectedItemPosition() == 2){
            rWhite.setVisibility(View.VISIBLE);
            if (rWhite.isChecked()){
                image.setImageResource(R.drawable.msockwhite);
                textPrice.setText("100 руб");
            }
            else if (rBlack.isChecked()){
                image.setImageResource(R.drawable.msockblack);
                textPrice.setText("100 руб");
            }
        }
    }

    public void radclick(View view) {
        refresh();
    }

    public void addProductButton(View view) throws IOException {
        setinfo();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("type", typeProduct);
        intent.putExtra("color", colorsProduct);
        intent.putExtra("price", priceProduct);
        startActivity(intent);


    }
}