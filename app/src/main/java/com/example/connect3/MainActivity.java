package com.example.connect3;
//Uses tags and gametheory of tictactoe, setImageResource...
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int x =0;// 0:circle,1:cross.....x is the active player
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winnigposition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean active = true;
    public void DropIn(View view) {
        ImageView img = (ImageView) view;
        int tappedCell;
        tappedCell = Integer.parseInt(img.getTag().toString());
        if(gamestate[tappedCell]==2 && active) {
            gamestate[tappedCell] = x;
            Log.i("Info", tappedCell + " cell tapped");
            if (x == 0) {
                img.setImageResource(R.drawable.cross);
                x = 1;
            } else {
                img.setImageResource(R.drawable.circle);
                x = 0;
            }
            for (int[] check : winnigposition) {
                if (gamestate[check[0]] == gamestate[check[1]] && gamestate[check[1]] == gamestate[check[2]] && gamestate[check[0]] != 2) {
                    active =false;
                    String winner = "";
                    if(x==1) {
                        winner = "Cross";
                    }
                    else {
                        winner = "Circle";
                    }
                    Toast.makeText(this, winner+" Won", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
