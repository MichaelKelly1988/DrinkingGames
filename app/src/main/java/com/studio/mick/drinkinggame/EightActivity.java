package com.studio.mick.drinkinggame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class EightActivity extends AppCompatActivity implements SensorEventListener {

    public static final int FADE_DURATION = 1500;
    public static final int START_OFFSET = 1000;
    public static final int VIBRATE_TIME = 250;
    public static final int THRESHOLD = 240;
    public static final int SHAKE_COUNT = 2;
    private static Random RANDOM = new Random();
    private Vibrator vibrator;
    private SensorManager sensorManager;
    private Sensor sensor;
    private float lastX, lastY, lastZ;
    private int shakeCount = 0;
    private TextView msgTV;
    private ImageView ball;
    private Animation ballAnimation;
    private ArrayList<String> anwsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        ball = (ImageView) findViewById(R.id.ball);
        msgTV = (TextView) findViewById(R.id.msgtv);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ballAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        anwsers = loadAnwsers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_drink, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shake:
                showAnwser(getAnwser(), true);
                return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        showAnwser(getString(R.string.shake_me), false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if (isShakeEnough(event.values[0], event.values[1], event.values[2])) {
                showAnwser(getAnwser(), false);
            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }

    private boolean isShakeEnough(float x, float y, float z) {
        double force = 0d;

        force += Math.pow((x - lastX) / SensorManager.GRAVITY_EARTH, 2.0);
        force += Math.pow((y - lastY) / SensorManager.GRAVITY_EARTH, 2.0);
        force += Math.pow((z - lastZ) / SensorManager.GRAVITY_EARTH, 2.0);

        force = Math.sqrt(force);

        lastX = x;
        lastY = y;
        lastZ = z;

        if (force > ((float) THRESHOLD / 100f)) {
            ball.startAnimation(ballAnimation);
            shakeCount++;

            if (shakeCount > SHAKE_COUNT) {
                shakeCount = 0;
                lastX = 0;
                lastY = 0;
                lastZ = 0;
                return true;
            }
        }


        return false;
    }

    private void showAnwser(String anwser, boolean withAnim){
        if(withAnim){
            ball.startAnimation(ballAnimation);
        }

        msgTV.setVisibility(View.INVISIBLE);
        msgTV.setText(anwser);
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setStartOffset(START_OFFSET);
        msgTV.setVisibility(View.VISIBLE);
        animation.setDuration(FADE_DURATION);

        msgTV.startAnimation(animation);
        vibrator.vibrate(VIBRATE_TIME);
    }

    private String getAnwser(){
        int randomInt = RANDOM.nextInt(anwsers.size());
        if (randomInt == 0) {
            choice1();
        }else if(randomInt == 1){
        choice2();
        }else if(randomInt == 2){
        choice3();
        }else if(randomInt == 3){
        choice6();
        }else if(randomInt == 4){
        choice4();
        }else if(randomInt == 5){
        choice5();
        }else if(randomInt == 6){
        choice9();
        }else if(randomInt == 7){
        choice8();
        }else if(randomInt == 8){
        choice7();
        }else if(randomInt == 9){
        choice10();
        }else if(randomInt == 10){
        choice11();
        }else if(randomInt == 11){
        choice12();
        }

        return anwsers.get(randomInt);




    }

    public ArrayList<String> loadAnwsers(){
        ArrayList<String> list = new ArrayList<>();
        String[] tab = getResources().getStringArray(R.array.anwsers);

        if (tab != null && tab.length > 0){
            for(String str: tab){
                list.add(str);
            }
        }
        return list;
    }

    public void choice1(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("THE PHOTOGRAPHER");
                            dialogo1.setMessage("The photographer has a camera. He/She must count down from 3 loudly, whilst pointing the camera in one direction, After 3. Anybody not in the picture must drink a drink");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("The Macaulay Culkin");
                            dialogo1.setMessage("The rule maker at any point may place his hands on his cheeks, a la Home Alone. The last person to copy drinks a shot.");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("The President");
                            dialogo1.setMessage("When you speak, you have to put your 2 fingers to your ear as if you are part of the President's security detail, communicating with other personnel. Failing results in Drinking");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("Viking rule");
                            dialogo1.setMessage("anytime I mimic Viking horns with my hands, everyone needs to mimic rowing motions. Last person to row drinks.");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("Kesha Rule");
                            dialogo1.setMessage("The last word of any sentence has to be repeated twice twice. You get the idea idea. It gets pretty ridiculous after a while while.");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("No teeth");
                            dialogo1.setMessage("When you talk, laugh or drink, no one is allowed to see your teeth or you have to down your drink.");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("Swear to Me");
                            dialogo1.setMessage("You must talk like Nolan's Batman");
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

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("One Mouth Move up and Down");
                            dialogo1.setMessage("You can only speak using one-syllable words. Everyone starts talking like a caveman even if they don't have to. \"Me want chips. You give chips.\"");
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
    public void choice9(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("The Narcissus rule");
                            dialogo1.setMessage("Everyone, including myself, compliment me every time they have to drink. No repeating compliments allows for some very strange but hilarious compliments.");
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
    public void choice10(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("Floor is Lava");
                            dialogo1.setMessage("No one can touch the floor without drinking.");
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
    public void choice11(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("The Kanye Rule");
                            dialogo1.setMessage("All nouns in a sentences must be changed to Kanye or another name in reference to him such as Yezzus, Yezzy, etc. ");
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
    public void choice12(){
        Thread th=new Thread(){

            @Override
            public void run(){
                try
                {

                    Thread.sleep(2000);
                    EightActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(new ContextThemeWrapper(EightActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert));
                            dialogo1.setTitle("The Classic");
                            dialogo1.setMessage("Whenever you Drink everyone else has to");
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
