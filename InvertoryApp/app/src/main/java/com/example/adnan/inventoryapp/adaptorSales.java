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
public class adaptorSales extends BaseAdapter {
    Context con;
    ArrayList<signatureSales> list;
    LayoutInflater inflater;

    public adaptorSales(Context con, ArrayList<signatureSales> list) {
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
        View v = inflater.inflate(R.layout.sales_ui, parent, false);
        TextView name = (TextView) v.findViewById(R.id.salesName);
        TextView quantity = (TextView) v.findViewById(R.id.quantitySales);
        TextView price = (TextView) v.findViewById(R.id.salesPrice);
        TextView sales = (TextView) v.findViewById(R.id.sales);

        name.setText(list.get(position).getName());
        quantity.setText("Quantity :" + list.get(position).getQuantity());
        price.setText("RS :" + list.get(position).getPrice());
        sales.setText("Sales :" + list.get(position).getSales());
        return v;
    }
}
