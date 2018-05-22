package kr.co.florier.florier_mock_up;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MakeFlowerMain extends Fragment {
    @BindView(R.id.start_flower)
    Button start_flower;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_make_flower_main, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this, rootview);

        return rootview;
    }
    @OnClick(R.id.start_flower)
    public void clickStart(View view) {
        Intent intent = new Intent(getActivity(), MakeFlowerMenu.class);
        getActivity().startActivityForResult(intent, 5);
    }

}
