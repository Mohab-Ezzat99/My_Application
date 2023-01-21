package com.example.myapplication.ui.stock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel;
import com.example.myapplication.adapter.MedicineAdapter;
import com.example.myapplication.model.MedicineModel;

public class CartActivity extends AppCompatActivity implements MedicineAdapter.OnItemClickListener {

    private ViewModel viewModel;
    private RecyclerView rvMedicines;
    private Button btn_pay;
    private TextView tv_total;
    private TextView tv_empty;
    private MedicineAdapter medicineAdapter = new MedicineAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        rvMedicines = findViewById(R.id.rv_cartMedicines);
        btn_pay = findViewById(R.id.btn_pay);
        tv_total = findViewById(R.id.tv_total);
        tv_empty = findViewById(R.id.tv_empty);
        rvMedicines.setAdapter(medicineAdapter);
        medicineAdapter.setListener(this);
        medicineAdapter.setCanDelete(true);

        fetchAllMedicines();
        btn_pay.setOnClickListener(v -> {
            viewModel.deleteAllCartMedicines();
            Toast.makeText(this, "Paid Successfully", Toast.LENGTH_SHORT).show();
        });
    }

    private void fetchAllMedicines() {
        viewModel.getAllCartMedicines().observe(this, medicineModels -> {
            medicineAdapter.setList(medicineModels);
            if (medicineModels.isEmpty()) {
                tv_empty.setVisibility(View.VISIBLE);
                tv_total.setVisibility(View.GONE);
                btn_pay.setVisibility(View.GONE);
            } else {
                tv_empty.setVisibility(View.GONE);
                tv_total.setVisibility(View.VISIBLE);
                btn_pay.setVisibility(View.VISIBLE);

                int total = 0;
                for (MedicineModel item : medicineModels) {
                    total += item.getPrice();
                }
                tv_total.setText(total + " SAR");
            }
        });
    }

    @Override
    public void onItemClick(MedicineModel medicineModel) {

    }

    @Override
    public void onDeleteClick(MedicineModel medicineModel) {
        viewModel.deleteMedicine(medicineModel);
    }
}
