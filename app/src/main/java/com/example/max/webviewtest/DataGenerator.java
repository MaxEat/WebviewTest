package com.example.max.webviewtest;

import android.support.v4.app.Fragment;

/**
 * Created by max on 2018/4/17.
 */

public class DataGenerator {


    public static Fragment[] getFragments() {
        Fragment fragments[] = new Fragment[2];
        fragments[0] = BlankFragment.newInstance();
        fragments[1] = BlankFragment2.newInstance();
        return fragments;
    }
}
