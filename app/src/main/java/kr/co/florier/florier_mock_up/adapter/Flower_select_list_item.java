package kr.co.florier.florier_mock_up.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.florier.florier_mock_up.bean.Flower;

public class Flower_select_list_item extends BaseAdapter {
    ArrayList<Flower> flowers = new ArrayList<>();

    public Flower_select_list_item(ArrayList<Flower> flowers){
        this.flowers = flowers;
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
        return null;
    }

    private class Holder{
        TextView select_list_item_flower;
        TextView select_list_item_how_count;
        TextView select_list_item_cost;
    }

}
