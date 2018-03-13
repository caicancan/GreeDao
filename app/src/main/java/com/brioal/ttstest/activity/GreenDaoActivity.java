package com.brioal.ttstest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.brioal.ttstest.MyApplication;
import com.brioal.ttstest.R;
import com.brioal.ttstest.adapter.GreenDaoAdapter;
import com.brioal.ttstest.bean.Goods;
import com.brioal.ttstest.dao.GoodsDao;
import com.brioal.ttstest.owninterface.Sale;

import java.util.ArrayList;
import java.util.List;

public class GreenDaoActivity extends Activity implements Sale,View.OnClickListener{

    private ListView lv;
    private Goods apple;
    private Goods pear;
    private Goods orange;
    private ArrayList<Goods> goods;
    private GoodsDao dao;
    private Button add;
    private Button delete;
    private Button query;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        dao = MyApplication.getInstances().getDaoSession().getGoodsDao();
        goods = new ArrayList<>();

        lv = findViewById(R.id.lv);
        initView();
        apple = new Goods( "apple", 2000, true);
        pear = new Goods("pear", 10, false);
        orange = new Goods("orange", 15, true);
        goods.add(apple);
        goods.add(pear);
        goods.add(orange);
        dao.insert(apple);
        List<Goods> list = dao.loadAll();
        lv.setAdapter(new GreenDaoAdapter(goods,this));
        for (int i = 0; i <list.size() ; i++) {
            Log.i("ccc",""+list.get(i).toString());
        }


    }

    private void initView() {
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(this);
        query = findViewById(R.id.query);
        query.setOnClickListener(this);
        update = findViewById(R.id.update);
        update.setOnClickListener(this);
    }

    @Override
    public void Success() {

    }

    @Override
    public void faild(String text) {

    }
private int i=0;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:
                i+=1;
            dao.insert(new Goods("banana"+i,5,true));
                break;
            case R.id.delete:
               // dao.deleteByKey((long)13);
                dao.deleteAll();
                break;
            case R.id.update:
                dao.update(new Goods((long)50,"pen",100000,false));
                break;
            case R.id.query:
                List<Goods> loadAll = dao.loadAll();
                for (int i = 0; i <loadAll.size() ; i++) {
                    Log.i("ccc",""+loadAll.get(i).toString());
                }
                break;
        }

    }
}
