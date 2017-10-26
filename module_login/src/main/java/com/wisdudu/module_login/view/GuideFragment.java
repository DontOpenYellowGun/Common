package com.wisdudu.module_login.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kelin.mvvmlight.collectionadapter.ItemView;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.orhanobut.hawk.Hawk;
import com.wisdudu.lib_common.base.BaseFragment;
import com.wisdudu.module_login.BR;
import com.wisdudu.module_login.R;
import com.wisdudu.module_login.constants.Constants;

import io.reactivex.functions.Action;

/**
 * 文件描述：引导页
 * <p>
 * 作者：   Created by sven on 2017/10/22.
 */
@Route(path = "/login/GuideFragment")
public class GuideFragment extends BaseFragment {

    private ViewDataBinding mBinding;

    public final ItemView mItemView = ItemView.of(BR.model, R.layout.login_item_guide_page);

    public final ObservableArrayList<Integer> mItems = new ObservableArrayList<Integer>() {{
        add(R.drawable.bg_guide_1);
        add(R.drawable.bg_guide_2);
        add(R.drawable.bg_guide_3);
        add(R.drawable.bg_guide_4);
    }};

    public ReplyCommand confirmCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            startWithPop("/login/LoginFragment");
        }
    });

    public static GuideFragment newInstance() {
        Bundle args = new Bundle();
        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment_guide, container, false);
        mBinding.setVariable(BR.viewModel, this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Hawk.put(Constants.IS_INTO_GUIDE_PAGE, true);
    }

    @Override
    public boolean onBackPressedSupport() {
        getActivity().finish();
        return super.onBackPressedSupport();
    }
}
