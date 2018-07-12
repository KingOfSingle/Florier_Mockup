package kr.co.florier.florier_mock_up;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import kr.co.florier.florier_mock_up.bean.Store;
import kr.co.florier.florier_mock_up.map.MapFragment;


/**
 * Created by Administrator on 2018-03-26.
 */

public class ShopPage extends Fragment {

    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> location = new ArrayList<>();

    ArrayList<Store> stores = new ArrayList<>();
    ArrayList<Store> stores2 = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_shop_page, container, false);
        Activity parentActivity = getActivity();

        ButterKnife.bind(this,rootview);

        city.add("서울시");
        city.add("경기도");

        /*테스트용 꽃집 입력*/
        Store store1 = new Store(0,"데이데이플라워","서울시","강서구", 37.5558818, 126.8606436,"www.naver.com","0105040304","서울시 강서구 등촌3동");
        Store store2 = new Store(1,"밝은빛꽃","충청남도","보령시",36.3525227, 126.5987928, "www.naver.com","0105040304","충청남도 보령시 죽정동");
        Store store3 = new Store(2,"예그리나","서울시","강서구",37.5574591, 126.8558204, "www.naver.com","0105040304","서울시 강서구 염창동");
        Store store4 = new Store(3,"스윗스멜링","서울시","강남구",37.4978372, 127.0419858, "www.naver.com","0105040304","서울시 강남구 역삼2동");
        Store store5 = new Store(4,"도봉꽃화원","서울시","강북구",37.6387389, 127.0244363, "www.naver.com","0105040304","서울시 강북구 등촌동");
        Store store6 = new Store(5,"오복꽃집","경기도","성남시", 37.4412417, 127.132513, "www.naver.com","0105040304","경기도 성남시 수정구");
        Store store7 = new Store(6,"아이엠플라워","경기도","수원시",37.3527521, 126.9890797, "www.naver.com","0105040304","경기도 수원시 권선구");
        Store store8 = new Store(7,"아름다운꽃집","경기도","성남시",37.4387202, 127.1301956, "www.naver.com","0105040304","경기도 성남시 수정구");
        Store store9 = new Store(8,"영플라워","서울시","강서구",37.5608424, 126.8546006, "www.naver.com","0105040304","경기도 강서구 등촌3동");
        stores.add(store1);
        stores.add(store2);
        stores.add(store3);
        stores.add(store4);
        stores.add(store5);
        stores.add(store6);
        stores.add(store7);
        stores.add(store8);
        stores.add(store9);

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

        return rootview;
    }

    /*@OnItemSelected(R.id.oder_page_price)
    public void onPriceSelected(View v, int i){
        Toast.makeText(getActivity(),"선택된 아이템 : "+ oder_page_price.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }*/

    /*지역선택용 스피너로 지역 선택시 selectLocation함수로 해당 지역만 리스트뷰 띄움*//*
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

          *//*네이버 지도 프래그먼트*//*
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
        }
    }*/
}