package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.tic_tac_toe.R.drawable.tic_o;

public class MainActivity extends AppCompatActivity {
    //0:0  1:X
    int current_player=0;
    int[] gamestate ={2,2,2,2,2,2,2,2,2};
    int[][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};
    public void dropIn(View view){
        ImageView counter=(ImageView) view;
        Log.i("Tag",counter.getTag().toString());
        int tappedcounter=Integer.parseInt(counter.getTag().toString());
        gamestate[tappedcounter]=current_player;
        counter.setTranslationY(-1500);
        if(current_player==0){
        counter.setImageResource(tic_o);
        current_player=1;}
        else
        {
            counter.setImageResource(R.drawable.tic);
            current_player=0;
        }
        counter.animate().translationYBy(1500).setDuration(300);
        for(int[] winningPosition: winningPosition){
            if(gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]] && gamestate[winningPosition[0]] !=2){
                //someone has won
                String winner="";
                if(current_player==1){
                    winner="Player with 0";
                }
                else
                {
                    winner="Player with 1";
                }
                Toast.makeText(this,winner+" Has Won!",Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}