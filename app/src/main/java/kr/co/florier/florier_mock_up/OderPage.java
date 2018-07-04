package kr.co.florier.florier_mock_up;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_oder_page, container, false);
        Activity parentActivity = getActivity();

        ButterKnife.bind(this, rootview);

        return rootview;
    }
}