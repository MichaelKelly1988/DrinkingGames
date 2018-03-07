package com.studio.mick.drinkinggame;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static android.R.attr.max;
import static java.lang.Integer.getInteger;
import static java.lang.Integer.valueOf;
import static java.util.Collections.swap;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView but1, but2, but3, but4, but5, but6,
            but7, but8, but9, but10, but11, but12,
            but13, but14, but15, but16, but17, but18,
            but19, but20, but21, but22, but23, but24
            ,but25, but26,
            but27, but28, but29, but30, but31, but32,
            but33, but34, but35, but36, but37;
    int card;
    int checkedCard;

    int[] cards = {R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_6,
            R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12
            ,R.drawable.img_13, R.drawable.img_14, R.drawable.img_15, R.drawable.img_16, R.drawable.img_17, R.drawable.img_18,
            R.drawable.img_19, R.drawable.img_20, R.drawable.img_21, R.drawable.img_22, R.drawable.img_23, R.drawable.img_24,
            R.drawable.img_25, R.drawable.img_26, R.drawable.img_27, R.drawable.img_28, R.drawable.img_29, R.drawable.img_30
            ,R.drawable.img_31, R.drawable.img_32, R.drawable.img_33, R.drawable.img_34, R.drawable.img_35, R.drawable.img_36,
            R.drawable.img_37, R.drawable.img_38, R.drawable.img_39, R.drawable.img_40, R.drawable.img_41, R.drawable.img_42,
            R.drawable.img_43, R.drawable.img_44, R.drawable.img_45, R.drawable.img_46, R.drawable.img_47, R.drawable.img_48
            ,R.drawable.img_49};

     ArrayList<Integer> usedCards = new ArrayList<Integer>();


    ImageView img;
    int counter;

