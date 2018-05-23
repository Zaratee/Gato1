package com.example.zarate.gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Act_pvp extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private ImageView[][] imgv = new ImageView[3][3];
    private boolean player1 =true;
    private int roundCount;
    private  int player1Points;
    private int player2Points;
    private TextView txtVP1;
    private TextView txtVP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_pvp);
        txtVP1 = findViewById(R.id.txtV_p1);
        txtVP2 = findViewById(R.id.txtV_p2);
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                String buttonID = "btn_" +i+j;
                int resId = getResources().getIdentifier(buttonID, "id",getPackageName());
                buttons[i][j] = findViewById(resId);
                buttons[i][j].setOnClickListener(this);

                String ImageID = "imgV_ID" +i+j;
                int resimgID = getResources().getIdentifier(ImageID, "id",getPackageName());
            }
        }
        Button btnreset= findViewById(R.id.btn_reset);
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }
        roundCount++;
        if (check4win()){
        if(player1) {
                player1Wins();
            }else{
                player2Wins();
            }
        }else if(roundCount ==9) {
            draw();
        }else{
            player1 = !player1;
        }
        }
        private boolean check4win()
        {
            String[][] field = new String[3][3];

            for(int i=0; i<3; i++)
            {
               for(int j=0; j<3; j++)
               {
                   field[i][j] = buttons[i][j].getText().toString();
               }
            }

            for(int i=0; i<3; i++)
            {
                if(field[i][0].equals(field[i][1])
                        && field[i][0].equals(field[i][2])
                        && !field[i][0].equals(""))
                {
                    return true;
                }
            }
            for(int i=0; i<3; i++)
            {
                if(field[0][i].equals(field[1][i])
                        && field[0][i].equals(field[2][i])
                        && !field[0][i].equals(""))
                {
                    return true;
                }
            }
            if(field[0][0].equals(field[1][1])
                    && field[0][0].equals(field[2][2])
                    && !field[0][0].equals(""))
            {
                return true;
            }

            if(field[0][2].equals(field[1][1])
                    && field[0][2].equals(field[2][0])
                    && !field[0][2].equals(""))
            {
                return true;
            }

            return false;
        }
        private void player1Wins(){
            player1Points++;
            Toast.makeText(this,"Player 1 Wins!", Toast.LENGTH_SHORT).show();
            updatePointsText();
            resetBoard();
            }
        private void player2Wins(){
            player2Points++;
            Toast.makeText(this,"Player 2 Wins!", Toast.LENGTH_SHORT).show();
            updatePointsText();
            resetBoard();
        }
        private void draw(){
            Toast.makeText(this,"Draw!",Toast.LENGTH_SHORT).show();
            resetBoard();
        }
        private void updatePointsText(){
            txtVP1.setText("Player 1: "+ player1Points);
            txtVP2.setText("Player2: " + player2Points);
        }
        private void resetBoard(){
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++){
                    buttons[i][j].setText("");
                }
            }
            roundCount=0;
            player1=true;
            }
        }

