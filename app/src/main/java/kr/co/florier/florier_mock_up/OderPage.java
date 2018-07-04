package kr.co.florier.florier_mock_up;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import kr.co.florier.florier_mock_up.bean.Store;
import kr.co.florier.florier_mock_up.map.MapFragment;


/**
 * Created by Administrator on 2018-03-26.
 */

public class OderPage extends Fragment {

    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> location = new ArrayList<>();

    ArrayList<Store> stores = new ArrayList<>();
    ArrayList<Store> stores2 = new ArrayList<>();


    /*@BindView(R.id.oder_page_text)
    TextView oder_page_text;

    @BindView(R.id.oder_page_price)
    Spinner oder_page_price;*/
    @BindView(R.id.oder_page_city) Spinner oder_page_city;
    @BindView(R.id.oder_page_location) Spinner oder_page_location;
    @BindView(R.id.list_store) ListView list_store;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_oder_page, container, false);
        Activity parentActivity = getActivity();

        ButterKnife.bind(this,rootview);
        Log.d("jp","클릭11");
       /* price.add("1000");
        price.add("2000");
        price.add("3000");*/

        city.add("서울시");
        city.add("경기도");

        /*네이버 지도 프래그먼트*/
        MapFragment map = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("district", stores2);
        map.setArguments(bundle);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHere, map);
        fragmentTransaction.replace(R.id.fragmentHere, map);
        fragmentTransaction.commit();
        Log.d("bundle", "bundle: " +bundle);

        /*ArrayAdapter spinnerPrice;
        spinnerPrice = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, price);
        oder_page_price.setAdapter(spinnerPrice);*/

        /*스피너 도시 선택*/
        ArrayAdapter spinnerCity;
        spinnerCity = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, city);
        oder_page_city.setAdapter(spinnerCity);

        return rootview;
    }

    /*@OnItemSelected(R.id.oder_page_price)
    public void onPriceSelected(View v, int i){
        Toast.makeText(getActivity(),"선택된 아이템 : "+ oder_page_price.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }*/


    /*온셀렉트 아이템을 통해서 도시 선택시 해당 지역만 지역스피너 목록에 add*/
    @OnItemSelected(R.id.oder_page_city)
    public void onCitySelected(View v, int i){
        /*Toast.makeText(getActivity(), "선택된 지역: " +oder_page_city.getItemAtPosition(i), Toast.LENGTH_LONG).show();*/
        if(oder_page_city.getItemAtPosition(i).equals("서울시")){
            location.clear();
            location.add("강남구");
            location.add("강서구");
            location.add("강북구");
            location.add("강동구");
        } else if(oder_page_city.getItemAtPosition(i).equals("경기도")){
            location.clear();
            location.add("수원시");
            location.add("성남시");
            location.add("안양시");
            location.add("고양시");
        }

        ArrayAdapter spinnerLocation;
        spinnerLocation = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, location);
        oder_page_location.setAdapter(spinnerLocation);

    }
/*
    // 지역선택용 스피너로 지역 선택시 selectLocation함수로 해당 지역만 리스트뷰 띄움
    @OnItemSelected(R.id.oder_page_location)
    public void onLocationSelected(View v, int i){
        selectLocation(i, "강서구");
        selectLocation(i, "강남구");
        selectLocation(i, "강북구");
        selectLocation(i, "강동구");
        selectLocation(i, "수원시");
        selectLocation(i, "성남시");
        *//*if(oder_page_location.getItemAtPosition(i).equals("강서구")){
            //db에 강서구를 select해서 리턴해주는 값을 받아야한다. 그러면 이건 arrylist형태로 넘어오게 되고 이 것을 Store에 저장해야한다.
            *//**//*stores.clear();
            ArrayList<Store> stores2 = new ArrayList<>();
            for(int i1=0; i1<stores.size(); i1++){
                String list = stores.get(i1).getDistrict();
                Log.d("kac", i1 +list);
                if(list.equals("강서구")){
                    stores2.add(stores.get(i1));
                }
            }
            FlowerStoreListAdapter FlowerStoreListadapter = new FlowerStoreListAdapter(stores2);
            list_store.setAdapter(FlowerStoreListadapter);*//**//*
        }
        Toast.makeText(getActivity(), "선택된 지역: " +oder_page_location.getItemAtPosition(i), Toast.LENGTH_LONG).show();*//*
    }
    *//*stores에 저장된 목록중 입력된 district 변수와 저장되어있는 district 값이 일치하는
     * 값을 리스트뷰로 띄우는 함수*//*
    public void selectLocation(int i, String district){
      if(oder_page_location.getItemAtPosition(i).equals(district)){
          //ArrayList<Store> stores2 = new ArrayList<>();
          stores2.clear();
          for(int i1=0; i1<stores.size(); i1++){
              String list = stores.get(i1).getDistrict();
              Log.d("kac", i1 +list);
              if(list.equals(district)){
                  stores2.add(stores.get(i1));
                  Log.d("kac", "district: " +i1 +stores2);
              }
          }
          *//*Intent intent = new Intent(getActivity(), Main2Activity.class);
          startActivity(intent);*//*

          FlowerStoreListAdapter FlowerStoreListadapter = new FlowerStoreListAdapter(stores2);
          list_store.setAdapter(FlowerStoreListadapter);


        }
    }

    @OnItemClick(R.id.list_store)
    public void onitmeclicklisner(View v, int i){
        Log.d("jp","클릭2");
        Intent intent = new Intent(getActivity(),Flower_shop_main.class);
        Store item = stores.get(i);
        intent.putExtra("pos",item.getFlower_store_id());
        startActivity(intent);
    }*/


}