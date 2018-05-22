package kr.co.florier.florier_mock_up;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import kr.co.florier.florier_mock_up.adapter.Flower_product_adapter;
import kr.co.florier.florier_mock_up.bean.Flower_product;

public class Flower_shop_main extends AppCompatActivity {
    GridView grid_store;
    ArrayList<Flower_product> flower_products = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_shop_main);
        grid_store = findViewById(R.id.grid_store);

        Flower_product grid_test1 = new Flower_product("www.naver.com","진홍빛주말","10000");
        Flower_product grid_test2 = new Flower_product("www.naver.com","기억","40000");
        Flower_product grid_test3 = new Flower_product("www.naver.com","소리","10000");
        Flower_product grid_test4 = new Flower_product("www.naver.com","다다","10000");
        Flower_product grid_test5 = new Flower_product("www.naver.com","자자","10000");
        flower_products.add(grid_test1);
        flower_products.add(grid_test2);
        flower_products.add(grid_test3);
        flower_products.add(grid_test4);
        flower_products.add(grid_test5);


        Flower_product_adapter gridAdapter = new Flower_product_adapter(flower_products);
        grid_store.setAdapter(gridAdapter);


    }
}
