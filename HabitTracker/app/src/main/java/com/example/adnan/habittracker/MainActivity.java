package com.example.adnan.habittracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Habits> arrayList = new ArrayList<>();
    private MyAdapter adapter;
    Database db;
    //    private Database db = new Database(this);
    private ListView listView;
    private ArrayAdapter<String> adapterfordays;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<String>();
        adapterfordays = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
        GetTodo();
    }


    private void GetTodo() {
        db = new Database(MainActivity.this);

        listView = (ListView) findViewById(R.id.listvieww);
        arrayList = db.retrive();

        adapter = new MyAdapter(arrayList, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("YOu Want To Delete Or Update.?");
                builder.setTitle("Delete Or Update !!!");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = arrayList.get(position).getId();
                        arrayList.remove(position);
                        db.deleteProduct(id);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LayoutInflater layout = LayoutInflater.from(MainActivity.this);
                        View view = layout.inflate(R.layout.alertview2, null);
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Update Some Habit");
                        alert.setMessage("Would You Like tO Update Some ToDo");

                        final EditText edt = (EditText) view.findViewById(R.id.editText);


                        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

                        spinner.setAdapter(adapterfordays);


                        alert.setPositiveButton("update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String text = spinner.getSelectedItem().toString();
                                int id = arrayList.get(position).getId();
                                Habits habits = new Habits(arrayList.get(position).getTitle(), text);
                                arrayList.set(position, habits);
                                db.update(arrayList.get(position).getTitle(),text, id);
                                adapter.notifyDataSetChanged();

                            }
                        });
                        alert.setView(view);
                        alert.create().show();
                    }
                });
                builder.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_add) {

            LayoutInflater layout = LayoutInflater.from(this);
            View view = layout.inflate(R.layout.alertview, null);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Add Some Habit");
            alert.setMessage("Would You Like tO Add Some Habit...??");

            final EditText edt = (EditText) view.findViewById(R.id.editText);


            final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

            spinner.setAdapter(adapterfordays);


            alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {



                    String text = spinner.getSelectedItem().toString();

                    Habits email = new Habits(edt.getText().toString(), text);
                    arrayList.add(email);

                    db.insertProduct(email);
                    adapter.notifyDataSetChanged();


                }
            });
            alert.setNegativeButton("Back", null);

            alert.setView(view);
            alert.show();
            return super.onOptionsItemSelected(item);
        }
    return true;
    }

}

