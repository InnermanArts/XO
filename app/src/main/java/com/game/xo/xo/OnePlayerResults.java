package com.game.xo.xo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnePlayerResults extends AppCompatActivity {

   Button retryButton, tutorialButton, homeButon;
   TextView playerScore, highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_results);

        retryButton = findViewById(R.id.retryButton);
        tutorialButton = findViewById(R.id.tutorialButton);
        homeButon = findViewById(R.id.homeButton);
        playerScore = findViewById(R.id.playerScore);
        highScore = findViewById(R.id.highScore);

        Bundle bundle = getIntent().getExtras();
        int playerScoreValue = bundle.getInt("playerScore");
        playerScore.setText(playerScoreValue + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScoreValue = settings.getInt("HIGH_SCORE", 0);

        if(playerScoreValue > highScoreValue){
            highScore.setText(playerScoreValue + "");
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", playerScoreValue);
            editor.commit();
        }else{
            highScore.setText(highScoreValue + "");
        }


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OnePlayerResults.this, PlayingActivity.class);
                startActivity(i);
            }
        });

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OnePlayerResults.this, Tutorial.class);
                startActivity(i);
            }
        });

        homeButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OnePlayerResults.this, TitleActivity.class);
                startActivity(i);
            }
        });
    }
}
