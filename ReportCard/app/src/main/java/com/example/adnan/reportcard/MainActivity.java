package com.example.adnan.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<students> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<students>();
        list.add(new students("Adnan Ahmed", "5th", "present", "A+", R.drawable.aa));
        list.add(new students("Fawad khan", "0th", "Absent", "Fail", R.drawable.bb));
        list.add(new students("Kashan Zafar", "2nd", "present", "A+", R.drawable.aa));
        list.add(new students("Faiz Rehman", "10th", "present", "B+", R.drawable.bb));
        list.add(new students("Zeeshan Ali", "15th", "present", "C", R.drawable.aa));
        list.add(new students("Muhammad Adnan", "7th", "present", "B+", R.drawable.bb));
        list.add(new students("Arslan Ghani", "8th", "present", "B+", R.drawable.aa));
        list.add(new students("Owais Khan", "9th", "present", "B+", R.drawable.bb));
        adaptor adaptor = new adaptor(this, list);
        listView.setAdapter(adaptor);
    }
}
