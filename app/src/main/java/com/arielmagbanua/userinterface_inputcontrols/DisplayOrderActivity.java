package com.arielmagbanua.userinterface_inputcontrols;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayOrderActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView flavorTextView = findViewById(R.id.flavorsEmptyView);
        flavorTextView.setTextSize(20);
        flavorTextView.setText(message);

        setContentView(flavorTextView);


    }

}
