package com.example.vaibhav.a21matchsticks;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Vaibhav on 7/28/2016.
 */
public class Others {

    Parent myActivity;

    public Others(Activity callingActivity, int i) {
        myActivity = (Parent) callingActivity;
    }

    public boolean check5(int rem, int p, EditText field) {

        if (p < 1 || p > 4) {
            myActivity.player1.clearComposingText();
            myActivity.instructions.setText(R.string.try_again);
            myActivity.instructions.setTextColor(Color.RED);
            return true;
        } else if (p > rem) {
            myActivity.player1.clearComposingText();
            myActivity.instructions.setText(R.string.insufficient_matchsticks);
            myActivity.instructions.setTextColor(Color.RED);
            return true;
        } else if (p == rem) {
            myActivity.player1.clearComposingText();
            myActivity.instructions.setText(R.string.you_will_lose);
            myActivity.instructions.setTextColor(Color.RED);
            return true;
        } else if(field.getText().toString()==null) { return true;
        } else return false;
    }

    public void gameEnd(int a) {

        if (a == 0) {
            myActivity.instructions.setText(R.string.comp_win);
            myActivity.instructions.setTextColor(Color.RED);
        }

        if (a == 1) {
            myActivity.instructions.setText(R.string.win1);
            myActivity.instructions.setTextColor(Color.YELLOW);
        } else {
            myActivity.instructions.setText(R.string.win2);
            myActivity.instructions.setTextColor(Color.GREEN);
        }

        myActivity.player1.setEnabled(false);
        myActivity.player2.setEnabled(false);
        myActivity.button.setText("Try again");
        myActivity.button.setBackgroundColor(Color.BLUE);
        myActivity.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myActivity.recreate();
            }
        });
    }

    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}