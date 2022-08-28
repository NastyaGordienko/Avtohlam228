package com.example.avtohlam10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Product;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list=findViewById(R.id.order_list);
        List<String> productTitle=new ArrayList<>();
        for(Product c:MainActivity.fullProductsList){
            if(Order.items_id.contains(c.getId()))
                productTitle.add(c.getTitle());

        }
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productTitle));
    }
}