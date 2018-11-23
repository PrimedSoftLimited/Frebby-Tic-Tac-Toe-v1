package com.example.frebby.tictactoe;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button r1B1, r1B2, r1B3, r2B1, r2B2, r2B3, r3B1, r3B2, r3B3;
    boolean PLAYER_X;
    int TURN_COUNT = 0;
    int[][] boardStatus = new int[3][3];
    Button reset;
    TextView xText, oText;
    Intent intent;
    Boolean button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFindAndClickListen();
        PLAYER_X = button = getIntent().getExtras().getBoolean("xButton");
        playIntervals();
    }

    public void resetBoard() {
        r1B1.setText("");
        r1B2.setText("");
        r1B3.setText("");
        r2B1.setText("");
        r2B2.setText("");
        r2B3.setText("");
        r3B1.setText("");
        r3B2.setText("");
        r3B3.setText("");
        TURN_COUNT = 0;
        intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void viewFindAndClickListen() {
        r1B1 = findViewById(R.id.r1B1);
        r1B1.setOnClickListener(this);
        r1B2 = findViewById(R.id.r1B2);
        r1B2.setOnClickListener(this);
        r1B3 = findViewById(R.id.r1B3);
        r1B3.setOnClickListener(this);
        r2B1 = findViewById(R.id.r2B1);
        r2B1.setOnClickListener(this);
        r2B2 = findViewById(R.id.r2B2);
        r2B2.setOnClickListener(this);
        r2B3 = findViewById(R.id.r2B3);
        r2B3.setOnClickListener(this);
        r3B1 = findViewById(R.id.r3B1);
        r3B1.setOnClickListener(this);
        r3B2 = findViewById(R.id.r3B2);
        r3B2.setOnClickListener(this);
        r3B3 = findViewById(R.id.r3B3);
        r3B3.setOnClickListener(this);
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }

    public void playIntervals() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }

    @Override
    public void onClick(View view) {

        xText = findViewById(R.id.x_text);
        oText = findViewById(R.id.o_text);
        switch (view.getId()) {
            case R.id.r1B1:
                if (PLAYER_X) {
                    r1B1.setText(xText.getText());
                    boardStatus[0][0] = 1;
                } else {
                    r1B1.setText(oText.getText());
                    boardStatus[0][0] = 0;
                }
                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r1B2:
                if (PLAYER_X) {
                    r1B2.setText(xText.getText());
                    boardStatus[0][1] = 1;
                } else {
                    r1B2.setText(oText.getText());
                    boardStatus[0][1] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r1B3:
                if (PLAYER_X) {
                    r1B3.setText(xText.getText());
                    boardStatus[0][2] = 1;
                } else {
                    r1B3.setText(oText.getText());
                    boardStatus[0][2] = 0;
                }
                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r2B1:
                if (PLAYER_X) {
                    r2B1.setText(xText.getText());
                    boardStatus[1][0] = 1;
                } else {
                    r2B1.setText(oText.getText());
                    boardStatus[1][0] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r2B2:
                if (PLAYER_X) {
                    r2B2.setText(xText.getText());
                    boardStatus[1][1] = 1;
                } else {
                    r2B2.setText(oText.getText());
                    boardStatus[1][1] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r2B3:
                if (PLAYER_X) {
                    r2B3.setText(xText.getText());
                    boardStatus[1][2] = 1;
                } else {
                    r2B3.setText(oText.getText());
                    boardStatus[1][2] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r3B1:
                if (PLAYER_X) {
                    r3B1.setText(xText.getText());
                    boardStatus[2][0] = 1;
                } else {
                    r3B1.setText(oText.getText());
                    boardStatus[2][0] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r3B2:
                if (PLAYER_X) {
                    r3B2.setText(xText.getText());
                    boardStatus[2][1] = 1;
                } else {
                    r3B2.setText(oText.getText());
                    boardStatus[2][1] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            case R.id.r3B3:
                if (PLAYER_X) {
                    r3B3.setText(xText.getText());
                    boardStatus[2][2] = 1;
                } else {
                    r3B3.setText(oText.getText());
                    boardStatus[2][2] = 0;
                }

                PLAYER_X = !PLAYER_X;
                TURN_COUNT++;
                break;
            default:
                break;
        }
        if (reset.isPressed()) {
            resetBoard();
        } else {
            checkAlignment();
        }

    }

    public void checkAlignment() {

        for (int x = 0; x < 3; ++x) {
            if (boardStatus[x][0] == boardStatus[x][1] && boardStatus[x][0] == boardStatus[x][2]) {
                if (boardStatus[x][0] == 1) {
                    Toast.makeText(this, "Player X Wins Horizontally", Toast.LENGTH_SHORT).show();
                    break;
                } else if (boardStatus[x][0] == 0) {
                    Toast.makeText(this, "Player O Wins Horizontally", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        for (int x = 0; x < 3; ++x) {
            if (boardStatus[0][x] == boardStatus[1][x] && boardStatus[0][x] == boardStatus[2][x]) {
                if (boardStatus[0][x] == 1) {
                    Toast.makeText(this, "Player X Wins Vertically", Toast.LENGTH_SHORT).show();
                    break;
                } else if (boardStatus[0][x] == 0) {
                    Toast.makeText(this, "Player O Wins Vertically", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        //first diagonal. Top left to bottom right

        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                Toast.makeText(this, "Player X Wins Diagonally", Toast.LENGTH_SHORT).show();
            }
            else if (boardStatus[0][0]==0) {
                Toast.makeText(this, "Player O Wins Diagonally", Toast.LENGTH_SHORT).show();
            }
        }

        //Second diagonal. Bottom left to top right
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                Toast.makeText(this, "Player X Wins Diagonally", Toast.LENGTH_SHORT).show();
            }
            else if (boardStatus[0][2]==0) {
                Toast.makeText(this, "Player O Wins Diagonally", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void setInfo(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
