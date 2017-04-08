package com.example.aina.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Aina on 07/04/2017.
 */

public class Preguntas extends AppCompatActivity {

    RadioGroup r1, r4, r5, r7, r8, r9, r0;
    CheckBox c21, c22, c23, c24, c61, c62, c63, c64;
    EditText e3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas);

        //RADIO GROUPS
        r1 = (RadioGroup) findViewById(R.id.rg1);
        r4 = (RadioGroup) findViewById(R.id.rg4);
        r5 = (RadioGroup) findViewById(R.id.rg5);
        r7 = (RadioGroup) findViewById(R.id.rg7);
        r8 = (RadioGroup) findViewById(R.id.rg8);
        r9 = (RadioGroup) findViewById(R.id.rg9);
        r0 = (RadioGroup) findViewById(R.id.rg10);

        //CHECKBOXES
        c21 = (CheckBox) findViewById(R.id.cb21);
        c22 = (CheckBox) findViewById(R.id.cb22);
        c23 = (CheckBox) findViewById(R.id.cb23);
        c24 = (CheckBox) findViewById(R.id.cb24);
        c61 = (CheckBox) findViewById(R.id.cb61);
        c62 = (CheckBox) findViewById(R.id.cb62);
        c63 = (CheckBox) findViewById(R.id.cb63);
        c64 = (CheckBox) findViewById(R.id.cb64);

        //EDIT TEXT
        e3 = (EditText) findViewById(R.id.et3);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void finish_quiz(View view){
        double res = get_results();
        Context context = getApplicationContext();
        CharSequence text = "Answers saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent i= new Intent(this, Respuestas.class);
        i.putExtra("result", res);
        startActivity(i);
    }

    private double get_results(){
        double res = 0;

        //Q1
        if (r1.getCheckedRadioButtonId() == R.id.rb11) res += 1;

        //Q2
        if (c21.isChecked()) res += 1;
        if (c22.isChecked()) res -= 0.5;
        if (c23.isChecked()) res += 1;
        if (c24.isChecked()) res += 1;

        //Q3
        if (e3.getText().toString().equals("China") || e3.getText().toString().equals("china")) res += 2;

        //Q4
        if (r4.getCheckedRadioButtonId() == R.id.rb42) res += 1;

        //Q5
        if (r5.getCheckedRadioButtonId() == R.id.rb53) res += 1;

        //Q6
        if (c61.isChecked()) res += 1;
        if (c62.isChecked()) res -= 0.5;
        if (c63.isChecked()) res += 1;
        if (c64.isChecked()) res += 1;

        //Q7
        if (r7.getCheckedRadioButtonId() == R.id.rb71) res += 1;

        //Q8
        if (r8.getCheckedRadioButtonId() == R.id.rb83) res += 1;

        //Q9
        if (r9.getCheckedRadioButtonId() == R.id.rb93) res += 1;

        //Q10
        if (r0.getCheckedRadioButtonId() == R.id.rb103) res += 1;

        if (res < 0) return 0;

        res /= 1.5;
        return res;
    }
}


