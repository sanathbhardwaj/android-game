package com.example.avengersgame;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;

import static com.example.avengersgame.R.drawable.thanos;

public class endgameview extends View
{
    private Bitmap thanos;
    private int thanosX=10;
    private int thanosY;
    private int thanosSpeed;
    private int canvasWidth,canvasHeight;  private int score;



    private boolean touch=false;


    private Bitmap universe;
    private Paint scorepaint=new Paint();private int yellowX,yellowY,yellowSpeed=26; private Paint yellowPaint=new Paint();
    public endgameview(Context context)
    {
        super(context);
        thanos= BitmapFactory.decodeResource(getResources(), R.drawable.thanos);
        universe=BitmapFactory.decodeResource(getResources(),R.drawable.universe);
        scorepaint.setTextSize(70);
        scorepaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorepaint.setAntiAlias(true);yellowPaint.setColor(Color.GREEN); yellowPaint.setAntiAlias(false);
        thanosY=550;score=0;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvasWidth=canvas.getWidth();
        canvasHeight=canvas.getHeight();




        canvas.drawBitmap(universe,0,0,null);

        int minthanosY=thanos.getHeight();
        int maxthanosY=canvasHeight-thanos.getHeight()*3;
        thanosY=thanosY+thanosSpeed;
        if(thanosY<minthanosY)
        {
            thanosY=minthanosY;
        }
        if(thanosY>maxthanosY)
        {
            thanosY=maxthanosY;
        }
        thanosSpeed=thanosSpeed+2;

        if(touch)
    {
       canvas.drawBitmap(thanos,thanosX,thanosY,null);
       touch=false;

    }
    else
    {
        canvas.drawBitmap(thanos,thanosX,thanosY,null);

    } yellowX=yellowY-yellowSpeed;if(hitballchecker(yellowX,yellowY)){score=score+2;yellowX= -100;} if(yellowX<0){yellowX=canvasWidth+21;yellowY=(int) Math.floor(Math.random()*(maxthanosY-minthanosY))+minthanosY;}
        canvas.drawText("Score:"+score,20,60,scorepaint); canvas.drawCircle(yellowX,yellowY,10,yellowPaint);
    }public  boolean hitballchecker(int x,int y){if(thanosX<x && x<(thanosX+thanos.getWidth())&& thanosY<y && y<(thanosY+thanos.getHeight())){return true;}
      return false;}
    @Override
    public boolean onTouchEvent(MotionEvent event) {

       if(event.getAction()==MotionEvent.ACTION_DOWN)
       {
           touch=true;
           thanosSpeed=-22;

       }
       return true;

    }
}
