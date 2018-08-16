package com.game.xo.xo;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
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

public class TwoPlayingActivity extends AppCompatActivity implements LinearTimer.TimerListener {

    public static final String PLAYER_SCORE = "playerScore";
    RelativeLayout playerOne, playerTwo;
    Button playerOneShapeButton, playerOneWin, playerOneLose, playerOneLockinButtton;
    Button playerTwoShapeButton, playerTwoWin, playerTwoLose, playerTwoLockinButton;
    TextView playerOneScore, playerTwoScore;
    LinearTimerView linearTimerView;
    LinearTimer linearTimer;
    int[] binary1 = {0, 1};
    int[] binary2 = {0, 1};
    Random random = new Random();
    int randomShape = random.nextInt(binary1.length);
    int randomBackground = random.nextInt(binary2.length);
    int randomShape2 = random.nextInt(binary1.length);
    int randomBackground2 = random.nextInt(binary2.length);
    int playerOneScoreValue = 0;
    int playerTwoScoreValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_playing);

        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);
        playerOneShapeButton = findViewById(R.id.playerOneShapeButton);
        playerOneWin = findViewById(R.id.playerOneWin);
        playerOneLose = findViewById(R.id.playerOneLose);
        playerOneLockinButtton = findViewById(R.id.playerOneLockin);
        playerTwoShapeButton = findViewById(R.id.playerTwoShapeButton);
        playerTwoWin = findViewById(R.id.playerTwoWin);
        playerTwoLose = findViewById(R.id.playerTwoLose);
        playerTwoLockinButton = findViewById(R.id.playerTwoLockInButton);
        playerOneScore = findViewById(R.id.playerOneScore);
        playerTwoScore = findViewById(R.id.playerTwoScore);
        linearTimerView = findViewById(R.id.timer);

        final LinearTimer linearTimer = new LinearTimer.Builder()
                .timerListener(this)
                .linearTimerView(linearTimerView)
                .duration(30000)
                .build();

        playerOneScore.setText(Integer.toString(playerOneScoreValue));
        playerTwoScore.setText(Integer.toString(playerTwoScoreValue));
        playerOneShapeButton.setVisibility(View.INVISIBLE);
        playerTwoShapeButton.setVisibility(View.INVISIBLE);


        playerOneLockinButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //linearTimer.startTimer();
                playerOneLockinButtton.setText("Waiting for Player 2...");
                playerOneLockinButtton.setVisibility(View.GONE);
                setShapeAndBackground();

                playerOneScore.setText(Integer.toString(playerOneScoreValue));

                playerOneShapeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (randomShape == 0 && randomBackground == 0) {
                            randomizeShapeAndBackground();
                            setShapeAndBackground();
                            addPoint();
                        } else if (randomShape == 1 && randomBackground == 1) {
                            randomizeShapeAndBackground();
                            setShapeAndBackground();
                            addPoint();
                        }else{

                        }

                    }
                });

                playerOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (randomShape == 0 && randomBackground == 1) {
                            randomizeShapeAndBackground();
                            setShapeAndBackground();
                            addPoint();
                        } else if (randomShape == 1 && randomBackground == 0) {
                            randomizeShapeAndBackground();
                            setShapeAndBackground();
                            addPoint();
                        }else{
                            subtractPoint();
                        }
                    }

                });
            }
        });

        playerTwoLockinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //linearTimer.startTimer();
                playerTwoLockinButton.setVisibility(View.GONE);
                setShapeAndBackgroundTwo();

                playerTwoScore.setText(Integer.toString(playerTwoScoreValue));

                playerTwoShapeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (randomShape2 == 0 && randomBackground2 == 0) {
                            randomizeShapeAndBackgroundTwo();
                            setShapeAndBackgroundTwo();
                            addPointTwo();
                        } else if (randomShape2 == 1 && randomBackground2 == 1) {
                            randomizeShapeAndBackgroundTwo();
                            setShapeAndBackgroundTwo();
                            addPointTwo();
                        }else{
                            subtractPointTwo();
                            Animation shake = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);
                            playerTwoShapeButton.startAnimation(shake);
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v.vibrate(500);
                        }

                    }
                });

                playerTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (randomShape2 == 0 && randomBackground2 == 1) {
                            randomizeShapeAndBackgroundTwo();
                            setShapeAndBackgroundTwo();
                            addPointTwo();
                        } else if (randomShape2 == 1 && randomBackground2 == 0) {
                            randomizeShapeAndBackgroundTwo();
                            setShapeAndBackgroundTwo();
                            addPointTwo();
                        }else{
                            subtractPointTwo();
                            Animation shake = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);
                            playerTwoShapeButton.startAnimation(shake);
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v.vibrate(500);
                        }
                    }

                });
            }
        });

    }


    public void setShapeAndBackground(){

        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerOneShapeButton.startAnimation(bounce);

        if(randomShape == 0){
            playerOneShapeButton.setBackgroundResource(R.drawable.o);
        }else if(randomShape == 1){
            playerOneShapeButton.setBackgroundResource(R.drawable.x);
        }

        if (randomBackground == 0){
            playerOne.setBackgroundColor(Color.parseColor("#33cc33"));
        }else if(randomBackground == 1){
            playerOne.setBackgroundColor(Color.parseColor("#ff1a1a"));
        }
    }

    public void randomizeShapeAndBackground(){
        randomShape = random.nextInt(binary1.length);
        randomBackground = random.nextInt(binary2.length);
    }

    public void addPoint(){
        playerOneScoreValue++;
        playerOneScore.setText(Integer.toString(playerOneScoreValue));
        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerOneScore.startAnimation(bounce);
    }

    public void subtractPoint(){
        playerOneScoreValue--;
        playerOneScore.setText(Integer.toString(playerOneScoreValue));
        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerOneScore.startAnimation(bounce);
    }

    public void setShapeAndBackgroundTwo(){

        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerTwoShapeButton.startAnimation(bounce);

        if(randomShape2 == 0){
            playerTwoShapeButton.setBackgroundResource(R.drawable.o);
        }else if(randomShape2 == 1){
            playerTwoShapeButton.setBackgroundResource(R.drawable.x);
        }

        if (randomBackground2 == 0){
            playerTwo.setBackgroundColor(Color.parseColor("#33cc33"));
        }else if(randomBackground2 == 1){
            playerTwo.setBackgroundColor(Color.parseColor("#ff1a1a"));
        }
    }

    public void randomizeShapeAndBackgroundTwo(){
        randomShape2 = random.nextInt(binary1.length);
        randomBackground2 = random.nextInt(binary2.length);
    }

    public void addPointTwo(){
        playerTwoScoreValue++;
        playerTwoScore.setText(Integer.toString(playerTwoScoreValue));
        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerTwoScore.startAnimation(bounce);
    }

    public void subtractPointTwo(){
        playerTwoScoreValue--;
        playerTwoScore.setText(Integer.toString(playerOneScoreValue));
        final Animation bounce = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
        playerTwoScore.startAnimation(bounce);
    }


    @Override
    public void animationComplete() {

    }

    @Override
    public void timerTick(long l) {

    }

    @Override
    public void onTimerReset() {

    }
}

