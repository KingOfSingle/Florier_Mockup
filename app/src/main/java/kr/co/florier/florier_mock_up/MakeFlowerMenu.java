package kr.co.florier.florier_mock_up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.florier.florier_mock_up.adapter.OrderListAdapter;
import kr.co.florier.florier_mock_up.bean.Flower;
import kr.co.florier.florier_mock_up.bean.Order_flower;

/**
 * Created by Administrator on 2018-03-14.
 */

public class MakeFlowerMenu extends AppCompatActivity {

    ArrayList<Integer> flowersType = new ArrayList<>();
    ArrayList<Order_flower> items = new ArrayList<>();
    @BindView(R.id.form_btn) Button form_btn;
    @BindView(R.id.line_btn) Button line_btn;
    @BindView(R.id.fill_btn) Button fill_btn;
    @BindView(R.id.mass_btn) Button mass_btn;
    @BindView(R.id.text_form) TextView text_form;
    @BindView(R.id.text_line) TextView text_line;
    @BindView(R.id.text_fill) TextView text_fill;
    @BindView(R.id.text_mass) TextView text_mass;
    @BindView(R.id.list_form) ListView list_form;
    @BindView(R.id.list_line) ListView list_line;
    @BindView(R.id.list_fill) ListView list_fill;
    @BindView(R.id.list_mass) ListView list_mass;

    OrderListAdapter orderListAdapter;
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_flower_menu);
        ButterKnife.bind(this);

        flowersType.add(0); // 폼플라워
        flowersType.add(1); // 메스플라워
        flowersType.add(2); // 라인플라워
        flowersType.add(3); // 필플라워

        list_form.setAdapter(orderListAdapter);
        list_line.setAdapter(orderListAdapter);
        list_fill.setAdapter(orderListAdapter);
        list_mass.setAdapter(orderListAdapter);

    }

    @OnClick(R.id.form_btn)
    public void clickForm(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this, Flower_select.class);
        // intent로 폼플라워인지 메스플라워인지 타입값을 넘긴다.
        intent.putExtra("flowerType", 0);
        startActivityForResult(intent, 0);
        a = 1;
        visibleGone();
    }
    @OnClick(R.id.mass_btn)
    public void clickMass(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this,Flower_select.class);
        intent.putExtra("flowerType", 1);
        startActivityForResult(intent, 1);
        a = 2;
        visibleGone();
    }
    @OnClick(R.id.line_btn)
    public void clickLine(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this,Flower_select.class);
        intent.putExtra("flowerType", 2);
        startActivityForResult(intent, 2);
        a = 3;
        visibleGone();
    }
    @OnClick(R.id.fill_btn)
    public void clickFill(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this,Flower_select.class);
        intent.putExtra("flowerType", 3);
        startActivityForResult(intent, 3);
        a = 4;
        visibleGone();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0){
            if(resultCode==RESULT_OK){
                // 선택한 매스플라워 리스트
                String name1 = data.getStringExtra("name1");
                Integer price1 = data.getIntExtra("price1", 0);
                Integer count1 = data.getIntExtra("count1", 0);
                String name2 = data.getStringExtra("name2");
                Integer price2 = data.getIntExtra("price2", 0);
                Integer count2 = data.getIntExtra("count2", 0);
                String name3 = data.getStringExtra("name3");
                Integer price3 = data.getIntExtra("price3", 0);
                Integer count3 = data.getIntExtra("count3", 0);
                String name4 = data.getStringExtra("name4");
                Integer price4 = data.getIntExtra("price4", 0);
                Integer count4 = data.getIntExtra("count4", 0);

                Order_flower order_flower1 = new Order_flower(name1,price1,count1);
                Order_flower order_flower2 = new Order_flower(name2,price2,count2);
                Order_flower order_flower3 = new Order_flower(name3,price3,count3);
                Order_flower order_flower4 = new Order_flower(name4,price4,count4);
                items.add(order_flower1);
                items.add(order_flower2);
                items.add(order_flower3);
                items.add(order_flower4);
                list_mass.setAdapter(orderListAdapter);
                orderListAdapter.notifyDataSetChanged();
            }
        } else if(requestCode==1){
            if(resultCode==RESULT_OK){
                // 선택한 폼 플라워 리스트
                String name1 = data.getStringExtra("name1");
                Integer price1 = data.getIntExtra("price1", 0);
                Integer count1 = data.getIntExtra("count1", 0);
                String name2 = data.getStringExtra("name2");
                Integer price2 = data.getIntExtra("price2", 0);
                Integer count2 = data.getIntExtra("count2", 0);
                String name3 = data.getStringExtra("name3");
                Integer price3 = data.getIntExtra("price3", 0);
                Integer count3 = data.getIntExtra("count3", 0);

                Order_flower order_flower1 = new Order_flower(name1,price1,count1);
                Order_flower order_flower2 = new Order_flower(name2,price2,count2);
                Order_flower order_flower3 = new Order_flower(name3,price3,count3);
                items.add(order_flower1);
                items.add(order_flower2);
                items.add(order_flower3);
                list_form.setAdapter(orderListAdapter);
                orderListAdapter.notifyDataSetChanged();
            }
        } else if(requestCode==2){
            if(resultCode==RESULT_OK){
                // 선택한 라인플라워 리스트
                String name1 = data.getStringExtra("name1");
                Integer price1 = data.getIntExtra("price1", 0);
                Integer count1 = data.getIntExtra("count1", 0);

                Order_flower order_flower = new Order_flower(name1,price1,count1);
                items.add(order_flower);
                list_line.setAdapter(orderListAdapter);
                orderListAdapter.notifyDataSetChanged();
            }
        } else if(requestCode==0){
            if(resultCode==RESULT_OK){
                // 선택한 필러플라워 리스트
                String name1 = data.getStringExtra("name1");
                Integer price1 = data.getIntExtra("price1", 0);
                Integer count1 = data.getIntExtra("count1", 0);
                String name2 = data.getStringExtra("name2");
                Integer price2 = data.getIntExtra("price2", 0);
                Integer count2 = data.getIntExtra("count2", 0);
                Order_flower order_flower1 = new Order_flower(name1,price1,count1);
                Order_flower order_flower2 = new Order_flower(name2,price2,count2);

                items.add(order_flower1);
                items.add(order_flower2);
                list_fill.setAdapter(orderListAdapter);
                orderListAdapter.notifyDataSetChanged();
            }
        }
    }
    //설명 visibility = GONE 함수
    public void visibleGone(){
        if(a == 1){
            text_form.setVisibility(View.GONE);
            list_form.setVisibility(View.VISIBLE);
        }else if(a == 2){
            text_mass.setVisibility(View.GONE);
            list_mass.setVisibility(View.VISIBLE);
        }else if(a == 3) {
            text_line.setVisibility(View.GONE);
            list_line.setVisibility(View.VISIBLE);
        }else if(a == 4){
            text_fill.setVisibility(View.GONE);
            list_fill.setVisibility(View.VISIBLE);
        }
    }
}
