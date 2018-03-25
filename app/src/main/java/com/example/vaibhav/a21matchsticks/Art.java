package com.example.vaibhav.a21matchsticks;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Art extends Parent {

    public void startGame(View view) {
        rem = Integer.parseInt(remaining.getText().toString()); //getting the number of total matchsticks left

        p1 = Integer.parseInt(player1.getText().toString()); //getting the value entered by user

        if(other.check5(rem,p1,player1)) {
            other.hideKeyboard(this);
            return;
        } //checking the input for validity

        rem = rem - p1; //player's chance
        p2 = 5 - p1; //computer's chance
        rem = rem - p2;

        remaining.setText(Integer.toString(rem));
        player2.setText(Integer.toString(p2)); //setting player's input
        remaining.setText(Integer.toString(rem));

        instructions.setText(String.format(res.getString(R.string.your_turn), p2)); //setting instruction
        instructions.setTextColor(Color.BLUE);

        if (rem <= 1) other.gameEnd(0);
    }

}
