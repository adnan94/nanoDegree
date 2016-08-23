package com.example.adnan.reportcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adnan on 8/19/2016.
 */
public class adaptor extends BaseAdapter {
    Context con;
    ArrayList<students> list;
    LayoutInflater inflater;
    TextView name, rank, grade, attendence;
    ImageView iv;

    public adaptor(Context con, ArrayList<students> list) {
        this.con = con;
        this.list = list;
        inflater=inflater.from(con);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.ui,parent,false);

        name = (TextView) v.findViewById(R.id.name);
        rank = (TextView) v.findViewById(R.id.rank);
        attendence = (TextView) v.findViewById(R.id.attendence);
        grade = (TextView) v.findViewById(R.id.grade);
        iv = (ImageView) v.findViewById(R.id.imageView);

        name.setText(list.get(position).getName());
        rank.setText("Rank :" + list.get(position).getRank());
        attendence.setText(list.get(position).getAttendence());
        grade.setText("Grade :" + list.get(position).getGrade());
        iv.setImageResource(list.get(position).getPic());
        return v;
    }
}
