package com.itachi21.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageButton correct,incorrect;
    TextView time,score,question,answer,test;

    int seconds = 30;
    private int totalscore = 0;
    boolean result = true;
    private boolean stopTimer = false;
    private int correctAns = 0;
    private int wrongAns = 0;
    private int selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        correct = (ImageButton) findViewById(R.id.correct);
        incorrect = (ImageButton) findViewById(R.id.incorrect);

        time = (TextView) findViewById(R.id.time);
        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);
        test = (TextView) findViewById(R.id.test);
        selection = getIntent().getIntExtra("selection",1);

        test.setText("Selection : " + selection);

        switch (selection)
        {
            case 1:
                generateQuestion(1);
                break;
            case 2:
                generateQuestion(2);
                break;
            case 3:
                generateQuestion(3);
                break;
            case 4:
                generateQuestion(4);
                break;
            case 5:
                generateQuestion(5);
                break;
        }

        timer();

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(true, selection);
            }
        });

        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(false, selection);
            }
        });
    }

    private void generateQuestion(int operator)
    {
        result = true;
        Random random = new Random();
        int a, b, sum, quo, product, diff, mix, actualResult = 0;
        a = random.nextInt(100);
        b = random.nextInt(100);

        sum = a + b;
        diff = a - b;
        product = a * b;
        quo = a / b;

        mix = random.nextInt(4);

        switch (operator)
        {
            case 1:
                question.setText(a + " + " + b);
                actualResult = sum;
                break;
            case 2:
                question.setText(a + " - " + b);
                actualResult = diff;
                break;
            case 3:
                question.setText(a + " x " + b);
                actualResult = product;
                break;
            case 4:
                question.setText(b*quo + " / " + b);
                actualResult = quo;
                break;
            case 5:
                switch(mix)
                {
                    case 0:
                        question.setText(a + " + " + b);
                        actualResult = sum;
                        break;
                    case 1:
                        question.setText(a + " - " + b);
                        actualResult = diff;
                        break;
                    case 2:
                        question.setText(a + " x " + b);
                        actualResult = product;
                        break;
                    case 3:
                        question.setText(b*quo + " / " + b);
                        actualResult = quo;
                        break;
                }
                break;
        }

        Float f = random.nextFloat();
        if( f > 0.5f )
        {
            actualResult = random.nextInt(200);
            result = false;
        }

        answer.setText("= " + actualResult);

    }

    private void verifyAnswer(boolean clickedAnswer, int operator)
    {
        if(clickedAnswer == result)
        {
            correctAns++;
            totalscore += 5;
            score.setText("Score : " + totalscore);
        }
        else
        {
            wrongAns++;
            Vibrator v;
            v = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
            v.vibrate(100);
        }
        generateQuestion(operator);
    }

    private void timer()
    {
        final Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                time.setText("Time : " + seconds);
                seconds--;
                if(seconds < 0)
                {
                    Intent i = new Intent(GameActivity.this, ScoreCard.class);
                    i.putExtra("score", totalscore);
                    i.putExtra("correctAns", correctAns);
                    i.putExtra("wrongAns", wrongAns);
                    startActivity(i);
                    stopTimer = true;
                }
                if(stopTimer == false)
                    h.postDelayed(this,1000);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimer = false;
        finish();
    }


}
