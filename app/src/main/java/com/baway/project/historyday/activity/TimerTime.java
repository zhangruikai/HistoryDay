package com.baway.project.historyday.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.baway.project.historyday.MainActivity;
import com.baway.project.historyday.R;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTime extends Activity {
    Timer timer=new Timer();

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            int obj = (int) msg.obj;

           if(obj<=0){

               Intent intent=new Intent(TimerTime.this, MainActivity.class);

               intent.putExtra("id",1);

               startActivity(intent);

                finish();
               timer.cancel();
           }


        }
    };


    int i=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_time);

        init();
    }


    private void init(){


        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                i--;
                Message msg=Message.obtain();

                msg.obj=i;

                handler.sendMessage(msg);

            }
        };

        timer.schedule(timerTask,5000,1000);


    }


}
