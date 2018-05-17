package kr.co.florier.florier_mock_up;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Administrator on 2018-03-14.
 */

public class MakeDryFlower extends Fragment{
    @BindView(R.id.form_btn)
    Button form_btn;
    @BindView(R.id.line_btn)
    Button line_btn;
    @BindView(R.id.fill_btn)
    Button fill_btn;
    @BindView(R.id.mass_btn)
    Button mass_btn;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.make_flower_main, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);


        //ImageView viewz = rootview.findViewById(R.id.viewz);
        return rootview;
    }
    @OnClick(R.id.form_btn)
    public void clickForm(View view) {
        Intent intent = new Intent(getActivity(), Flower_select.class);
        startActivityForResult(intent, 0);

    }
    @OnClick(R.id.mass_btn)
    public void clickMass(View view) {
        Intent intent = new Intent(getActivity(),Flower_select.class);
        startActivityForResult(intent, 1);

    }
    @OnClick(R.id.line_btn)
    public void clickLine(View view) {
        Intent intent = new Intent(getActivity(),Flower_select.class);
        startActivityForResult(intent, 2);

    }
    @OnClick(R.id.fill_btn)
    public void clickFill(View view) {
        Intent intent = new Intent(getActivity(),Flower_select.class);
        startActivityForResult(intent, 3);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0){
            if(resultCode==RESULT_OK){
                // 선택한 폼플라워 리스트
            }
        } else if(requestCode==1){
            if(resultCode==RESULT_OK){
                // 선택한 메스플라워 리스트
            }
        } else if(requestCode==2){
            if(resultCode==RESULT_OK){
                // 선택한 라인플라워 리스트
            }
        } else if(requestCode==0){
            if(resultCode==RESULT_OK){
                // 선택한 필러플라워 리스트
            }
        }
    }


}
