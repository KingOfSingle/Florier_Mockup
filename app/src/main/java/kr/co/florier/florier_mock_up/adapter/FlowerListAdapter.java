package kr.co.florier.florier_mock_up.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.florier.florier_mock_up.bean.Flower;
import kr.co.florier.florier_mock_up.R;


/**
 * Created by Administrator on 2018-03-14.
 */

public class FlowerListAdapter extends BaseAdapter {
    ArrayList<Flower> flowers = new ArrayList<>();

    public FlowerListAdapter(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public int getCount() {
        return flowers.size();
    }

    @Override
    public Object getItem(int position) {
        return flowers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        FlowerListAdapter.Holder holder = new FlowerListAdapter.Holder();
        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.flower_list_item,viewGroup,false);
            holder.tx_flower_name = view.findViewById(R.id.tx_flower_name);
            holder.tx_flower_price =view.findViewById(R.id.tx_flower_price);
            holder.flower_img = view.findViewById(R.id.flower_img);
            holder.tx_count = view.findViewById(R.id.tx_count);
            holder.btn_up = view.findViewById(R.id.btn_up);
            holder.btn_down = view.findViewById(R.id.btn_down);

            view.setTag(holder);
        } else{
            holder = (FlowerListAdapter.Holder)view.getTag();
        }
        Flower item = (Flower) getItem(position);
        String price = String.valueOf(item.getFlower_price());
        holder.tx_flower_name.setText(item.getFlower_name());
        holder.tx_flower_price.setText(price);
        holder.flower_img.setBackgroundResource(R.drawable.ic_launcher_background);

        final int count = 0;
//        holder.btn_up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        return view;
    }
    public void countUp(){
        Holder holder = new Holder();
        holder.btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Holder holder = new Holder();
                int count = 0;
                count += 1;
                String a = Integer.toString(count);
                holder.tx_count.setText(a);
            }
        });
    }
    public void countDown(){
        Holder holder = new Holder();
        holder.btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Holder holder = new Holder();
                int count = 0;
                count -= 1;
                String a = Integer.toString(count);
                holder.tx_count.setText(a);
            }
        });
    }

    private class Holder{
        View flower_img;
        TextView tx_flower_name;
        TextView tx_flower_price;
        Button btn_up;
        Button btn_down;
        TextView tx_count;
    }

}
