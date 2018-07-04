package kr.co.florier.florier_mock_up;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import kr.co.florier.florier_mock_up.bean.Flower;



public class Flower_select extends AppCompatActivity {

    ArrayList<Flower> flowers = new ArrayList<>();
    ArrayList<Flower> flowers2 = new ArrayList<>();

    @BindView(R.id.flower_list)
    GridView flower_list;
    /*@BindView(R.id.select_list)
    ListView select_list;*/
    @BindView(R.id.btn_ok)
    Button btn_ok;

    @BindView(R.id.name1) TextView name1;
    @BindView(R.id.count1) TextView count1;
    @BindView(R.id.price1) TextView price1;
    @BindView(R.id.name2) TextView name2;
    @BindView(R.id.count2) TextView count2;
    @BindView(R.id.price2) TextView price2;
    @BindView(R.id.name3) TextView name3;
    @BindView(R.id.count3) TextView count3;
    @BindView(R.id.price3) TextView price3;
    @BindView(R.id.name4) TextView name4;
    @BindView(R.id.count4) TextView count4;
    @BindView(R.id.price4) TextView price4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_select);
        ButterKnife.bind(this);

        Flower flower1 = new Flower(0,0,"장미(분홍)",3000,"www.naver.com");
        Flower flower2 = new Flower(1,0,"장미(주황)",3000,"www.naver.com");
        Flower flower3 = new Flower(2,0,"장미(빨강)",3000,"www.naver.com");
        Flower flower4 = new Flower(3,0,"장미(연분홍)",3000,"www.naver.com");
        Flower flower5 = new Flower(4,0,"장미(백)",3000,"www.naver.com");
        Flower flower6 = new Flower(5,1,"수국",20000,"www.naver.com");
        Flower flower7 = new Flower(6,1,"카네이션",2000,"www.naver.com");
        Flower flower8 = new Flower(7,1,"작약",10000,"www.naver.com");
        Flower flower9 = new Flower(8,2,"유칼립스",3000,"www.naver.com");
        Flower flower10 = new Flower(9,3,"idon",2000,"www.naver.com");
        Flower flower11 = new Flower(10,3,"안개꽃",6000,"www.naver.com");


        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);
        flowers.add(flower4);
        flowers.add(flower5);
        flowers.add(flower6);
        flowers.add(flower7);
        flowers.add(flower8);
        flowers.add(flower9);
        flowers.add(flower10);
        flowers.add(flower11);

        Intent intent = getIntent();
        Integer flowerType = intent.getIntExtra("flowerType", 0);

        Log.d("flowerType", "flwoerType: " +flowerType);
        checkFlowerType(flowerType);

        if(flowers2.size()==1){
            name1.setText(flowers2.get(0).getFlower_name());
            price1.setText(String.valueOf(flowers2.get(0).getFlower_price()));
        }else if(flowers2.size()==2){
            name1.setText(flowers2.get(0).getFlower_name());
            name2.setText(flowers2.get(1).getFlower_name());
            price1.setText(String.valueOf(flowers2.get(0).getFlower_price()));
            price2.setText(String.valueOf(flowers2.get(1).getFlower_price()));
        }else if(flowers2.size()==3){
            name1.setText(flowers2.get(0).getFlower_name());
            name2.setText(flowers2.get(1).getFlower_name());
            name3.setText(flowers2.get(2).getFlower_name());
            price1.setText(String.valueOf(flowers2.get(0).getFlower_price()));
            price2.setText(String.valueOf(flowers2.get(1).getFlower_price()));
            price3.setText(String.valueOf(flowers2.get(2).getFlower_price()));
        }else {
            name1.setText(flowers2.get(0).getFlower_name());
            name2.setText(flowers2.get(1).getFlower_name());
            name3.setText(flowers2.get(2).getFlower_name());
            name4.setText(flowers2.get(3).getFlower_name());
            price1.setText(String.valueOf(flowers2.get(0).getFlower_price()));
            price2.setText(String.valueOf(flowers2.get(1).getFlower_price()));
            price3.setText(String.valueOf(flowers2.get(2).getFlower_price()));
            price4.setText(String.valueOf(flowers2.get(3).getFlower_price()));
        }
    }

    int a1,a2,a3,a4 = 0;
    @OnItemClick(R.id.flower_list)
    public void onItemClick(View v, int i) {
        Flower item = flowers2.get(i);
        if (item.getFlower_id()==0) {
            a1++;
            count1.setText(Integer.toString(a1));
        } else if (item.getFlower_id()==1) {
            a2++;
            count2.setText(Integer.toString(a2));
        } else if (item.getFlower_id()==3) {
            a3++;
            count3.setText(Integer.toString(a3));
        } else if (item.getFlower_id()==4) {
            a4++;
            count4.setText(Integer.toString(a4));
        }
        Intent intent=getIntent();
        String name1 = intent.getStringExtra("name1");
        String name2 = intent.getStringExtra("name2");
        String name3 = intent.getStringExtra("name3");
        String name4 = intent.getStringExtra("name4");
        int count1 = intent.getIntExtra("count1",0);
        int count2 = intent.getIntExtra("count2",0);
        int count3 = intent.getIntExtra("count3",0);
        int count4 = intent.getIntExtra("count4",0);
        int price1 = intent.getIntExtra("price1",0);
        int price2 = intent.getIntExtra("price2",0);
        int price3 = intent.getIntExtra("price3",0);
        int price4 = intent.getIntExtra("price4",0);

    }
    @OnClick(R.id.btn_ok)
    public void clickOk(View view) {

        Toast.makeText(Flower_select.this,"주문이 완료 되었습니다!" , Toast.LENGTH_LONG).show();
        finish();
    }

    // 타입에 따른 꽃 분류
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
    }
}
