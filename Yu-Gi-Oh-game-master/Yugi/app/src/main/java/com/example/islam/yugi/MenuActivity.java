package com.example.islam.yugi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity
{
    private ImageView logo;
    private MediaPlayer Theme;


    public void duelmode(View view)
    {
        Intent duel_mode = new Intent(MenuActivity.this,MainActivity.class);
        startActivity(duel_mode);

    }
    public void exitgame(View view)
    {
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        else
            finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        logo = (ImageView)findViewById(R.id.logo);
    }



}
