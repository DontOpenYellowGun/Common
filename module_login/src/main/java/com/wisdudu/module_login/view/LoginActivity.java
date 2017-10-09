package com.wisdudu.module_login.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.wisdudu.lib_common.base.BaseActivity;
import com.wisdudu.module_login.R;
import com.wisdudu.module_login.databinding.LoginActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.login_activity_login);
        LoginViewModel viewModel = new LoginViewModel(this, binding);
        binding.setViewModel(viewModel);
    }
}
