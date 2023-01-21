package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private ImageView ivChat;
    private ImageView ivStock;
    private FloatingActionButton fabCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ivChat=findViewById(R.id.iv_chat);
        ivStock=findViewById(R.id.iv_stock);
        fabCart=findViewById(R.id.fab_cart);

        ivChat.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), ChatActivity.class)));
        ivStock.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), StockActivity.class)));
        fabCart.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), CartActivity.class)));

    }
}
