package com.example.clothesshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Orderinfo extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        Intent intent = getIntent();
        txt = findViewById(R.id.textView);
        txt.setText(intent.getStringExtra("name") + "," + "\n"+
                "ваш заказ на адрес" + "\n"+
                intent.getStringExtra("addres") + "\n"+
                "на сумму " + intent.getStringExtra("price") + " отправлен");
    }

    public void but(View view) {
        Intent intent = new Intent(this, create_order.class);
        startActivity(intent);
    }
}