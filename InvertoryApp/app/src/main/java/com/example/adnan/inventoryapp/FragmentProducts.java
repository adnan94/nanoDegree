package com.example.adnan.inventoryapp;


import android.content.DialogInterface;
import android.os.Bundle;
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
public class FragmentProducts extends Fragment {
    sqlHandler sqlHandler;
    ListView listView;
    ArrayList<signatureProducts> list;

    public FragmentProducts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_fragmentroducts, container, false);
        listView = (ListView) v.findViewById(R.id.listView);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        sqlHandler = new sqlHandler(getActivity());
        list = new ArrayList<>();
        refresh();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add Product");
                builder.setMessage("Add you PRoduct Name, Quantity , and PRice!");
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.product_alertview, null);
                final EditText peditName = (EditText) view1.findViewById(R.id.edit_pName);
                final EditText peditQuantity = (EditText) view1.findViewById(R.id.edit_pQuantity);
                final EditText peditPrice = (EditText) view1.findViewById(R.id.edit_pPrice);
                builder.setView(view1);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        signatureProducts products = new signatureProducts(peditName.getText().toString(), Integer.valueOf(peditQuantity.getText().toString()), Integer.valueOf(peditPrice.getText().toString()));
                        sqlHandler.insertProduct(products);
                        refresh();
                    }
                });
                builder.create().show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                int ids = list.get(position).getId();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Sales");
                builder.setTitle("You want Sale this Product??");
                builder.setPositiveButton("Sales", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                        View vieww = LayoutInflater.from(getActivity()).inflate(R.layout.addsale_layout, null);
                        final EditText editSale = (EditText) vieww.findViewById(R.id.add_sales);

                        alert.setTitle("Enter Sale?");
                        alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    int id = list.get(position).getId();
                                    int noOfSales = list.get(position).getQuantity() - Integer.valueOf(editSale.getText().toString());
                                    signatureProducts products = new signatureProducts(list.get(position).getName(), noOfSales, list.get(position).getId(), list.get(position).getPrice());
                                    sqlHandler.updateValue(products);
                                    refresh();

                                    signatureSales sales = new signatureSales(list.get(position).getName(), list.get(position).getPrice(), noOfSales, Integer.valueOf(editSale.getText().toString()));

                                    sqlHandler.insertSales(sales);
                                   DetailsFragment.refresh();

                                } catch (Exception ex) {

                                    ex.printStackTrace();
                                }
                            }
                        });

                        alert.setView(vieww);
                        alert.create().show();
                    }
                });

                builder.setNegativeButton("Delete Product", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = list.get(position).getId();
                        sqlHandler.deleteProduct(id, "products");
                        list.remove(position);
                        refresh();

                    }
                });


                builder.create().show();
            }
        });
        return v;
    }


    public void refresh() {
        list = sqlHandler.retrive();
        adaptorProducts adaptorProducts = new adaptorProducts(getActivity(), list);
        listView.setAdapter(adaptorProducts);


    }
}
