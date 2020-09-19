package com.example.islam.yugi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.scaleX;
import static android.R.attr.width;
import static com.example.islam.yugi.R.attr.height;
import static com.example.islam.yugi.R.attr.switchMinWidth;
import static com.example.islam.yugi.R.id.image;
import static com.example.islam.yugi.R.id.maindeck1;
import static com.example.islam.yugi.R.id.monstercard1_2;
import static com.example.islam.yugi.R.id.monstercard5_1;
import static com.example.islam.yugi.R.id.monstercard5_2;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoutofcards1;
    ArrayList<Integer> deckcards;
    ArrayList<Integer> deckcards2;
    ImageView Maindeck1,Maindeck2,drawncard1,drawncard2,drawncard3,drawncard4,drawncard5,drawncard1_2,drawncard2_2,drawncard3_2,drawncard4_2,drawncard5_2;
    ImageView monster1,monster2,monster3,monster4,monster5,monster1_2,monster2_2,monster3_2,monster4_2,monster5_2;
    boolean draw1,draw2= true;


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //noinspection deprecation
                view.startDrag(data,shadowBuilder,view,0);
                return true;
            } else {
                return false;
            }
        }
    }

    private final class MyTouchListener2 implements View.OnTouchListener {
        public boolean onTouch(final View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    double rotationRad = Math.toRadians(view.getRotation());
                    final int w = (int) (view.getWidth() * view.getScaleX());
                    final int h = (int) (view.getHeight() * view.getScaleY());
                    double s = Math.abs(Math.sin(rotationRad));
                    double c = Math.abs(Math.cos(rotationRad));
                    final int width = (int) (w * c + h * s);
                    final int height = (int) (w * s + h * c);
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view) {
                        @Override
                        public void onDrawShadow(Canvas canvas) {
                            canvas.scale(view.getScaleX(), view.getScaleY(), width / 2,
                                    height / 2);
                            canvas.rotate(view.getRotation(), width / 2, height / 2);
                            canvas.translate((width - view.getWidth()) / 2,
                                    (height - view.getHeight()) / 2);
                            super.onDrawShadow(canvas);
                        }

                        @Override
                        public void onProvideShadowMetrics(Point shadowSize,
                                                           Point shadowTouchPoint) {
                            shadowSize.set(width, height);
                            shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
                        }
                    };

                    view.startDrag(null, shadowBuilder, view, 0);
            }
            return false;
        }
    }

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    //v.setRotation(180);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                    ImageView view1 = (ImageView)event.getLocalState();

                        if (view1 == drawncard1) {
                            if(v == monster1)
                            {
                                assigncards(deckcards.get(0), ((ImageView) v));
                                v.invalidate();
                            }
                        } else if (view1==drawncard2) {
                            if(v == monster2)
                            {
                                assigncards(deckcards.get(1), ((ImageView) v));
                                v.invalidate();
                            }
                        } else if (view1==drawncard3) {
                            if(v == monster3)
                            {
                                assigncards(deckcards.get(2), ((ImageView) v));
                                v.invalidate();
                            }
                        } else if (view1==drawncard4) {
                            if(v == monster4)
                            {
                            assigncards(deckcards.get(3), ((ImageView) v));
                            v.invalidate();
                            }
                        } else if (view1==drawncard5) {
                            if(v == monster5)
                            {
                                assigncards(deckcards.get(4), ((ImageView) v));
                                v.invalidate();
                            }
                        }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }

    class MyDragListener2 implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                    ImageView view2 = (ImageView)event.getLocalState();

                    if (view2 == drawncard1_2) {
                        if(v == monster1_2)
                        {
                            monster1_2.setRotation(180);
                            assigncards(deckcards2.get(0), ((ImageView) v));
                            v.invalidate();
                        }
                    } else if (view2==drawncard2_2) {
                        if(v == monster2_2)
                        {
                            monster2_2.setRotation(180);
                            assigncards(deckcards2.get(1), ((ImageView) v));
                            v.invalidate();
                        }
                    } else if (view2==drawncard3_2) {
                        if(v == monster3_2)
                        {
                            monster3_2.setRotation(180);
                            assigncards(deckcards2.get(2), ((ImageView) v));
                            v.invalidate();
                        }
                    } else if (view2==drawncard4_2) {
                        if(v == monster4_2)
                        {
                            monster4_2.setRotation(180);
                            assigncards(deckcards2.get(3), ((ImageView) v));
                            v.invalidate();
                        }
                    } else if (view2==drawncard5_2) {
                        if(v == monster5_2)
                        {
                            monster5_2.setRotation(180);
                            assigncards(deckcards2.get(4), ((ImageView) v));
                            v.invalidate();
                        }
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }

    // Main
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

        layoutofcards1 = (LinearLayout)findViewById(R.id.layoutofcards1);

        monster1 = (ImageView) findViewById(monstercard5_1);
        monster2 = (ImageView) findViewById(R.id.monstercard4_1);
        monster3 = (ImageView) findViewById(R.id.monstercard3_1);
        monster4 = (ImageView) findViewById(R.id.monstercard2_1);
        monster5 = (ImageView) findViewById(R.id.monstercard1_1);

        monster1_2 = (ImageView) findViewById(monstercard1_2);
        monster2_2 = (ImageView) findViewById(R.id.monstercard2_2);
        monster3_2 = (ImageView) findViewById(R.id.monstercard3_2);
        monster4_2 = (ImageView) findViewById(R.id.monstercard4_2);
        monster5_2 = (ImageView) findViewById(R.id.monstercard5_2);


        drawncard1.setOnTouchListener(new MyTouchListener());
        drawncard2.setOnTouchListener(new MyTouchListener());
        drawncard3.setOnTouchListener(new MyTouchListener());
        drawncard4.setOnTouchListener(new MyTouchListener());
        drawncard5.setOnTouchListener(new MyTouchListener());
        monster1.setOnDragListener(new MyDragListener());
        monster2.setOnDragListener(new MyDragListener());
        monster3.setOnDragListener(new MyDragListener());
        monster4.setOnDragListener(new MyDragListener());
        monster5.setOnDragListener(new MyDragListener());



        drawncard1_2.setOnTouchListener(new MyTouchListener2());
        drawncard2_2.setOnTouchListener(new MyTouchListener2());
        drawncard3_2.setOnTouchListener(new MyTouchListener2());
        drawncard4_2.setOnTouchListener(new MyTouchListener2());
        drawncard5_2.setOnTouchListener(new MyTouchListener2());
        monster1_2.setOnDragListener(new MyDragListener2());
        monster2_2.setOnDragListener(new MyDragListener2());
        monster3_2.setOnDragListener(new MyDragListener2());
        monster4_2.setOnDragListener(new MyDragListener2());
        monster5_2.setOnDragListener(new MyDragListener2());

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
        deckcards2 = new ArrayList<Integer>();

        for(int i = 1;i<33;i++)
        {
            deckcards.add(i);
        }


        for(int i = 1;i<33;i++)
        {
            deckcards2.add(i);
        }



        //spell & trap cards animations;


        /*drawncard1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                 v = monster1;
                // first quarter turn
                final View finalV = v;

                  v.animate().withLayer()
                        .rotationY(90)
                        .setDuration(350)
                        .withEndAction(
                                new Runnable()
                                {
                                    @Override public void run()
                                    {

                                        finalV.setCameraDistance(10* finalV.getWidth());
                                        assigncards(deckcards.get(0),monster1);
                                        // second quarter turn
                                        finalV.setRotationY(-90);
                                        finalV.animate().withLayer()
                                                .rotationY(0)
                                                .setDuration(350)
                                                .start();
                                    }}
                        ).start();
            }
        });

        drawncard2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                v = monster2;
                // first quarter turn
                final View finalV = v;

                v.animate().withLayer()
                        .rotationY(90)
                        .setDuration(350)
                        .withEndAction(
                                new Runnable()
                                {
                                    @Override public void run()
                                    {

                                        finalV.setCameraDistance(10* finalV.getWidth());
                                        assigncards(deckcards.get(1),monster2);
                                        // second quarter turn
                                        finalV.setRotationY(-90);
                                        finalV.animate().withLayer()
                                                .rotationY(0)
                                                .setDuration(350)
                                                .start();
                                    }}
                        ).start();
            }
        });

        drawncard3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                v = monster3;
                // first quarter turn
                final View finalV = v;

                v.animate().withLayer()
                        .rotationY(90)
                        .setDuration(350)
                        .withEndAction(
                                new Runnable()
                                {
                                    @Override public void run()
                                    {

                                        finalV.setCameraDistance(10* finalV.getWidth());
                                        assigncards(deckcards.get(2),monster3);
                                        // second quarter turn
                                        finalV.setRotationY(-90);
                                        finalV.animate().withLayer()
                                                .rotationY(0)
                                                .setDuration(350)
                                                .start();
                                    }}
                        ).start();
            }
        });

        drawncard4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                v = monster4;
                // first quarter turn
                final View finalV = v;

                v.animate().withLayer()
                        .rotationY(90)
                        .setDuration(350)
                        .withEndAction(
                                new Runnable()
                                {
                                    @Override public void run()
                                    {

                                        finalV.setCameraDistance(10* finalV.getWidth());
                                        assigncards(deckcards.get(3),monster4);
                                        // second quarter turn
                                        finalV.setRotationY(-90);
                                        finalV.animate().withLayer()
                                                .rotationY(0)
                                                .setDuration(350)
                                                .start();
                                    }}
                        ).start();
            }
        });

        drawncard5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                v = monster5;
                // first quarter turn
                final View finalV = v;

                v.animate().withLayer()
                        .rotationY(90)
                        .setDuration(350)
                        .withEndAction(
                                new Runnable()
                                {
                                    @Override public void run()
                                    {

                                        finalV.setCameraDistance(10* finalV.getWidth());
                                        assigncards(deckcards.get(4),monster5);
                                        // second quarter turn
                                        finalV.setRotationY(-90);
                                        finalV.animate().withLayer()
                                                .rotationY(0)
                                                .setDuration(350)
                                                .start();
                                    }}
                        ).start();
            }
        });*/



    }
    // assign image function to each card
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


    //Draw phase for player 1

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

    //draw phase for player 2
    public void Draw2(View view)
    {
        while(draw2)
        {
            Collections.shuffle(deckcards2);
            assigncards(deckcards2.get(0), drawncard1_2);
            assigncards(deckcards2.get(1), drawncard2_2);
            assigncards(deckcards2.get(2), drawncard3_2);
            assigncards(deckcards2.get(3), drawncard4_2);
            assigncards(deckcards2.get(4), drawncard5_2);

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

        Collections.shuffle(deckcards2);

        assigncards(deckcards2.get(0), drawncard1_2);
        assigncards(deckcards2.get(1), drawncard2_2);
        assigncards(deckcards2.get(2), drawncard3_2);
        assigncards(deckcards2.get(3), drawncard4_2);
        assigncards(deckcards2.get(4), drawncard5_2);


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
