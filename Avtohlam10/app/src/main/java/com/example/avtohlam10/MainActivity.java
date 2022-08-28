package com.example.avtohlam10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import adapter.ProductAdapter;
import model.Category;
import adapter.CategoryAdapter;
import model.Product;

public class MainActivity extends AppCompatActivity {
 RecyclerView CategoryRecycler,ProductRecycler;
 CategoryAdapter categoryAdapter;
 static ProductAdapter productAdapter;
 static List<Product> productList = new ArrayList<>();
 static List<Product> fullProductsList = new ArrayList<>();
 ImageButton allProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.allProducts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList.clear();
                productList.addAll(fullProductsList);
                productAdapter.notifyDataSetChanged();
            }
        });


        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Меню"));
        categoryList.add(new Category(3,"Языки"));
        categoryList.add(new Category(4,"Зарядка"));

        setCategoryRecycle(categoryList);



        productList.add(new Product(1,"Профессия java\nзазработчик","1 января","начальный","java","#424345","Test",1));
        productList.add(new Product(2,"Профессия python\nзазработчик","111 января","junior","python","#9FA52D","Test",2));
        fullProductsList.addAll(productList);
        setProductRecycle(productList);
    }

    private void setProductRecycle(List<Product> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        ProductRecycler=findViewById(R.id.RecycleProduct);
        ProductRecycler.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(this,productList);
        ProductRecycler.setAdapter(productAdapter);


    }

    private void setCategoryRecycle(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        CategoryRecycler=findViewById(R.id.RecycleCategory);
        CategoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        CategoryRecycler.setAdapter(categoryAdapter);


    }
    public static void ShowProductsMyCategory(int categoty){
        productList.clear();
        productList.addAll(fullProductsList);
        List<Product> filterProducts = new ArrayList<>();
        for(Product p:productList) {
            if (p.getCategory() == categoty)
                filterProducts.add(p);
        }
            productList.clear();
            productList.addAll(filterProducts);
            productAdapter.notifyDataSetChanged();


    }

    public void ToShoppingCard(View view) {
        Intent intent=new Intent(this,OrderPage.class);
        startActivity(intent);
    }
}