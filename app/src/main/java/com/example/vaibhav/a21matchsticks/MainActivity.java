package com.example.vaibhav.a21matchsticks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playVsComputer(View view) {
        Intent intent = new Intent(this, Art.class);
        startActivity(intent);
    }

    public void playVsHuman(View view) {
        Intent intent = new Intent(this, PlayerVsHuman.class);
        startActivity(intent);
    }

    public void instructions(View view) {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
    }

}
