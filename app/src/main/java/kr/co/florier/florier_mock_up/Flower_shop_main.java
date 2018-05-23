package kr.co.florier.florier_mock_up;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        Intent intent = getIntent();
        Integer pos = intent.getIntExtra("pos",-1);
        Log.d("jp","pos="+pos);

        if(pos==0) {
            Flower_product grid_test1 = new Flower_product("0", "붉은노을", "25000");
            Flower_product grid_test2 = new Flower_product("1", "몽몽몽목화", "25000");
            Flower_product grid_test3 = new Flower_product("2", "나 혼자 장미", "10000");
            Flower_product grid_test4 = new Flower_product("3", "안개꽃다발", "10000");
            flower_products.add(grid_test1);
            flower_products.add(grid_test2);
            flower_products.add(grid_test3);
            flower_products.add(grid_test4);
        } else if(pos==1){
            Flower_product grid_test1 = new Flower_product("www.naver.com", "진홍빛주말", "10000");
            flower_products.add(grid_test1);
        }




        Flower_product_adapter gridAdapter = new Flower_product_adapter(flower_products);
        grid_store.setAdapter(gridAdapter);


    }
}
