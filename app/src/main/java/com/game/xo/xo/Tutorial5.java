package com.game.xo.xo;

import android.content.Intent;
import android.media.midi.MidiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial5 extends AppCompatActivity {

    Button backButton, startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial5);

        backButton = findViewById(R.id.backButton);
        startButton = findViewById(R.id.startGameButton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tutorial5.this, Tutorial4.class);
                startActivity(i);
                overridePendingTransition(R.anim.exit_to_right, R.anim.enter_from_left);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tutorial5.this, PlayingActivity.class);
                startActivity(i);
            }
        });


    }
}
