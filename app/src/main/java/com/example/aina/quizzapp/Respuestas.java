package com.example.aina.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by Aina on 07/04/2017.
 */

public class Respuestas extends AppCompatActivity {

    TextView res, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respuestas);
        res = (TextView) findViewById(R.id.res);
        msg = (TextView) findViewById(R.id.message);
        double r = getIntent().getDoubleExtra("result", 0);

        String description = get_description(r);
        msg.setText(description);
        DecimalFormat df = new DecimalFormat("#.#");
        res.setText("" + df.format(r));
    }
    public void restart_quiz(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    private String get_description(double res){
        String s;
        if (res > 5 && res < 8) s = "You did  great, but there is still room for improvement. Keep trying!";
        else if (res >= 8) s = "Woah! Good job! You seem to know a lot about the world in which we live in!";
        else s = "You should try harder next time! We are sure you will do great!";
        return s;
    }
}


