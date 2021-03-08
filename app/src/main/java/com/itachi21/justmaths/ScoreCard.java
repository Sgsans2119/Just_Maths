package com.itachi21.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        TextView finalScore, correctAns, wrongAns;

        finalScore = (TextView) findViewById(R.id.finalscore);
        int score = getIntent().getIntExtra("score",0);
        finalScore.setText("Final Score : " + score);

        correctAns = (TextView) findViewById(R.id.correctAns);
        int totalcorrect = getIntent().getIntExtra("correctAns", 0);
        correctAns.setText("Correct Answers : " + totalcorrect);

        wrongAns = (TextView) findViewById(R.id.wrongAns);
        int totalwrong = getIntent().getIntExtra("wrongAns", 0);
        wrongAns.setText("Wrong Answers : " + totalwrong);

        ImageButton sharebtn = (ImageButton) findViewById(R.id.sharebtn);
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Hello World");
                startActivity(i);
            }
        });
    }
}
