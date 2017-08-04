package com.example.yehia.guessthecolor;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    double score = 0;
    TextView counter, answr;
    int Answer;
  static  int righCount = 1, wrgCount = 1;
    Button rigtbt,wrongbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = (TextView)  findViewById(R.id.tv_sc);
        answr = (TextView)  findViewById(R.id.tv_ans);
        rigtbt = (Button) findViewById(R.id.bt_right);
        wrongbt = (Button) findViewById(R.id.bt_fal);
    }
   public void clikcount(){
       counter.setText(Double.toString(++score));
   }
   public void rand(){
       String[] colors = {"BLUE","RED","YELLWO","GREEN","BLACK"};
       Random color = new Random();
       int n = color.nextInt(5);
       int[] arrCol = {Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN,Color.BLACK};
       int ind = color.nextInt(5);
       answr.setTextColor(arrCol[ind]);
       answr.setText(colors[n]);

       if(ind == n)
       {
           Answer = 1;
       }else
       {
           Answer = 0;
       }

   }
   public void rightBt(){


       if (Answer == 1)
       {
           righCount++;
           Toast.makeText(this,"right answer keep going",Toast.LENGTH_SHORT).show();
       }
       else
       {
           righCount--;
           Toast.makeText(this,"wrong answer try again",Toast.LENGTH_SHORT).show();
       }
   GameOver();
   }

    public void wrgBt(){

        clikcount();
        rand();
        if (Answer == 0)
        {
            wrgCount++;
            Toast.makeText(this,"right answer keep going",Toast.LENGTH_SHORT).show();
        }
        else
        {
            wrgCount--;
            Toast.makeText(this,"wrong answer try again",Toast.LENGTH_SHORT).show();
        }
        GameOver();
    }
public void click(View view)
{
    clikcount();
    rand();
    switch (view.getId())
    {
        case R.id.bt_right:
            rightBt();
            break;
        case R.id.bt_fal:
            wrgBt();
            break;
    }
}
public void GameOver(){

    if (righCount >= 10 || wrgCount >= 10)
    {
        Toast.makeText(this,"GAME OVER YOUR SCORE IS EQUALE  " + righCount/wrgCount *100 + "%" ,Toast.LENGTH_LONG).show();
   // System.exit(0);
    }
}
}
