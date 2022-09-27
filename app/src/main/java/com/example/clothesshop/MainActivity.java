package com.example.clothesshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText editTextName;
    EditText editTextAddress;
    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text3);
        editTextName = findViewById(R.id.nameET);
        editTextAddress = findViewById(R.id.addresET);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String color = intent.getStringExtra("color");
        price = intent.getStringExtra("price");

        String info = "Наименование товара: " + type +"\n" +
                "Цвет: " + color +"\n" +
                "Цена: " + price;
        text.setText(info);
    }

    public void createorederclick(View view) {
        if (editTextName.getText().toString().trim().length() > 0 &&
                editTextAddress.getText().toString().trim().length() > 0){
            Intent intent = new Intent(this, Orderinfo.class);
            intent.putExtra("name", editTextName.getText().toString().trim());
            intent.putExtra("addres", editTextAddress.getText().toString().trim());
            intent.putExtra("price", price);
            startActivity(intent);
        }
    }
}