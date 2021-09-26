package com.example.foods;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText addressb;
    EditText branch;

    private Button button;

    String address;
    String branchb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        branch=findViewById(R.id.branch1);
        addressb=findViewById(R.id.textInputEditText);
        button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }
    public void sendData()
    {
        branchb = branch.getText().toString().trim();
        address = addressb.getText().toString().trim();

        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra("ADDRESS",address);
        intent.putExtra("BRANCH",branchb);

        startActivity(intent);
    }
}