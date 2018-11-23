package com.example.frebby.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button xButton;
    Button oButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        xButton = findViewById(R.id.xButton);
        xButton.setOnClickListener(this);
        oButton = findViewById(R.id.oButton);
        oButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if(xButton.isPressed()){
           intent = new Intent(this, MainActivity.class);
           intent.putExtra("xButton", xButton.isPressed());
           startActivity(intent);
       }
        else if(oButton.isPressed()){
           intent = new Intent(this, MainActivity.class);
           intent.putExtra("oButton", oButton.isPressed());
            startActivity(intent);
        }
    }


}



