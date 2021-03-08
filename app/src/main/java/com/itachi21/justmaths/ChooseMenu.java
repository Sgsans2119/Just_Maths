package com.itachi21.justmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);

        Button add, sub, multi, div, mix;

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.subs);
        multi = (Button) findViewById(R.id.multi);
        div = (Button) findViewById(R.id.div);
        mix = (Button) findViewById(R.id.mix);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(1);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(2);
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(3);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(4);
            }
        });

        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(5);
            }
        });
    }

    private void nextActivity( int selection )
    {
        Intent i = new Intent(ChooseMenu.this, GameActivity.class);
        i.putExtra("selection", selection);
        startActivity(i);
    }
}
