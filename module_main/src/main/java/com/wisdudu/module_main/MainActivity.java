package com.wisdudu.module_main;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wisdudu.lib_common.base.BaseActivity;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
    }
}
