package com.wisdudu.module_login.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
public abstract class LoginActivityLoginBinding extends ViewDataBinding {
    public final android.widget.Button loginButton;
    public final android.widget.EditText loginEdittext;
    public final android.widget.EditText loginEdittext2;
    public final android.widget.ProgressBar loginProgressbar4;
    // variables
    protected com.wisdudu.module_login.view.LoginViewModel mViewModel;
    protected LoginActivityLoginBinding(android.databinding.DataBindingComponent bindingComponent, android.view.View root_, int localFieldCount
        , android.widget.Button loginButton
        , android.widget.EditText loginEdittext
        , android.widget.EditText loginEdittext2
        , android.widget.ProgressBar loginProgressbar4
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.loginButton = loginButton;
        this.loginEdittext = loginEdittext;
        this.loginEdittext2 = loginEdittext2;
        this.loginProgressbar4 = loginProgressbar4;
    }
    //getters and abstract setters
    public abstract void setViewModel(com.wisdudu.module_login.view.LoginViewModel ViewModel);
    public com.wisdudu.module_login.view.LoginViewModel getViewModel() {
        return mViewModel;
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityLoginBinding bind(android.view.View view) {
        return null;
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    public static LoginActivityLoginBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
}