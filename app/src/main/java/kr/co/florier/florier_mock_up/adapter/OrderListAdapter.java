package kr.co.florier.florier_mock_up.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.florier.florier_mock_up.R;
import kr.co.florier.florier_mock_up.bean.Order_flower;

/**
 * Created by LJY on 2018-05-23.
 */

public class OrderListAdapter extends BaseAdapter {
    ArrayList<Order_flower> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_flower_list_item,viewGroup,false);
            holder.flower_name = view.findViewById(R.id.flower_name);
            holder.flower_price = view.findViewById(R.id.flower_price);
            holder.flower_count = view.findViewById(R.id.flower_count);

            view.setTag(holder);
        }else{
            holder=(Holder)view.getTag();
        }
        final Order_flower item = (Order_flower) getItem(position);
        holder.flower_name.setText(item.getName());
        holder.flower_count.setText(item.getCount());
        holder.flower_price.setText(item.getPrice());
        return view;
    }
    private class Holder {
        TextView flower_name;
        TextView flower_price;
        TextView flower_count;
    }
}
