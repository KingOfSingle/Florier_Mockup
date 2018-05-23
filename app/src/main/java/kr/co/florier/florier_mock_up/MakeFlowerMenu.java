package kr.co.florier.florier_mock_up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.florier.florier_mock_up.bean.Flower;

/**
 * Created by Administrator on 2018-03-14.
 */

public class MakeFlowerMenu extends AppCompatActivity {

    ArrayList<Integer> flowersType = new ArrayList<>();

    @BindView(R.id.form_btn)
    Button form_btn;
    @BindView(R.id.line_btn)
    Button line_btn;
    @BindView(R.id.fill_btn)
    Button fill_btn;
    @BindView(R.id.mass_btn)
    Button mass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_flower_menu);
        ButterKnife.bind(this);

        flowersType.add(0); // 폼플라워
        flowersType.add(1); // 메스플라워
        flowersType.add(2); // 라인플라워
        flowersType.add(3); // 필플라워

    }

    @OnClick(R.id.form_btn)
    public void clickForm(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this, Flower_select.class);
        // intent로 폼플라워인지 메스플라워인지 타입값을 넘긴다.
        intent.putExtra("flowerType", 0);
        startActivityForResult(intent, 0);

    }
    @OnClick(R.id.mass_btn)
    public void clickMass(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this,Flower_select.class);
        intent.putExtra("flowerType", 1);
        startActivityForResult(intent, 1);

    }
    @OnClick(R.id.line_btn)
    public void clickLine(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this,Flower_select.class);

        intent.putExtra("flowerType", 2);
        startActivityForResult(intent, 2);

    }
    @OnClick(R.id.fill_btn)
    public void clickFill(View view) {
        Intent intent = new Intent(MakeFlowerMenu.this,Flower_select.class);
        intent.putExtra("flowerType", 3);
        startActivityForResult(intent, 3);

    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode==0){
//            if(resultCode==RESULT_OK){
//                // 선택한 폼플라워 리스트
//            }
//        } else if(requestCode==1){
//            if(resultCode==RESULT_OK){
//                // 선택한 메스플라워 리스트
//            }
//        } else if(requestCode==2){
//            if(resultCode==RESULT_OK){
//                // 선택한 라인플라워 리스트
//            }
//        } else if(requestCode==0){
//            if(resultCode==RESULT_OK){
//                // 선택한 필러플라워 리스트
//            }
//        }
//    }

}
