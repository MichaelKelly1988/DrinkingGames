package com.studio.mick.drinkinggame;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.studio.mick.drinkinggame.R.drawable.beerhead2;

public class DrinkActivity extends AppCompatActivity {

    ImageView i_bot;
    ImageView drink;


    Random r;
    float angle = 0;

    boolean restart = false;


     ImageView b_go;
    private InterstitialAd mInterstitialAd;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-8221778775483224~3751629054");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8221778775483224/9612553720");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        alertDialog = new AlertDialog.Builder(DrinkActivity.this).create();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        i_bot = (ImageView) findViewById(R.id.i_bot);
        drink = (ImageView) findViewById(R.id.drink);
        r = new Random();

        // Create the next level button, which tries to show an interstitial when clicked.
        b_go = ((ImageView) findViewById(R.id.b_go));
        b_go.setEnabled(false);


        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restart) {
                    angle = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(angle, 360,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    //  String.valueOf(angle);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    i_bot.startAnimation(rotate);


                    restart = false;
                    showInterstitial();

                } else {


                    angle = r.nextInt(3600) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    i_bot.startAnimation(rotate);
                    engine();

                    restart = true;


                }


            }


        });


        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();


    }



    

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                b_go.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                b_go.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
         //   Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            goToNextLevel();
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.
        b_go.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.

        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }

    public void engine() {


        if (angle >= 1 && angle <= 45 || angle >= 361 && angle <= 405 || angle >= 721 && angle <= 765 || angle >= 1081 && angle <= 1125 ||
                angle >= 1441 && angle <= 1485 || angle >= 1801 && angle <= 1845 || angle >= 2161 && angle <= 2205 || angle >= 2521 && angle <= 2565 ||
                angle >= 2881 && angle <= 2925 || angle >= 3241 && angle <= 3285 || angle >= 3601 && angle <= 3625 || angle >= 3961 && angle <= 3985) {
            choice();

        } else if (angle > 45 && angle <= 90 || angle > 405 && angle <= 450 || angle > 765 && angle <= 810 || angle > 1125 && angle <= 1170 ||
                angle > 1485 && angle <= 1530 || angle > 1845 && angle <= 1890 || angle > 2205 && angle <= 2250 || angle > 2565 && angle <= 2610 ||
                angle > 2925 && angle <= 2970 || angle > 3285 && angle <= 3330 || angle > 3625 && angle <= 3670 || angle > 3985 && angle <= 4030) {
            choice2();

        } else if (angle > 90 && angle <= 135 || angle > 450 && angle <= 495 || angle > 810 && angle <= 855 || angle > 1170 && angle <= 1215 ||
                angle > 1530 && angle <= 1575 || angle > 1890 && angle <= 1935 || angle > 2250 && angle <= 2295 || angle > 2610 && angle <= 2655 ||
                angle > 2970 && angle <= 3015 || angle > 3330 && angle <= 3375 || angle > 3670 && angle <= 3715 || angle > 4030 && angle <= 4075) {
            choice3();

        } else if (angle > 135 && angle <= 180 || angle > 495 && angle <= 540 || angle > 855 && angle <= 900 || angle > 1215 && angle <= 1260 ||
                angle > 1575 && angle <= 1620 || angle > 1935 && angle <= 1980 || angle > 2295 && angle <= 2340 || angle > 2655 && angle <= 2700 ||
                angle > 3015 && angle <= 3060 || angle > 3375 && angle <= 3420 || angle > 3715 && angle <= 3760 || angle > 4075 && angle <= 4120) {
            choice4();

        }else if (angle > 180 && angle <= 225 || angle > 540 && angle <= 585 || angle > 900 && angle <= 945 || angle > 1260 && angle <= 1305 ||
                angle > 1620 && angle <= 1665 || angle > 1980 && angle <= 2225 || angle > 2340 && angle <= 2385 || angle > 2700 && angle <= 2745 ||
                angle > 3060 && angle <= 3105 || angle > 3420 && angle <= 3465 || angle > 3760 && angle <= 3805 || angle > 4120 && angle <= 4165) {
            choice5();

        }else if (angle > 225 && angle <= 270 || angle > 585 && angle <= 630 || angle > 945 && angle <= 990 || angle > 1305 && angle <= 1350 ||
                angle > 1665 && angle <= 1710 || angle > 2225 && angle <= 2270 || angle > 2385 && angle <= 2430 || angle > 2745 && angle <= 2790 ||
                angle > 3105 && angle <= 3150 || angle > 3465 && angle <= 3510 || angle > 3805 && angle <= 3850 || angle > 4165 && angle <= 4210) {
            choice6();
        }else if (angle > 270 && angle <= 315 || angle > 630 && angle <= 675 || angle > 990 && angle <= 1035 || angle > 1350 && angle <= 1395 ||
                angle > 1710 && angle <= 1755 || angle > 2270 && angle <= 2315 || angle > 2430 && angle <= 2475 || angle > 2790 && angle <= 2835 ||
                angle > 3150 && angle <= 3195 || angle > 3510 && angle <= 3555 || angle > 3850 && angle <= 3895 || angle > 4210 && angle <= 4255) {
            choice7();
        }else if (angle > 315 && angle <= 360 || angle > 675 && angle <= 720 || angle > 1035 && angle <= 1080 || angle > 1395 && angle <= 1440 ||
                angle > 1755 && angle <= 1800 || angle > 2315 && angle <= 2360 || angle > 2475 && angle <= 2520 || angle > 2835 && angle <= 2880 ||
                angle > 3195 && angle <= 3240 || angle > 3555 && angle <= 3600 || angle > 3895 && angle <= 3940 || angle > 4255 && angle <= 4300) {
            choice8();
        }
    }

    public void choice(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom2));
                            dialogo1.setTitle("Pick a Mate");
                            dialogo1.setMessage("Pick a Friend to Drink with You");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();

                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }

    public void choice2(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom3));
                            dialogo1.setTitle("I Never");
                            dialogo1.setMessage("How to play is:  Person who spinned must say for e.g." +
                                    " I Never went to the shop.... but if you have, then who has must drink!!");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();

                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }

    public void choice3(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub

                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom));
                            dialogo1.setTitle("Truth or Dare");
                            dialogo1.setMessage("The Person who spinned must chose between Truth or Dare and if they don't comply must DRINK!!");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();


                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }

    public void choice4(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom4));
                            dialogo1.setTitle("Bust a Rhyme");
                            dialogo1.setMessage("The person who just spinned must start a one sentence rhyme...that must be carried on by everyone, till a " +
                                    "person dosent rhyme then that person must drink");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();

                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }


    public void choice5(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom2));
                            dialogo1.setTitle("Down your Drink");
                            dialogo1.setMessage("Must drink all the drink you have in glass/bottle!!");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();

                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }

    public void choice6(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom3));
                            dialogo1.setTitle("Drink & Spin Again");
                            dialogo1.setMessage("Take a drink and spin again!!");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();

                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }

    public void choice7(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom));
                            dialogo1.setTitle("All Drink");
                            dialogo1.setMessage("EVERYBODY DRINK!!");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();

                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }

    public void choice8(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(4000);
                    DrinkActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(DrinkActivity.this, R.style.AlertDialogCustom4));
                            dialogo1.setTitle("Shot");
                            dialogo1.setMessage("Take a Shot!!");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new  DialogInterface.OnClickListener() {


                                public void onClick(DialogInterface dialogo1, int id) {


                                }
                            });
                            dialogo1.show();


                        }
                    });

                }catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        };
        th.start();
    }


}





