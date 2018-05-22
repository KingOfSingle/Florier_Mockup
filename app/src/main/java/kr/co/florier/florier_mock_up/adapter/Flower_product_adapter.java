package kr.co.florier.florier_mock_up.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.florier.florier_mock_up.R;
import kr.co.florier.florier_mock_up.bean.Flower_product;

public class Flower_product_adapter extends BaseAdapter {
    ArrayList<Flower_product> flower_products = new ArrayList<>();

    public Flower_product_adapter(ArrayList<Flower_product> flower_products) {
        this.flower_products = flower_products;
    }


    @Override
    public int getCount() {
        return flower_products.size();
    }

    @Override
    public Object getItem(int i) {
        return flower_products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Flower_product_adapter.Holder holder = new Flower_product_adapter.Holder();

        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.flower_product_item,viewGroup,false);
            holder.store_flower_price = view.findViewById(R.id.store_flower_price);
            holder.store_flower_img = view.findViewById(R.id.store_flower_img);
            holder.store_flower_name = view.findViewById(R.id.store_flower_name);

            view.setTag(holder);
        } else{
            holder = (Flower_product_adapter.Holder)view.getTag();
        }
        Flower_product item = (Flower_product) getItem(position);
        //   holder.store_flower_img.setBackground();
        holder.store_flower_name.setText(item.getFlower_name());
        holder.store_flower_price.setText(item.getFlower_price());

        return view;
    }

    private class Holder{
        View store_flower_img;
        TextView store_flower_name;
        TextView store_flower_price;
    }
}
