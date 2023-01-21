package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.MedicineModel;

import java.util.ArrayList;
import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> implements Filterable {
    private List<MedicineModel> list = new ArrayList<>();
    private List<MedicineModel> searchList = new ArrayList<>(list);
    private OnItemClickListener listener;
    private boolean canDelete = false;

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MedicineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicine, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        MedicineModel item = list.get(holder.getAdapterPosition());
        holder.iv_img.setImageResource(item.getImg());
        holder.tv_name.setText(item.getName());
        holder.tv_price.setText(String.valueOf(item.getPrice()));
        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));

        if (canDelete) holder.iv_delete.setVisibility(View.VISIBLE);
        else holder.iv_delete.setVisibility(View.GONE);
        holder.iv_delete.setOnClickListener(v -> listener.onDeleteClick(item));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<MedicineModel> list) {
        this.list = list;
        this.searchList = new ArrayList<>(list);
        this.notifyDataSetChanged();
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        this.notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<MedicineModel> filterList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0)
                    filterList.addAll(searchList);
                else {
                    for (MedicineModel model : searchList) {
                        if (model.getName().contains(constraint))
                            filterList.add(model);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list.clear();
                list.addAll((List<MedicineModel>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    static class MedicineViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_delete;
        private final ImageView iv_img;
        private final TextView tv_name;
        private final TextView tv_price;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_delete = itemView.findViewById(R.id.iv_delete);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(MedicineModel medicineModel);

        void onDeleteClick(MedicineModel medicineModel);
    }
}