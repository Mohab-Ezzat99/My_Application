package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    private ImageView ivChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ivChat=findViewById(R.id.iv_chat);

        ivChat.setOnClickListener(v -> startActivity(new Intent(getBaseContext(), ChatActivity.class)));

    }
}
