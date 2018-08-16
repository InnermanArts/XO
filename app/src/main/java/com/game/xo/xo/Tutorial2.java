package com.game.xo.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Tutorial2 extends AppCompatActivity {

    RelativeLayout background;
    Button tutorialButton, skipButton, backButton;
    TextView instructions, prompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);

        background = findViewById(R.id.tutorialBackground);
        tutorialButton = findViewById(R.id.tutorialButton);
        skipButton = findViewById(R.id.skipTutorialButton);
        instructions = findViewById(R.id.instructions);
        prompt = findViewById(R.id.prompt);
        backButton = findViewById(R.id.backButton);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        prompt.startAnimation(anim);

        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);

        tutorialButton.startAnimation(bounce);

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tutorial2.this, Tutorial3.class);
                startActivity(i);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tutorial2.this, Tutorial.class);
                startActivity(i);
                overridePendingTransition(R.anim.exit_to_right, R.anim.enter_from_left);
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tutorial2.this, PlayingActivity.class);
                startActivity(i);
            }
        });
    }
}
