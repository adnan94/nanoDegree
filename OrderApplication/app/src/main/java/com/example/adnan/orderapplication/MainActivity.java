package com.example.adnan.orderapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    CheckBox cream, chocolate;
    Button plus, minus, order;
    TextView summary, quantityText;
    int quantity=1, total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilize();
        listenerr();

    }

    public void initilize() {
        name = (EditText) findViewById(R.id.name);
        cream = (CheckBox) findViewById(R.id.checkBox);
        chocolate = (CheckBox) findViewById(R.id.checkBox2);
        plus = (Button) findViewById(R.id.buttonPlus);
        minus = (Button) findViewById(R.id.buttonMinus);
        order = (Button) findViewById(R.id.order);
        summary = (TextView) findViewById(R.id.summary);
        quantityText = (TextView) findViewById(R.id.quantityText);
    }

    public void listenerr() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity++;
                quantityText.setText("" + quantity);


            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity < 1) {
                    Toast.makeText(MainActivity.this, "Quantity must greater then 0", Toast.LENGTH_SHORT).show();
                    quantityText.setText("" + quantity);
                    quantity = 1;
                } else {
                    quantity--;
                    quantityText.setText("" + quantity);
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               total= check(cream.isChecked(), chocolate.isChecked(), quantity);
                summary.setText("Name :" + name.getText().toString() + "\nAdd Cream :" + cream.isChecked() + "\nAdd Chocolate :" + chocolate.isChecked() + "\nQuantity :" + quantity + "\nTotal : " + total + "\nThanks For Ordering !");

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Order_app order summary to " + name);
                intent.putExtra(Intent.EXTRA_STREAM,"Attachment");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                total = 0;
            }}
        });
    }


    public int check(boolean cream, boolean chocolate, int quantity) {
        int cofeeSum = quantity * 15;

        if (cream == true && chocolate == true) {
            total = cofeeSum + (quantity * 10) + (quantity * 5);
        } else if (cream == true && chocolate == false) {
            total = cofeeSum + (quantity * 5);
        } else if (chocolate == true && cream == false) {
            total = cofeeSum + (quantity * 10);
        }else if(cream == false && chocolate == false){
            total=cofeeSum;
        }
        return total;
    }
}
