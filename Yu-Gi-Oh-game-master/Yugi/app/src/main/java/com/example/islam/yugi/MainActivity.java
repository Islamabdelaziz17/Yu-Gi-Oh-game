package com.example.islam.yugi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.width;
import static com.example.islam.yugi.R.attr.height;
import static com.example.islam.yugi.R.attr.switchMinWidth;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> deckcards;
    ImageView Maindeck1,Maindeck2,drawncard1,drawncard2,drawncard3,drawncard4,drawncard5,drawncard1_2,drawncard2_2,drawncard3_2,drawncard4_2,drawncard5_2;
    boolean draw1,draw2= true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Maindeck1 = (ImageView) findViewById(R.id.maindeck1);
        Maindeck2 = (ImageView) findViewById(R.id.maindeck2);

        drawncard1 = (ImageView) findViewById(R.id.card1_1);
        drawncard2 = (ImageView) findViewById(R.id.card2_1);
        drawncard3 = (ImageView) findViewById(R.id.card3_1);
        drawncard4 = (ImageView) findViewById(R.id.card4_1);
        drawncard5 = (ImageView) findViewById(R.id.card5_1);
        drawncard1_2 = (ImageView) findViewById(R.id.card1_2);
        drawncard2_2 = (ImageView) findViewById(R.id.card2_2);
        drawncard3_2 = (ImageView) findViewById(R.id.card3_2);
        drawncard4_2 = (ImageView) findViewById(R.id.card4_2);
        drawncard5_2 = (ImageView) findViewById(R.id.card5_2);


        drawncard1.setTranslationY(-1000f);
        drawncard2.setTranslationY(-1000f);
        drawncard3.setTranslationY(-1000f);
        drawncard4.setTranslationY(-1000f);
        drawncard5.setTranslationY(-1000f);

        drawncard1_2.setTranslationY(1000f);
        drawncard2_2.setTranslationY(1000f);
        drawncard3_2.setTranslationY(1000f);
        drawncard4_2.setTranslationY(1000f);
        drawncard5_2.setTranslationY(1000f);

        deckcards = new ArrayList<Integer>();
        for(int i = 1;i<33;i++)
        {
            deckcards.add(i);
        }

    }

    public void assigncards(int card,ImageView image)
    {
        switch(card)
        {
            case 1:
                image.setImageResource(R.drawable.one);
                break;
            case 2:
                image.setImageResource(R.drawable.two);
                break;
            case 3:
                image.setImageResource(R.drawable.three);
                break;
            case 4:
                image.setImageResource(R.drawable.four);
                break;
            case 5:
                image.setImageResource(R.drawable.five);
                break;
            case 6:
                image.setImageResource(R.drawable.six);
                break;
            case 7:
                image.setImageResource(R.drawable.seven);
                break;
            case 8:
                image.setImageResource(R.drawable.eight);
                break;
            case 9:
                image.setImageResource(R.drawable.nine);
                break;
            case 10:
                image.setImageResource(R.drawable.ten);
                break;
            case 11:
                image.setImageResource(R.drawable.eleven);
                break;
            case 12:
                image.setImageResource(R.drawable.thirteen);
                break;
            case 13:
                image.setImageResource(R.drawable.four14);
                break;
            case 14:
                image.setImageResource(R.drawable.fif15);
                break;
            case 15:
                image.setImageResource(R.drawable.six16);
                break;
            case 16:
                image.setImageResource(R.drawable.seven17);
                break;
            case 17:
                image.setImageResource(R.drawable.eight18);
                break;
            case 18:
                image.setImageResource(R.drawable.nine19);
                break;
            case 19:
                image.setImageResource(R.drawable.tweny);
                break;
            case 20:
                image.setImageResource(R.drawable.tweny1);
                break;
            case 21:
                image.setImageResource(R.drawable.tweny2);
                break;
            case 22:
                image.setImageResource(R.drawable.tweny3);
                break;
            case 23:
                image.setImageResource(R.drawable.tweny5);
                break;
            case 24:
                image.setImageResource(R.drawable.tweny6);
                break;
            case 25:
                image.setImageResource(R.drawable.tweny7);
                break;
            case 26:
                image.setImageResource(R.drawable.tweny8);
                break;
            case 27:
                image.setImageResource(R.drawable.tweny9);
                break;
            case 28:
                image.setImageResource(R.drawable.thirty);
                break;
            case 29:
                image.setImageResource(R.drawable.thirty1);
                break;
            case 30:
                image.setImageResource(R.drawable.thirty2);
                break;
            case 31:
                image.setImageResource(R.drawable.thirty3);
            break;
            case 32:
                image.setImageResource(R.drawable.thirty4);
                break;
            case 33:
                image.setImageResource(R.drawable.thirty5);
                break;


        }
    }

    public void Draw1(View view)
    {
        while(draw1)
        {
            Collections.shuffle(deckcards);
            assigncards(deckcards.get(0), drawncard1);
            assigncards(deckcards.get(1), drawncard2);
            assigncards(deckcards.get(2), drawncard3);
            assigncards(deckcards.get(3), drawncard4);
            assigncards(deckcards.get(4), drawncard5);

            drawncard1.animate().translationYBy(1000).setDuration(300);
            drawncard2.animate().translationYBy(1000).setDuration(500);
            drawncard3.animate().translationYBy(1000).setDuration(650);
            drawncard4.animate().translationYBy(1000).setDuration(800);
            drawncard5.animate().translationYBy(1000).setDuration(950);
            draw1 = false;

        }

        drawncard1.setTranslationY(-1000f);
        drawncard2.setTranslationY(-1000f);
        drawncard3.setTranslationY(-1000f);
        drawncard4.setTranslationY(-1000f);
        drawncard5.setTranslationY(-1000f);

        Collections.shuffle(deckcards);

        assigncards(deckcards.get(0), drawncard1);
        assigncards(deckcards.get(1), drawncard2);
        assigncards(deckcards.get(2), drawncard3);
        assigncards(deckcards.get(3), drawncard4);
        assigncards(deckcards.get(4), drawncard5);


        drawncard1.animate().translationYBy(1000).setDuration(300);
        drawncard2.animate().translationYBy(1000).setDuration(500);
        drawncard3.animate().translationYBy(1000).setDuration(650);
        drawncard4.animate().translationYBy(1000).setDuration(800);
        drawncard5.animate().translationYBy(1000).setDuration(950);


    }
    public void Draw2(View view)
    {
        while(draw2)
        {
            Collections.shuffle(deckcards);
            assigncards(deckcards.get(0), drawncard1_2);
            assigncards(deckcards.get(1), drawncard2_2);
            assigncards(deckcards.get(2), drawncard3_2);
            assigncards(deckcards.get(3), drawncard4_2);
            assigncards(deckcards.get(4), drawncard5_2);

            drawncard1_2.animate()
                    .translationYBy(-1000)
                    .rotation(180)
                    .setDuration(300);
            drawncard2_2.animate()
                    .translationYBy(-1000)
                    .rotation(180)
                    .setDuration(500);
            drawncard3_2.animate()
                    .translationYBy(-1000)
                    .rotation(180)
                    .setDuration(650);
            drawncard4_2.animate()
                    .translationYBy(-1000)
                    .rotation(180)
                    .setDuration(800);
            drawncard5_2.animate()
                    .translationYBy(-1000)
                    .rotation(180)
                    .setDuration(950);
            draw2 = false;

        }

        drawncard1_2.setTranslationY(1000f);
        drawncard2_2.setTranslationY(1000f);
        drawncard3_2.setTranslationY(1000f);
        drawncard4_2.setTranslationY(1000f);
        drawncard5_2.setTranslationY(1000f);

        Collections.shuffle(deckcards);

        assigncards(deckcards.get(0), drawncard1_2);
        assigncards(deckcards.get(1), drawncard2_2);
        assigncards(deckcards.get(2), drawncard3_2);
        assigncards(deckcards.get(3), drawncard4_2);
        assigncards(deckcards.get(4), drawncard5_2);


        drawncard1_2.animate()
                .translationYBy(-1000)
                .rotation(180)
                .setDuration(300);

        drawncard2_2.animate()
                .translationYBy(-1000)
                .rotation(180)
                .setDuration(500);
        drawncard3_2.animate()
                .translationYBy(-1000)
                .rotation(180)
                .setDuration(650);
        drawncard4_2.animate()
                .translationYBy(-1000)
                .rotation(180)
                .setDuration(800);
        drawncard5_2.animate()
                .translationYBy(-1000)
                .rotation(180)
                .setDuration(950);


    }

}
