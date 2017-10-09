package com.wisdudu.module_login.databinding;
import com.wisdudu.module_login.R;
import com.wisdudu.module_login.BR;
import android.view.View;
public class LoginActivityLoginBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.widget.Button loginButton;
    public final android.widget.EditText loginEdittext;
    public final android.widget.EditText loginEdittext2;
    public final android.widget.ProgressBar loginProgressbar4;
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    private com.wisdudu.module_login.view.LoginViewModel mViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener loginEdittextandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.phone.get()
            //         is viewModel.phone.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(loginEdittext);
            // localize variables for thread safety
            // viewModel.phone != null
            boolean viewModelPhoneJavaLangObjectNull = false;
            // viewModel
            com.wisdudu.module_login.view.LoginViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.phone
            android.databinding.ObservableField<java.lang.String> viewModelPhone = null;
            // viewModel.phone.get()
            java.lang.String viewModelPhoneGet = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPhone = viewModel.phone;

                viewModelPhoneJavaLangObjectNull = (viewModelPhone) != (null);
                if (viewModelPhoneJavaLangObjectNull) {




                    viewModelPhone.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener loginEdittext2androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.password.get()
            //         is viewModel.password.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(loginEdittext2);
            // localize variables for thread safety
            // viewModel.password != null
            boolean viewModelPasswordJavaLangObjectNull = false;
            // viewModel.password.get()
            java.lang.String viewModelPasswordGet = null;
            // viewModel
            com.wisdudu.module_login.view.LoginViewModel viewModel = mViewModel;
            // viewModel.password
            android.databinding.ObservableField<java.lang.String> viewModelPassword = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPassword = viewModel.password;

                viewModelPasswordJavaLangObjectNull = (viewModelPassword) != (null);
                if (viewModelPasswordJavaLangObjectNull) {




                    viewModelPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public LoginActivityLoginBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.loginButton = (android.widget.Button) bindings[3];
        this.loginButton.setTag(null);
        this.loginEdittext = (android.widget.EditText) bindings[1];
        this.loginEdittext.setTag(null);
        this.loginEdittext2 = (android.widget.EditText) bindings[2];
        this.loginEdittext2.setTag(null);
        this.loginProgressbar4 = (android.widget.ProgressBar) bindings[4];
        this.loginProgressbar4.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.viewModel :
                setViewModel((com.wisdudu.module_login.view.LoginViewModel) variable);
                return true;
        }
        return false;
    }

    public void setViewModel(com.wisdudu.module_login.view.LoginViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    public com.wisdudu.module_login.view.LoginViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelPhone((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelViewStyleIsShowProgress((android.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeViewModelPassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelPhone(android.databinding.ObservableField<java.lang.String> ViewModelPhone, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeViewModelViewStyleIsShowProgress(android.databinding.ObservableField<java.lang.Boolean> ViewModelViewStyleIsShowProgress, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeViewModelPassword(android.databinding.ObservableField<java.lang.String> ViewModelPassword, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int viewModelViewStyleIsShowProgressViewVISIBLEViewGONE = 0;
        java.lang.String viewModelPhoneGet = null;
        boolean androidDatabindingDynamicUtilSafeUnboxViewModelViewStyleIsShowProgressGet = false;
        android.databinding.ObservableField<java.lang.String> viewModelPhone = null;
        android.databinding.ObservableField<java.lang.Boolean> viewModelViewStyleIsShowProgress = null;
        com.wisdudu.module_login.view.LoginViewModel.ViewStyle viewModelViewStyle = null;
        com.kelin.mvvmlight.command.ReplyCommand viewModelLoginCommand = null;
        java.lang.Boolean viewModelViewStyleIsShowProgressGet = null;
        android.databinding.ObservableField<java.lang.String> viewModelPassword = null;
        java.lang.String viewModelPasswordGet = null;
        com.wisdudu.module_login.view.LoginViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.phone
                        viewModelPhone = viewModel.phone;
                    }
                    updateRegistration(0, viewModelPhone);


                    if (viewModelPhone != null) {
                        // read viewModel.phone.get()
                        viewModelPhoneGet = viewModelPhone.get();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.viewStyle
                        viewModelViewStyle = viewModel.viewStyle;
                    }


                    if (viewModelViewStyle != null) {
                        // read viewModel.viewStyle.isShowProgress
                        viewModelViewStyleIsShowProgress = viewModelViewStyle.isShowProgress;
                    }
                    updateRegistration(1, viewModelViewStyleIsShowProgress);


                    if (viewModelViewStyleIsShowProgress != null) {
                        // read viewModel.viewStyle.isShowProgress.get()
                        viewModelViewStyleIsShowProgressGet = viewModelViewStyleIsShowProgress.get();
                    }


                    // read android.databinding.DynamicUtil.safeUnbox(viewModel.viewStyle.isShowProgress.get())
                    androidDatabindingDynamicUtilSafeUnboxViewModelViewStyleIsShowProgressGet = android.databinding.DynamicUtil.safeUnbox(viewModelViewStyleIsShowProgressGet);
                if((dirtyFlags & 0x1aL) != 0) {
                    if(androidDatabindingDynamicUtilSafeUnboxViewModelViewStyleIsShowProgressGet) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read android.databinding.DynamicUtil.safeUnbox(viewModel.viewStyle.isShowProgress.get()) ? View.VISIBLE : View.GONE
                    viewModelViewStyleIsShowProgressViewVISIBLEViewGONE = ((androidDatabindingDynamicUtilSafeUnboxViewModelViewStyleIsShowProgressGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x18L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.loginCommand
                        viewModelLoginCommand = viewModel.loginCommand;
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.password
                        viewModelPassword = viewModel.password;
                    }
                    updateRegistration(2, viewModelPassword);


                    if (viewModelPassword != null) {
                        // read viewModel.password.get()
                        viewModelPasswordGet = viewModelPassword.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            com.kelin.mvvmlight.bindingadapter.view.ViewBindingAdapter.clickCommand(this.loginButton, viewModelLoginCommand);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.loginEdittext, viewModelPhoneGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.loginEdittext, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, loginEdittextandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.loginEdittext2, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, loginEdittext2androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.loginEdittext2, viewModelPasswordGet);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.loginProgressbar4.setVisibility(viewModelViewStyleIsShowProgressViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<LoginActivityLoginBinding>inflate(inflater, com.wisdudu.module_login.R.layout.login_activity_login, root, attachToRoot, bindingComponent);
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wisdudu.module_login.R.layout.login_activity_login, null, false), bindingComponent);
    }
    public static LoginActivityLoginBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static LoginActivityLoginBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/login_activity_login_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new LoginActivityLoginBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.phone
        flag 1 (0x2L): viewModel.viewStyle.isShowProgress
        flag 2 (0x3L): viewModel.password
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
        flag 5 (0x6L): android.databinding.DynamicUtil.safeUnbox(viewModel.viewStyle.isShowProgress.get()) ? View.VISIBLE : View.GONE
        flag 6 (0x7L): android.databinding.DynamicUtil.safeUnbox(viewModel.viewStyle.isShowProgress.get()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}