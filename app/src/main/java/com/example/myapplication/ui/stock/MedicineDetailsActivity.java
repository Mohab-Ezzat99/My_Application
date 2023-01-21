package com.example.myapplication.ui.stock;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.MedicineModel;

public class MedicineDetailsActivity extends AppCompatActivity {

    private ImageView iv_img;
    private TextView tv_name;
    private TextView tv_price;
    private TextView tv_uses;
    private TextView tv_purpose;
    private TextView tv_addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        iv_img = findViewById(R.id.iv_img);
        tv_name = findViewById(R.id.tv_name);
        tv_price = findViewById(R.id.tv_price);
        tv_uses = findViewById(R.id.tv_uses);
        tv_purpose = findViewById(R.id.tv_purpose);
        tv_addToCart = findViewById(R.id.tv_addToCart);

        MedicineModel medicineModel = (MedicineModel) getIntent().getSerializableExtra("medicine");
        iv_img.setImageResource(medicineModel.getImg());
        tv_name.setText(medicineModel.getName());
        tv_price.setText(medicineModel.getPrice());
        tv_uses.setText(medicineModel.getUses());
        tv_purpose.setText(medicineModel.getPurpose());

        tv_addToCart.setOnClickListener(v -> {
            Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
        });

    }
}
