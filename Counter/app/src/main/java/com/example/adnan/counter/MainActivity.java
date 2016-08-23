package com.example.adnan.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addThreeA, addThreeB, addFiveA, addFiveB, addOneA, addOneB, resetA, resetB;
    TextView scoreA, scoreB;
    int teamA, teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
		
        clickListeners();

    }


    public void initialize() {
        addThreeA = (Button) findViewById(R.id.addThreeA);
        addThreeB = (Button) findViewById(R.id.addThreeB);
        addFiveA = (Button) findViewById(R.id.addFiveA);
        addFiveB = (Button) findViewById(R.id.addFiveB);
        addOneA = (Button) findViewById(R.id.addOneA);
        addOneB = (Button) findViewById(R.id.add1B);
        resetA = (Button) findViewById(R.id.resetA);
        resetB = (Button) findViewById(R.id.resetB);
        scoreA = (TextView) findViewById(R.id.scoreA);
        scoreB = (TextView) findViewById(R.id.scoreB);

    }

    public void clickListeners() {
        addThreeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA = teamA + 3;
                scoreA.setText("" + teamA);

            }
        });
        addThreeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB = teamB + 3;
                scoreB.setText("" + teamB);

            }
        });
        addFiveA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA = teamA + 5;
                scoreA.setText("" + teamA);

            }
        });
        addFiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB = teamB + 5;
                scoreB.setText("" + teamB);

            }
        });
        addOneA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA = teamA + 1;
                scoreA.setText("" + teamA);

            }
        });
        addOneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB = teamB + 1;
                scoreB.setText("" + teamB);

            }
        });
        resetA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA.setText("0");
                teamA = 0;
            }
        });
        resetB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB.setText("0");
                teamB = 0;
            }
        });

    }
}
