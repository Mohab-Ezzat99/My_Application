package com.example.myapplication.ui.stock;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Info;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MedicineAdapter;
import com.example.myapplication.model.MedicineModel;

public class StockActivity extends AppCompatActivity implements MedicineAdapter.OnItemClickListener {

    private RecyclerView rvMedicines;
    private MedicineAdapter medicineAdapter = new MedicineAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        rvMedicines = findViewById(R.id.rv_medicines);
        medicineAdapter.setList(Info.getMedicines());
        rvMedicines.setAdapter(medicineAdapter);
        medicineAdapter.setListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stock, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                medicineAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public void onItemClick(MedicineModel medicineModel) {
        Intent intent = new Intent(getBaseContext(), MedicineDetailsActivity.class);
        intent.putExtra("medicine", medicineModel);
        startActivity(intent);
    }
}
