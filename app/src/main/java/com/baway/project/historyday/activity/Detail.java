package com.baway.project.historyday.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.library.glide.GlideUtils;
import com.baway.library.okhttp.HttpCallBack;
import com.baway.library.okhttp.NetHttpUtils;
import com.baway.project.historyday.R;
import com.baway.project.historyday.bean.DetailBean;
import com.baway.project.historyday.dbutils.Dao;

import java.io.IOException;
import java.util.List;

public class Detail extends Activity {

    private String qid;

    private TextView textname;

    private ImageView mainimage;

    private ImageView iamge;

    private CollapsingToolbarLayout tv_title;
    private FloatingActionButton floatingActionButton;

    Dao dao=new Dao(Detail.this);
    private List<DetailBean.ResultBean> list;
    private String date;
    private String dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        initgetId();

        initdata();

        init();


    }
    private void initgetId() {

        Intent intent = getIntent();

        qid = intent.getStringExtra("qid");
        date = intent.getStringExtra("datee");



    }
    private void initdata() {


            String url="http://v.juhe.cn/todayOnhistory/queryDetail.php?key=69a7eeba7869f8bdcdee7b2bc3bb5aa2&e_id="+qid;
            NetHttpUtils.getInstance().get(this, url, null, new HttpCallBack<DetailBean>() {

                @Override
                public void success(DetailBean detail) {

                    list = detail.getResult();

                    String content = list.get(0).getContent();

                    String title = list.get(0).getTitle();

                    String url1 = list.get(0).getPicUrl().get(0).getUrl();

                    tv_title.setTitle(title);

                    tv_title.setExpandedTitleColor(Color.WHITE);

                    tv_title.setCollapsedTitleTextColor(Color.WHITE);

                    textname.setText(content);


                    GlideUtils.loadImage(Detail.this,url1,mainimage);

                }

                @Override

                public void error(IOException e) {

                }

            });

        }




    private void init() {

        textname = (TextView) findViewById(R.id.textname);

        mainimage = (ImageView) findViewById(R.id.mainimage);

        iamge = (ImageView) findViewById(R.id.iamge);

        tv_title = (CollapsingToolbarLayout) findViewById(R.id.collapsing);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dao.findByE_id(list.get(0).getE_id())==null){


                    dao.add(date,list.get(0).getTitle(),list.get(0).getPicUrl().get(0).getUrl(),list.get(0).getE_id());

                    Toast.makeText(Detail.this, "添加成功", Toast.LENGTH_SHORT).show();

                }else {
                    dao.delete(list.get(0).getE_id());
                    Toast.makeText(Detail.this, "删除成功", Toast.LENGTH_SHORT).show();
                }


            }
        });



        iamge.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }
}
