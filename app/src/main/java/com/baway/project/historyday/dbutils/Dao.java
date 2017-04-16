package com.baway.project.historyday.dbutils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2017/3/26.
 */
public class Dao {
    DBHelper helper;

    public Dao(Context context) {
        helper = new DBHelper(context);
    }

    public boolean add(String date, String title, String picUrl, String E_id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("date", date);
        cv.put("title", title);
        cv.put("picurl", picUrl);
        cv.put("E_id", E_id);
        long l = db.insert("mycollect", null, cv);
        if (l != -1) {
            return true;
        } else {
            return false;
        }
    }

    public List<DBBean> findAll() {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cur = db.query("mycollect", null, null, null, null, null, null);
        List<DBBean> list = new ArrayList<DBBean>();
        while (cur.moveToNext()) {
            String date = cur.getString(cur.getColumnIndex("date"));
            String title = cur.getString(cur.getColumnIndex("title"));
            String picurl = cur.getString(cur.getColumnIndex("picurl"));
            String E_id = cur.getString(cur.getColumnIndex("E_id"));
            DBBean bean = new DBBean(date, title, picurl, E_id);
            list.add(bean);
        }
        return list;
    }

    public void delete(String E_id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("mycollect", "E_id=?", new String[]{E_id});
    }

    public DBBean findByE_id(String E_id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("mycollect", null, "E_id=?", new String[]{E_id}, null, null, null);
        if(cursor.moveToFirst()){
            String date = cursor.getString(cursor.getColumnIndex("date"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String picurl = cursor.getString(cursor.getColumnIndex("picurl"));

            DBBean bean = new DBBean(date, title, picurl, E_id);
            return bean;
        }
        return null;
    }

}
