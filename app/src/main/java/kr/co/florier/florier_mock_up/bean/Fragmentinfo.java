package kr.co.florier.florier_mock_up.bean;

import android.support.v4.app.Fragment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-03-14.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fragmentinfo {
    private int iconid;
    private String text;
    private Fragment fragment;
}
