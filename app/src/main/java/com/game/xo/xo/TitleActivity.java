package com.game.xo.xo;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TitleActivity extends AppCompatActivity {

    Button startButton, leaderboardButton, achievementButton;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        startButton = findViewById(R.id.startButton);
        achievementButton = findViewById(R.id.achievementButton);
        leaderboardButton = findViewById(R.id.leaderboardButton);
        logo = findViewById(R.id.logo);
        final Animation bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        logo.startAnimation(bounce);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TitleActivity.this, ModeActivity.class);
                startActivity(i);
            }
        });

    }
}
