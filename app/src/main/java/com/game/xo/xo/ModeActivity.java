package com.game.xo.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeActivity extends AppCompatActivity {

    Button onePlayer, twoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        onePlayer = findViewById(R.id.onePlayerButton);
        twoPlayer = findViewById(R.id.twoPlayerButton);

        onePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModeActivity.this, Tutorial.class);
                startActivity(i);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

            }
        });

        twoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModeActivity.this, TwoPlayingActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
            }
        });
    }
}
