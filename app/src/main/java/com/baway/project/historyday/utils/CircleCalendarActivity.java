package com.baway.project.historyday.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.project.historyday.MainActivity;
import com.baway.project.historyday.MyAppclition;
import com.baway.project.historyday.R;
import com.baway.project.historyday.fragment.TodayFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CircleCalendarActivity extends Activity {
    String date = null;// 设置默认选中的日期  格式为 “2014-04-05” 标准DATE格式

    Button bt;
    private KCalendar calendar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow_calendar);
        riLi();
    }

    private void  riLi(){
        Calendar c=Calendar.getInstance();

        int  year = c.get(Calendar.YEAR);
        int   month = c.get(Calendar.MONTH)+1;
        int   day = c.get(Calendar.DAY_OF_MONTH);
        final TextView popupwindow_calendar_month = (TextView)
                findViewById(R.id.popupwindow_calendar_month);
                calendar = (KCalendar)
                findViewById(R.id.popupwindow_calendar);
        Button popupwindow_calendar_bt_enter = (Button)
                findViewById(R.id.popupwindow_calendar_bt_enter);

        popupwindow_calendar_month.setText(year+ "年"
                + month + "月"+ day+"日");

        if (null != date) {

            int years = Integer.parseInt(date.substring(0,
                    date.indexOf("-")));
            int month1 = Integer.parseInt(date.substring(
                    date.indexOf("-") + 1, date.lastIndexOf("-")));
            popupwindow_calendar_month.setText(years + "年" + month1 + "月"+day+"日");

            calendar.showCalendar(years, month1,day);
            calendar.setCalendarDayBgColor(date,
                    R.drawable.calendar_date_focused);
        }

        List<String> list = new ArrayList<String>(); //设置标记列表
        list.add("2014-04-01");
        list.add("2014-04-02");
        calendar.addMarks(list, 0);

        //监听所选中的日期
        calendar.setOnCalendarClickListener(new KCalendar.OnCalendarClickListener() {

            public void onCalendarClick(int row, int col, String dateFormat) {

                Log.d("天数",row+"-----------");
                Log.d("天数",col+"-----------");
                Log.d("天数",dateFormat+"-----------");

                int month = Integer.parseInt(dateFormat.substring(
                        dateFormat.indexOf("-") + 1,
                        dateFormat.lastIndexOf("-")));

                if (calendar.getCalendarMonth() - month == 1//跨年跳转
                        || calendar.getCalendarMonth() - month == -11) {
                    calendar.lastMonth();

                } else if (month - calendar.getCalendarMonth() == 1 //跨年跳转
                        || month - calendar.getCalendarMonth() == -11) {
                    calendar.nextMonth();

                } else {
                    calendar.removeAllBgColor();
                    calendar.setCalendarDayBgColor(dateFormat,
                            R.drawable.calendar_date_focused);
                    date = dateFormat;//最后返回给全局 date

                    popupwindow_calendar_month.setText(date);
                }
            }


        });

        //监听当前月份
        calendar.setOnCalendarDateChangedListener(new KCalendar.OnCalendarDateChangedListener() {
            public void onCalendarDateChanged(int year, int month,int day) {
                popupwindow_calendar_month
                        .setText(year + "年" + month + "月"+ day +"日");
            }
        });

        //上月监听按钮
        RelativeLayout popupwindow_calendar_last_month = (RelativeLayout)
                findViewById(R.id.popupwindow_calendar_last_month);
        popupwindow_calendar_last_month
                .setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        calendar.lastMonth();
                    }

                });

        //下月监听按钮
        RelativeLayout popupwindow_calendar_next_month = (RelativeLayout)
                findViewById(R.id.popupwindow_calendar_next_month);
        popupwindow_calendar_next_month
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        calendar.nextMonth();
                    }
                });

        //关闭窗口
        popupwindow_calendar_bt_enter
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {


                        Toast.makeText(CircleCalendarActivity.this, date+"天", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(CircleCalendarActivity.this, MainActivity.class);
                        intent.putExtra("date",date);
                        intent.putExtra("index",5);
                        intent.putExtra("idt",2);
                        startActivity(intent);
                        finish();

                    }
                });
    }

}
