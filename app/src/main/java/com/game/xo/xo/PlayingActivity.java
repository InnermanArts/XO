package com.game.xo.xo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class PlayingActivity extends AppCompatActivity implements LinearTimer.TimerListener {

    public static final String PLAYER_SCORE = "playerScore";
    Button shapeButton, startButton;
    RelativeLayout background;
    TextView playerScore;
    int[] binary1 = {0, 1};
    int[] binary2 = {0, 1};
    int playerScoreValue = 0;

    Random random = new Random();
    int randomShape = random.nextInt(binary1.length);
    int randomBackground = random.nextInt(binary2.length);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        shapeButton = findViewById(R.id.shapeButton);
        background = findViewById(R.id.background);
        playerScore = findViewById(R.id.playerScore);
        startButton = findViewById(R.id.startButton);




       LinearTimerView linearTimerView = findViewById(R.id.timer);
       final LinearTimer linearTimer = new LinearTimer.Builder()
                .timerListener(this)
                .linearTimerView(linearTimerView)
                .duration(850)
                .build();

       shapeButton.setVisibility(View.INVISIBLE);

       startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               linearTimer.startTimer();
               startButton.setVisibility(View.GONE);
               setShapeAndBackground();


               playerScore.setText(Integer.toString(playerScoreValue));

               shapeButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       if (randomShape == 0 && randomBackground == 0) {
                           randomizeShapeAndBackground();
                           setShapeAndBackground();
                           addPoint();
                           linearTimer.restartTimer();
                       } else if (randomShape == 1 && randomBackground == 1) {
                           randomizeShapeAndBackground();
                           setShapeAndBackground();
                           addPoint();
                           linearTimer.restartTimer();
                       }else{
                           Intent i = new Intent(PlayingActivity.this, OnePlayerResults.class);
                           Bundle bundle = new Bundle();
                           bundle.putInt(PLAYER_SCORE, playerScoreValue);
                           i.putExtras(bundle);
                           startActivity(i);
                           overridePendingTransition(R.anim.bounce, R.anim.slide_out_down);
                       }

                   }
               });



               background.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       if (randomShape == 0 && randomBackground == 1) {
                           randomizeShapeAndBackground();
                           setShapeAndBackground();
                           addPoint();
                           linearTimer.restartTimer();
                       } else if (randomShape == 1 && randomBackground == 0) {
                           randomizeShapeAndBackground();
                           setShapeAndBackground();
                           addPoint();
                           linearTimer.restartTimer();
                       }else{
                           Intent i = new Intent(PlayingActivity.this, OnePlayerResults.class);
                           Bundle bundle = new Bundle();
                           bundle.putInt(PLAYER_SCORE, playerScoreValue);
                           i.putExtras(bundle);
                           startActivity(i);
                           overridePendingTransition(R.anim.bounce, R.anim.slide_out_down);
                       }

                   }

               });
           }
       });


    }



    public void setShapeAndBackground(){

        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        shapeButton.startAnimation(bounce);

        if(randomShape == 0){
            shapeButton.setBackgroundResource(R.drawable.o);
        }else if(randomShape == 1){
            shapeButton.setBackgroundResource(R.drawable.x);
        }

        if (randomBackground == 0){
            background.setBackgroundColor(Color.parseColor("#33cc33"));
        }else if(randomBackground == 1){
            background.setBackgroundColor(Color.parseColor("#ff1a1a"));
        }
    }

    public void randomizeShapeAndBackground(){
        randomShape = random.nextInt(binary1.length);
        randomBackground = random.nextInt(binary2.length);
    }

    public void addPoint(){
        playerScoreValue++;
        playerScore.setText(Integer.toString(playerScoreValue));
        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerScore.startAnimation(bounce);
    }


    @Override
    public void animationComplete() {
        Intent i = new Intent(PlayingActivity.this, OnePlayerResults.class);
        Bundle bundle = new Bundle();
        bundle.putInt(PLAYER_SCORE, playerScoreValue);
        i.putExtras(bundle);
        startActivity(i);
        overridePendingTransition(R.anim.bounce, R.anim.slide_out_down);
    }

    @Override
    public void timerTick(long l) {

    }

    @Override
    public void onTimerReset() {

    }
}







