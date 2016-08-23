package com.example.adnan.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button next;
    TextView questions;
    int score;
    RadioGroup radioGroup;
    String[] array, arrayOptions;
    int qusetionNo, optionNo;
    RadioButton r, r2, r3, r4;
    ArrayList<String> arrayAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radioButton:
                        arrayAnswers.add(r.getText().toString());


                        break;
                    case R.id.radioButton2:
                        arrayAnswers.add(r2.getText().toString());


                        break;
                    case R.id.radioButton3:
                        arrayAnswers.add(r3.getText().toString());


                        break;
                    case R.id.radioButton4:
                        arrayAnswers.add(r4.getText().toString());


                        break;

                }


                if (qusetionNo == 9) {
                    String[] array = getResources().getStringArray(R.array.answers);


                    for (int i = 0; i <= 9; i++) {
                        if (array[i].equals(arrayAnswers.get(i))) {
                            score++;

                        }
                    }
                    Toast.makeText(Main2Activity.this, "Your Score Is :" + score, Toast.LENGTH_LONG).show();

                    finish();
                } else {
                    qusetionNo++;
                    optionNo++;
                    questions.setText(array[qusetionNo]);
                    r.setText(arrayOptions[optionNo]);
                    optionNo++;
                    r2.setText(arrayOptions[optionNo]);
                    optionNo++;
                    r3.setText(arrayOptions[optionNo]);
                    optionNo++;
                    r4.setText(arrayOptions[optionNo]);
                    if (qusetionNo == 9) {
                        next.setText("Submit");

                    }
                }
            }
        });
    }

    public void init() {
        next = (Button) findViewById(R.id.next);
        questions = (TextView) findViewById(R.id.questionsText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        r = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);
        arrayAnswers = new ArrayList<>();

        array = getResources().getStringArray(R.array.questions);
        arrayOptions = getResources().getStringArray(R.array.options);

        questions.setText(array[qusetionNo]);
        r.setText(arrayOptions[optionNo]);
        optionNo++;
        r2.setText(arrayOptions[optionNo]);
        optionNo++;
        r3.setText(arrayOptions[optionNo]);
        optionNo++;
        r4.setText(arrayOptions[optionNo]);

    }
}
