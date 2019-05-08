package com.example.avengersgame;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    private endgameview gameview;
    private Handler handler=new Handler();
    private final static long Interval=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      gameview=new endgameview(this);
      setContentView(gameview);


      Timer timer=new Timer();
      timer.schedule(new TimerTask() {
          @Override
          public void run() {
              handler.post(new Runnable() {
                  @Override
                  public void run() {
                 gameview.invalidate();
                  }
              });
          }
      },0,Interval);



    }

}
