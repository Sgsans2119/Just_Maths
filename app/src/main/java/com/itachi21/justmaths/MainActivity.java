package com.itachi21.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btn1 , btn2 , btn3 , btn4;

        btn1 = (ImageButton) findViewById(R.id.play);
        btn2 = (ImageButton) findViewById(R.id.share);
        btn3 = (ImageButton) findViewById(R.id.toast);
        btn4 = (ImageButton) findViewById(R.id.info);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, ChooseMenu.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Intent.ACTION_SEND);
                i2.setType("text/plain");
                i2.putExtra(Intent.EXTRA_TEXT,"JUST MATHS !!!!");
                startActivity(i2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hello World. This is JUST MATHS!!!",Toast.LENGTH_LONG).show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, InfoScreen.class);
                startActivity(i3);
            }
        });
    }
}
