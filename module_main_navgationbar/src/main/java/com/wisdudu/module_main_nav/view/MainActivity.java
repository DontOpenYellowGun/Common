package com.wisdudu.module_main_nav.view;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wisdudu.lib_common.base.FragmentActivity;

import me.yokeyword.fragmentation.SupportFragment;
@Route(path = "/main_nav/MainActivity")
public class MainActivity extends FragmentActivity {

    @Override
    protected SupportFragment loadFragment() {
        return MainFragment.newInstance();
    }
}
