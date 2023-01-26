package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;
import com.example.myapplication.ui.stock.CartActivity;
import com.example.myapplication.ui.stock.StockActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private CardView cvChat, cvStock, cvBmi;
    private FloatingActionButton fabCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cvChat = findViewById(R.id.chat_card);
        cvStock = findViewById(R.id.stock_card);
        cvBmi = findViewById(R.id.bmi_card);
        fabCart = findViewById(R.id.fab_cart);

        cvChat.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), ChatActivity.class)));
        cvStock.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), StockActivity.class)));
        cvBmi.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), BmiCalculatorActivity.class)));
        fabCart.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), CartActivity.class)));

    }
}
