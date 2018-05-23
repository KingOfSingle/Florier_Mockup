package kr.co.florier.florier_mock_up.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.florier.florier_mock_up.R;
import kr.co.florier.florier_mock_up.bean.Flower;

public class Flower_select_list_item extends BaseAdapter {
    ArrayList<Flower> flowers = new ArrayList<>();

    Context context;

    public Flower_select_list_item(ArrayList<Flower> flowers, Context context){
        this.flowers = flowers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return flowers.size();
    }

    @Override
    public Object getItem(int i) {
        return flowers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flower_select_list_item, viewGroup, false);
            holder.select_list_item_flower = view.findViewById(R.id.select_list_item_flower);
            holder.select_list_item_count = view.findViewById(R.id.select_list_item_count);
            holder.select_list_item_cost = view.findViewById(R.id.select_list_item_cost);

            view.setTag(holder);
        } else{
            holder = (Holder) view.getTag();
        }

        Flower item = (Flower) getItem(i);

        // Intent이용해서 클릭한 꽃 정보 받는 부분
        Intent intent = ((Activity) context).getIntent();
        String name = intent.getStringExtra("flowerName");
        Integer count = intent.getIntExtra("count", 0);
        Integer price = intent.getIntExtra("flowerPrice", 0);
        holder.select_list_item_flower.setText(name);
        holder.select_list_item_count.setText(count.toString());
        holder.select_list_item_cost.setText(price.toString());

        return view;
    }

    private class Holder{
        TextView select_list_item_flower;
        TextView select_list_item_count;
        TextView select_list_item_cost;
    }

}
