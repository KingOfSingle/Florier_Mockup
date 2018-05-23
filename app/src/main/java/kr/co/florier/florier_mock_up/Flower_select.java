package kr.co.florier.florier_mock_up;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import kr.co.florier.florier_mock_up.adapter.Flower_select_list_item;
import kr.co.florier.florier_mock_up.bean.Flower;
import kr.co.florier.florier_mock_up.adapter.FlowerListAdapter;


public class Flower_select extends AppCompatActivity {

    ArrayList<Flower> flowers = new ArrayList<>();
    ArrayList<Flower> flowers2 = new ArrayList<>();

    @BindView(R.id.flower_list)
    GridView flower_list;
    @BindView(R.id.select_list)
    ListView select_list;
    @BindView(R.id.btn_ok)
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_select);
        ButterKnife.bind(this);

        Flower flower1 = new Flower(0,0,"장미",25000,"www.naver.com",0);
        Flower flower2 = new Flower(1,0,"수국",35000,"www.naver.com",0);
        Flower flower3 = new Flower(2,1,"튤립",65000,"www.naver.com",0);
        Flower flower4 = new Flower(3,2,"오드",75000,"www.naver.com",0);
        Flower flower5 = new Flower(4,3,"해바라기",15000,"www.naver.com",0);
        Flower flower6 = new Flower(5,2,"백합",15000,"www.naver.com",0);

        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);
        flowers.add(flower4);
        flowers.add(flower5);
        flowers.add(flower6);

        Intent intent = getIntent();
        Integer flowerType = intent.getIntExtra("flowerType", 0);

        Log.d("flowerType", "flwoerType: " +flowerType);
        checkFlowerType(flowerType);

    }

    int count = 0;
    @OnItemClick(R.id.flower_list)
    public void onItemClick(View v, int i){
        count++;
        Flower item = flowers2.get(i);
        Intent intent = new Intent(Flower_select.this, Flower_select_list_item.class);
        intent.putExtra("flowerName", item.getFlower_name());
        intent.putExtra("count", count);
        intent.putExtra("flowerPrice", item.getFlower_price());
        Flower_select_list_item flowerSelectListItem = new Flower_select_list_item(flowers2, Flower_select.this);
        select_list.setAdapter(flowerSelectListItem);
    }

    @OnClick(R.id.btn_ok)
    public void clickOk(View view) {
        /*Intent intent = new Intent(Flower_select.this,MakeFlowerMenu.class);
        startActivityForResult(intent, 0);*/
        finish();

    }

    public void checkFlowerType(int flowerType){
        if(flowerType == 0) {
            flowers2.clear();
            for(int i1=0; i1<flowers.size(); i1++){
                int list = flowers.get(i1).getFlower_type();
                if(list == 0){
                    flowers2.add(flowers.get(i1));
                }
            }
        } else if(flowerType == 1){
            flowers2.clear();
            for(int i1=0; i1<flowers.size(); i1++){
                int list = flowers.get(i1).getFlower_type();
                if(list == 1){
                    flowers2.add(flowers.get(i1));
                }
            }
        } else if(flowerType == 2){
            flowers2.clear();
            for(int i1=0; i1<flowers.size(); i1++){
                int list = flowers.get(i1).getFlower_type();
                if(list == 2){
                    flowers2.add(flowers.get(i1));
                }
            }
        } else if(flowerType == 3){
            flowers2.clear();
            for(int i1=0; i1<flowers.size(); i1++){
                int list = flowers.get(i1).getFlower_type();
                if(list == 3){
                    flowers2.add(flowers.get(i1));
                }
            }
        }
        FlowerListAdapter FlowerListadapter = new FlowerListAdapter(flowers2);
        flower_list.setAdapter(FlowerListadapter);
    }
}
