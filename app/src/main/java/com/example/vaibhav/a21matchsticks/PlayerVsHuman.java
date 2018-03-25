package com.example.vaibhav.a21matchsticks;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayerVsHuman extends Parent {

    int chance = 1;

    public void startGame(View view) {
        if(chance%2 != 0) player1();
        else player2();
    }

    public void player1() { //getting the value of remaining number of matchsticks
        rem = Integer.parseInt(remaining.getText().toString());

        p1s = player1.getText().toString(); //getting the value entered by user
        p1 = Integer.parseInt(p1s);

        if(other.check5(rem, p1, player1)) {other.hideKeyboard(this); return; }

        rem = rem - p1;
        remaining.setText(Integer.toString(rem));

        instructions.setText(String.format(res.getString(R.string.player2chance), p1));
        instructions.setTextColor(Color.BLUE);

        if (rem <= 1) other.gameEnd(1);

        chance++;
        player2.setEnabled(true);
        player1.setEnabled(false);
    }

    public void player2() {

        //getting the value of remaining number of matchsticks
        rem = Integer.parseInt(remaining.getText().toString());

        p2s = player2.getText().toString(); //getting the value entered by user
        p2 = Integer.parseInt(p2s);

        if(other.check5(rem, p2, player2)) {other.hideKeyboard(this); return; }

        rem = rem - p2;
        remaining.setText(Integer.toString(rem));

        instructions.setText(String.format(res.getString(R.string.player1chance), p2));
        instructions.setTextColor(Color.BLUE);

        if (rem <= 1) other.gameEnd(2);

        chance++;
        player1.setEnabled(true);
        player2.setEnabled(false);
    }
}