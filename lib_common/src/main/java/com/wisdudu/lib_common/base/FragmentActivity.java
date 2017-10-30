package com.wisdudu.lib_common.base;

import android.os.Bundle;

import com.wisdudu.lib_common.R;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 文件描述：
 * <p>
 * 作者：   Created by sven on 2017/10/25.
 */

public abstract class FragmentActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        loadRootFragment(R.id.fragment_container, loadFragment());
    }

    protected abstract SupportFragment loadFragment();


}
