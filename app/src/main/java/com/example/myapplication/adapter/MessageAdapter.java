package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.MessageModel;
import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ClientViewHolder> {
    private List<MessageModel> list = new ArrayList<>();

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClientViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        MessageModel item = list.get(position);
        holder.tv_doctor_message.setText(item.getMessage());

        if (item.getSenderType() == 0) {
            holder.tv_patient_message.setVisibility(View.INVISIBLE);
            holder.tv_doctor_message.setVisibility(View.VISIBLE);
            holder.tv_doctor_message.setText(item.getMessage());
        }
        else {
            holder.tv_doctor_message.setVisibility(View.INVISIBLE);
            holder.tv_patient_message.setVisibility(View.VISIBLE);
            holder.tv_patient_message.setText(item.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<MessageModel> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    static class ClientViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_doctor_message, tv_patient_message;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_doctor_message = itemView.findViewById(R.id.tv_doctor_message);
            tv_patient_message = itemView.findViewById(R.id.tv_patient_message);
        }
    }

}