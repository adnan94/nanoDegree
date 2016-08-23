package com.example.adnan.inventoryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adnan on 8/21/2016.
 */
public class adaptorProducts extends BaseAdapter {
    Context con;
    ArrayList<signatureProducts> list;
    LayoutInflater inflater;

    public adaptorProducts(Context con, ArrayList<signatureProducts> list) {
        this.con = con;
        this.list = list;
        inflater = inflater.from(con);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.products_ui, parent, false);
        TextView name = (TextView) v.findViewById(R.id.productsName);
        TextView quantity = (TextView) v.findViewById(R.id.quantityProducts);
        TextView price = (TextView) v.findViewById(R.id.price);

        name.setText(list.get(position).getName());
        quantity.setText("Quantity :" + list.get(position).getQuantity());
        price.setText("RS :" + list.get(position).getPrice());

        return v;
    }
}
