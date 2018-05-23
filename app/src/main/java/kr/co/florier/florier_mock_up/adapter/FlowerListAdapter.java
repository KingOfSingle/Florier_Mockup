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

            view.setTag(holder);
        } else{
            holder = (FlowerListAdapter.Holder)view.getTag();
        }
        Flower item = (Flower) getItem(position);
        String price = String.valueOf(item.getFlower_price());
        holder.tx_flower_name.setText(item.getFlower_name());
        holder.tx_flower_price.setText(price);
        if(item.getFlower_id()==0) {
            holder.flower_img.setBackgroundResource(R.drawable.rose_mess);
        }else if(item.getFlower_id()==1){
            holder.flower_img.setBackgroundResource(R.drawable.rose2_mess);
        }else if(item.getFlower_id()==2){
            holder.flower_img.setBackgroundResource(R.drawable.rose3_mess);
        }else if(item.getFlower_id()==3){
            holder.flower_img.setBackgroundResource(R.drawable.rose4_mess);
        }else if(item.getFlower_id()==4){
            holder.flower_img.setBackgroundResource(R.drawable.rose5_mess);
        }else if(item.getFlower_id()==5){
            holder.flower_img.setBackgroundResource(R.drawable.sugok);
        }else if(item.getFlower_id()==6){
            holder.flower_img.setBackgroundResource(R.drawable.cane_mess);
        }else if(item.getFlower_id()==7){
            holder.flower_img.setBackgroundResource(R.drawable.jak_mess);
        }else if(item.getFlower_id()==8){
            holder.flower_img.setBackgroundResource(R.drawable.ucalips_piller);
        }else if(item.getFlower_id()==9){
            holder.flower_img.setBackgroundResource(R.drawable.idon_piller);
        }else if(item.getFlower_id()==10){
            holder.flower_img.setBackgroundResource(R.drawable.mist_piller);
        }

        return view;
    }

    private class Holder{
        View flower_img;
        TextView tx_flower_name;
        TextView tx_flower_price;
    }

}
