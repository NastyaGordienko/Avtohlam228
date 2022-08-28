package com.example.avtohlam10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import model.Order;

public class ProductPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        ConstraintLayout productPageBg=findViewById(R.id.productPageBg);
        ImageView productPageImg=findViewById(R.id.productPageImg);
        TextView productPageTitle=findViewById(R.id.productPageTitle);
        TextView productPageDate=findViewById(R.id.productPageDate);
        TextView productPageLevel=findViewById(R.id.productPageLevel);
        TextView productPageText=findViewById(R.id.productDescription);

        productPageBg.setBackgroundColor(getIntent().getIntExtra("Bg",0));
        productPageImg.setImageResource(getIntent().getIntExtra("Img",0));
        productPageTitle.setText(getIntent().getStringExtra("Title"));
        productPageDate.setText(getIntent().getStringExtra("Date"));
        productPageLevel.setText(getIntent().getStringExtra("Level"));
        productPageText.setText(getIntent().getStringExtra("Text"));





    }


    public void addToCard(View view) {
        int item_id=getIntent().getIntExtra("productId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено!)", Toast.LENGTH_LONG).show();
    }
}