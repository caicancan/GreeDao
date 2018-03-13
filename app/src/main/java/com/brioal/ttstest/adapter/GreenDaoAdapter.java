package com.brioal.ttstest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brioal.ttstest.R;
import com.brioal.ttstest.bean.Goods;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by n009654 on 2018/3/12.
 */

public class GreenDaoAdapter extends BaseAdapter {
    private ArrayList<Goods> infos;
    private Context mContext;
    private TextView name;
    private TextView price;
    private TextView issale;
    private View convertView;
    private ViewHolder holder;

    public GreenDaoAdapter(ArrayList<Goods> infos,Context mContext) {
        this.infos = infos;
        this.mContext=mContext;
    }

    public GreenDaoAdapter() {
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.name= convertView.findViewById(R.id.name);
            holder.price = convertView.findViewById(R.id.price);
            holder.issale = convertView.findViewById(R.id.issale);
            convertView.setTag(holder);
        }
        holder = (ViewHolder)convertView.getTag();
        holder.name.setText(infos.get(position).getName());
        holder.price.setText(""+infos.get(position).getPrice());
        holder.issale.setText(""+infos.get(position).isIssale());
        return convertView;
    }
     class ViewHolder{
        TextView name;
        TextView price;
        TextView issale;

     }
}