boolean game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        but1 = (ImageView) findViewById(R.id.imb1);
        but2 = (ImageView) findViewById(R.id.ib2);
        but3 = (ImageView) findViewById(R.id.ib3);
        but4 = (ImageView) findViewById(R.id.ib4);
        but5 = (ImageView) findViewById(R.id.ib5);
        but6 = (ImageView) findViewById(R.id.ib6);
        but7 = (ImageView) findViewById(R.id.ib7);
        but8 = (ImageView) findViewById(R.id.ib8);
        but9 = (ImageView) findViewById(R.id.ib9);
        but10 = (ImageView) findViewById(R.id.ib10);
        but11 = (ImageView) findViewById(R.id.ib11);
        but12 = (ImageView) findViewById(R.id.ib12);
        but13 = (ImageView) findViewById(R.id.ib13);
        but14 = (ImageView) findViewById(R.id.ib14);
        but15 = (ImageView) findViewById(R.id.ib15);
        but16 = (ImageView) findViewById(R.id.ib16);
        but17 = (ImageView) findViewById(R.id.ib17);
        but18 = (ImageView) findViewById(R.id.ib18);
        but19 = (ImageView) findViewById(R.id.ib19);
        but20 = (ImageView) findViewById(R.id.ib20);
        but21 = (ImageView) findViewById(R.id.ib21);
        but22 = (ImageView) findViewById(R.id.ib22);
        but23 = (ImageView) findViewById(R.id.ib23);
        but24 = (ImageView) findViewById(R.id.ib24);
        but25 = (ImageView) findViewById(R.id.ib25);
        but26 = (ImageView) findViewById(R.id.ib26);
        but27 = (ImageView) findViewById(R.id.ib27);
        but28 = (ImageView) findViewById(R.id.ib28);
        but29 = (ImageView) findViewById(R.id.ib29);
        but30 = (ImageView) findViewById(R.id.ib30);
        but31 = (ImageView) findViewById(R.id.ib31);
        but32 = (ImageView) findViewById(R.id.ib32);
        but33 = (ImageView) findViewById(R.id.ib33);
        but34 = (ImageView) findViewById(R.id.ib34);
        but35 = (ImageView) findViewById(R.id.ib35);
        but36 = (ImageView) findViewById(R.id.ib36);
        but37 = (ImageView) findViewById(R.id.ib37);





        counter = 0;
        img = (ImageView) findViewById(R.id.imgRandom);
        game = true;
      //  endGame=false;

        for (int id : CLICKABLES) {
            findViewById(id).setOnClickListener(this);


        }


    }


  
      
      
  


    public void Fighters() {
          //  end();

        do {


            checkedCard = cards[(int) (Math.random()*cards.length)];
                //  checkedCard = rnd.nextInt(cards.length);
            img.setImageResource(checkedCard);
            if (!usedCards.contains(checkedCard))

             break;


        }
        while (true);
        card = checkedCard;
        usedCards.add(card);

    }






    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imb1:
                counter++;

                    Fighters();
                    but1.setVisibility(View.INVISIBLE);

                    end();// end();

                break;
            case R.id.ib2:
                counter++;

                    Fighters();
                    but2.setVisibility(View.INVISIBLE);

                    end();// end();

                break;
            case R.id.ib3:
                counter++;

                    Fighters();
                    but3.setVisibility(View.INVISIBLE);

                    end();// end();

                break;
            case R.id.ib4:
                counter++;

                    Fighters();
                    but4.setVisibility(View.INVISIBLE);

                    end();// end();

                break;
            case R.id.ib5:
                counter++;

                    Fighters();
                    but5.setVisibility(View.INVISIBLE);

                    end();// end();

                break;
            case R.id.ib6:
               // img.setImageResource(i);
                counter++;

                    Fighters();
                    but6.setVisibility(View.INVISIBLE);

                    end();// end();
                break;
            case R.id.ib7:
                counter++;

                Fighters();
                but7.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib8:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but8.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib9:
                counter++;

                Fighters();
                but9.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib10:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but10.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib11:
                counter++;

                Fighters();
                but11.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib12:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but12.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib13:
                counter++;

                Fighters();
                but13.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib14:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but14.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib15:
                counter++;

                Fighters();
                but15.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib16:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but16.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib17:
                counter++;

                Fighters();
                but17.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib18:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but18.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib19:
                counter++;

                Fighters();
                but19.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib20:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but20.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib21:
                counter++;

                Fighters();
                but21.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib22:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but22.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib23:
                counter++;

                Fighters();
                but23.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib24:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but24.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib25:
                counter++;

                Fighters();
                but25.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib26:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but26.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib27:
                counter++;

                Fighters();
                but27.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib28:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but28.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib29:
                counter++;

                Fighters();
                but29.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib30:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but30.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib31:
                counter++;

                Fighters();
                but31.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib32:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but32.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib33:
                counter++;

                Fighters();
                but33.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib34:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but34.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib35:
                counter++;

                Fighters();
                but35.setVisibility(View.INVISIBLE);

                end();// end();

                break;
            case R.id.ib36:
                // img.setImageResource(i);
                counter++;

                Fighters();
                but36.setVisibility(View.INVISIBLE);

                end();// end();
                break;
            case R.id.ib37:
                counter++;

                Fighters();
                but37.setVisibility(View.INVISIBLE);

                end();// end();




        }
    }






