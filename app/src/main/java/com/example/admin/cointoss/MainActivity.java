package com.example.admin.cointoss;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {
    public static final int HEADS = 0;
    public static final int TAILS = 1;
    TextView mainTextView;
    int allThemMoneys = 0;
    ImageView mImageView;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Current Cash: " + allThemMoneys);

        mImageView = (ImageView) findViewById(R.id.coin_image);

        mImageView.setImageResource(R.drawable.tails);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void onClick (View view) {
        int clicked = 0;
        if(view.getId() == R.id.button1) clicked = HEADS;
        else clicked = TAILS;

        int coinFlip;
        coinFlip = rand.nextInt(2);
        if (coinFlip == HEADS) {
            mImageView.setImageResource(R.drawable.heads);
        } else {
            mImageView.setImageResource(R.drawable.tails);
        }

        flipWin(clicked, coinFlip);
    }

    public void flipWin (int clicked, int flip) {
        if (clicked == flip) {
            Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
            allThemMoneys = allThemMoneys +10;
        } else {
            Toast.makeText(this, "You lost!", Toast.LENGTH_SHORT).show();
            allThemMoneys = allThemMoneys -10;
        }mainTextView.setText("Current Cash: " + allThemMoneys);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
