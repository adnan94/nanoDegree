package com.example.adnan.inventoryapp;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    static sqlHandler sqlHandler;
    static ListView listView;
    static ArrayList<signatureSales> list;
    static adaptorSales adaptorSales;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_details, container, false);
        listView = (ListView) v.findViewById(R.id.listView2);
        sqlHandler = new sqlHandler(getActivity());
        list = new ArrayList<>();
        list = sqlHandler.retriveSales();
        adaptorSales = new adaptorSales(getActivity(), list);
        refresh();

//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                int ids = list.get(position).getId();
//            Log.d("TAG","Hello");


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Sales");
                builder.setTitle("What you want to do ?");


                builder.setNegativeButton("Delete Product", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = list.get(position).getId();
                        sqlHandler.deleteProduct(id, "sales");
                        list.remove(position);
                        refresh();

                    }
                });


                builder.create().show();
            }
        });

        return v;
    }

    public static void refresh() {
        list = sqlHandler.retriveSales();
        listView.setAdapter(adaptorSales);
        adaptorSales.notifyDataSetChanged();
    }


}
