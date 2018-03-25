package com.example.vaibhav.a21matchsticks;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Parent extends AppCompatActivity {

    public EditText player1, player2;
    public TextView remaining, instructions, player2Name;
    public String p1s, p2s;
    public int p1, p2, rem=21;
    public Button button;
    public Resources res;
    Others other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vs_ai);

        identify();
    }

    public void identify() {

        player1 = (EditText) findViewById(R.id.player1);
        player2 = (EditText) findViewById(R.id.player2);
        remaining = (TextView) findViewById(R.id.remaining);
        instructions = (TextView) findViewById(R.id.instructions);
        button = (Button) findViewById(R.id.button);
        player2Name = (TextView) findViewById(R.id.player2_name);
        res = getResources();

        firstActions();
    }

    public void firstActions() {
        player2.setEnabled(false); //player2 button disabled
        other = new Others(this, 1);
    }

}