public void end() {
    if (counter == CLICKABLES.length) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("The End");
        alertDialog.setMessage("Everybody drink all of what they are holding");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "Reset",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                        startActivity(i);
                    }
                });
        alertDialog.show();
    }
    else if(checkedCard == (R.drawable.img_0)){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("ACE");
        alertDialog.setMessage("Waterfall - Every player begins drinking, and no one can stop until the player before them does");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                      //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }
     else if(checkedCard == (R.drawable.img_1)){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("ACE");
        alertDialog.setMessage("Waterfall - Every player begins drinking, and no one can stop until the player before them does");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();

    } else if(checkedCard == (R.drawable.img_2)) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("ACE");
        alertDialog.setMessage("Waterfall - Every player begins drinking, and no one can stop until the player before them does");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_3)) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("ACE");
        alertDialog.setMessage("Waterfall - Every player begins drinking, and no one can stop until the player before them does");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_4) ||(checkedCard == (R.drawable.img_5) ||(checkedCard == (R.drawable.img_6)|| (checkedCard == (R.drawable.img_7))))){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("TWO");
        alertDialog.setMessage("You - Whoever drew the card assigns a drink");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_8) ||(checkedCard == (R.drawable.img_9) ||(checkedCard == (R.drawable.img_10)|| (checkedCard == (R.drawable.img_11))))){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("THREE");
        alertDialog.setMessage("Me - Whoever drew the card drinks");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_12) ||(checkedCard == (R.drawable.img_13) ||(checkedCard == (R.drawable.img_14)|| (checkedCard == (R.drawable.img_15))))){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("FOUR");
        alertDialog.setMessage("Floor - Everyone races to touch the floor, last person to do so drinks");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_16) ||(checkedCard == (R.drawable.img_17) ||(checkedCard == (R.drawable.img_18)))){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("FIVE");
        alertDialog.setMessage("Guys - All guys drink");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_19) ||(checkedCard == (R.drawable.img_20) ||(checkedCard == (R.drawable.img_21)|| (checkedCard == (R.drawable.img_22))))){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("SIX");
        alertDialog.setMessage("Chicks - All girls drink");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_23) ||(checkedCard == (R.drawable.img_24) ||(checkedCard == (R.drawable.img_25)|| (checkedCard == (R.drawable.img_26))))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("SEVEN");
        alertDialog.setMessage("Heaven - All players point towards the sky, last player to do so drinks");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_27) ||(checkedCard == (R.drawable.img_28) ||(checkedCard == (R.drawable.img_29)|| (checkedCard == (R.drawable.img_30))))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("EIGHT");
        alertDialog.setMessage("Mate - Pick a person to drink with");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_31) ||(checkedCard == (R.drawable.img_32) ||(checkedCard == (R.drawable.img_33)|| (checkedCard == (R.drawable.img_34))))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("NINE");
        alertDialog.setMessage("Rhyme - Say a phrase, and everyone else must say phrases that rhyme");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_35) ||(checkedCard == (R.drawable.img_36) ||(checkedCard == (R.drawable.img_37)|| (checkedCard == (R.drawable.img_38))))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("TEN");
        alertDialog.setMessage("Categories - Pick a category, and say something from that category (i.e. if \"drinking games\" was the category, \"kings\" would be a viable answer.");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_39) ||(checkedCard == (R.drawable.img_40) ||(checkedCard == (R.drawable.img_41)|| (checkedCard == (R.drawable.img_42))))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("JACK");
        alertDialog.setMessage("Never have I ever - Each player puts up 3 fingers, then starting with the person who drew the card, each player says \"never have I ever «something»\". If you've done it, you put a finger down, until someone loses");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_43) ||(checkedCard == (R.drawable.img_44) ||(checkedCard == (R.drawable.img_45)))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("QUEEN");
        alertDialog.setMessage("Questions - The person who drew the card asks a random person a question, and they then turn and ask a random person a question, until someone loses by either failing to ask a question or by responding to the person who just asked them a question");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }else if(checkedCard == (R.drawable.img_46) ||(checkedCard == (R.drawable.img_47) ||(checkedCard == (R.drawable.img_48)|| (checkedCard == (R.drawable.img_49))))) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("KING");
        alertDialog.setMessage("Ruler - Make a rule that everyone must follow until the next King is drawn (i.e. force everyone to drink after each turn)");
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //  alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }



}


    public int[] CLICKABLES = {
            R.id.imb1, R.id.ib2,
            R.id.ib3, R.id.ib4, R.id.ib5,
            R.id.ib6,
            R.id.ib7, R.id.ib8,
            R.id.ib9, R.id.ib10, R.id.ib11,
            R.id.ib12,
            R.id.ib13, R.id.ib14,
            R.id.ib15, R.id.ib16, R.id.ib17,
            R.id.ib18,
            R.id.ib19, R.id.ib20,
            R.id.ib21, R.id.ib22, R.id.ib23,
            R.id.ib24,
            R.id.ib25, R.id.ib26,
            R.id.ib27, R.id.ib28, R.id.ib29,
            R.id.ib30,
            R.id.ib31, R.id.ib32,
            R.id.ib33, R.id.ib34, R.id.ib35,
            R.id.ib36,
            R.id.ib37

    };
}
