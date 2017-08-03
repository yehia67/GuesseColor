package com.example.yehia.guessthecolor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    double score = 0;
    TextView counter, answr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = (TextView)  findViewById(R.id.tv_sc);
        answr = (TextView)  findViewById(R.id.tv_ans);
    }
   public void clikcount(){
       counter.setText(Double.toString(++score));
   }
   public void rand(){
       String[] colors = {"BLUE","RED","YELLWO","GREEN","BLACK"};
       Random color = new Random();
       int n = color.nextInt(5);
       answr.setText(colors[n]);;
       int clr = Color.argb(255, color.nextInt(256), color.nextInt(256), color.nextInt(256));
       answr.setTextColor(clr);
       
   }
public void click(View view)
{
    clikcount();
    rand();
}

}
