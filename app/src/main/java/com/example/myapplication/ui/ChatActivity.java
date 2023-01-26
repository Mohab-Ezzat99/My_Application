package com.example.myapplication.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel;
import com.example.myapplication.adapter.MessageAdapter;
import com.example.myapplication.model.MessageModel;

public class ChatActivity extends AppCompatActivity {

    private ViewModel viewModel;
    private ImageView ivSend;
    private EditText etMessage;
    private RecyclerView rvMessage;
    private MessageAdapter messageAdapter = new MessageAdapter();
    private boolean isDoctor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        ivSend = findViewById(R.id.iv_send);
        etMessage = findViewById(R.id.et_message);
        rvMessage = findViewById(R.id.rv_messages);
        rvMessage.setAdapter(messageAdapter);

        setupTextWatcher();
        ivSend.setOnClickListener(v -> {
            int senderType;
            if (isDoctor) senderType = 0;
            else senderType = 1;
            String message = etMessage.getText().toString().trim();
            viewModel.insertMessage(new MessageModel(senderType, message));
            etMessage.setText("");
        });

        fetchAllMessages();
    }

    private void fetchAllMessages() {
        viewModel.getAllMessages().observe(this, messagesModels -> {
            messageAdapter.setList(messagesModels);
            if (messageAdapter.getItemCount() > 0) {
                messageAdapter.notifyDataSetChanged();
                rvMessage.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }

    private void setupTextWatcher() {
        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    ivSend.setEnabled(false);
                    ivSend.setImageResource(R.drawable.ic_send_unactive);
                } else {
                    ivSend.setEnabled(true);
                    ivSend.setImageResource(R.drawable.ic_send_active);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.menu_delete:
                viewModel.deleteAllMessages();
                break;

            case R.id.menu_senderType:
                isDoctor = !isDoctor;
                if (isDoctor) {
                    setTitle("Doctor");
                    item.setIcon(R.drawable.ic_doctor);
                }
                else {
                    setTitle("User");
                    item.setIcon(R.drawable.ic_patient);
                }
                break;
        }

        return true;
    }
}
