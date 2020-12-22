package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView res = findViewById(R.id.result);
        final EditText quiz = findViewById(R.id.quiz);
        final EditText hw = findViewById(R.id.hw);
        final EditText mid = findViewById(R.id.mid);
        final EditText fin = findViewById(R.id.fin);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String squiz = quiz.getText().toString();
                    String shw = hw.getText().toString();
                    String smid = mid.getText().toString();
                    String sfin = fin.getText().toString();
                    if(squiz.matches("") || shw.matches("") || smid.matches("") || sfin.matches(""))
                        Toast.makeText(MainActivity.this,"Fill all the fields please", Toast.LENGTH_LONG).show();
                    else {
                        if (!validinput(squiz, 15))
                            Toast.makeText(MainActivity.this, "Quiz percentage is invalid", Toast.LENGTH_LONG).show();
                        else if (!validinput(shw, 25))
                            Toast.makeText(MainActivity.this, "Homework percentage is invalid", Toast.LENGTH_LONG).show();
                        else if (!validinput(smid, 30))
                            Toast.makeText(MainActivity.this, "Midterm percentage is invalid", Toast.LENGTH_LONG).show();
                        else if (!validinput(sfin, 30))
                            Toast.makeText(MainActivity.this, "Final percentage is invalid", Toast.LENGTH_LONG).show();
                        else {
                            double dquiz = Double.parseDouble(squiz);
                            double dhw = Double.parseDouble(shw);
                            double dmid = Double.parseDouble(smid);
                            double dfin = Double.parseDouble(sfin);
                            double result = dquiz + dhw + dmid + dfin;
                            if (result >= 90 && result <= 100) {
                                res.setTextColor(Color.parseColor("#59e336"));
                                res.setText("A");
                            } else if (result >= 80) {
                                res.setTextColor(Color.parseColor("#f78425"));
                                res.setText("B");
                            } else if (result >= 70) {
                                res.setTextColor(Color.parseColor("#f78425"));
                                res.setText("C");
                            } else if (result >= 60) {
                                res.setTextColor(Color.parseColor("#d9091d"));
                                res.setText("D");
                            } else {
                                res.setTextColor(Color.parseColor("#d9091d"));
                                res.setText("F");
                            }

                        }
                    }
                }
            });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeEmpty(quiz);
                makeEmpty(hw);
                makeEmpty(mid);
                makeEmpty(fin);
                res.setTextColor(Color.parseColor("#706897"));
                res.setText("Result");
            }
        });


    }

    public static void makeEmpty(EditText text){
        String s = text.getText().toString();
        if(s.matches(""))
            System.out.println("it's empty"); //to avoid crashing only
        else{
            text.setText("");
        }

    }

    public static boolean validinput(String s , double per){
        if(Double.parseDouble(s)<=per && Double.parseDouble(s)>-1)
            return true;
        else return false;
    }
}