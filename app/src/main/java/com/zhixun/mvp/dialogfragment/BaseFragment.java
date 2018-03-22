package com.zhixun.mvp.dialogfragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import java.util.regex.Pattern;
/**
 * Created by Administrator on 2016/11/15.
 */

public abstract class BaseFragment extends Fragment {

    protected View parentView;
    protected FragmentActivity activity;
    protected LayoutInflater inflater;
    protected Context mContext;


//    protected GifLoadingView mGifLoadingView;


    // protected DengchuDialog checkUserDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        mContext = activity;
        this.inflater = inflater;

        /** 预防 点击击穿，实现下面的fragment的点击事件*/
        parentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        return parentView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachView();
        configViews();
        initDatas();

        // checkUserDialog = new DengchuDialog(getActivity(), "提示 “您的账号在其他设备上登录成功。如果不是您的操作，您的密码可能泄露。请尽快修改密码。”", "重新登陆");
    }


    public abstract void attachView();
    @LayoutRes
    public abstract int getLayoutResId();
    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();
    public abstract void initDatas();



    public FragmentActivity getSupportActivity() {
        return (FragmentActivity) super.getActivity();
    }

    public Context getApplicationContext() {
        return this.activity == null ? (getActivity() == null ? null : getActivity()
                .getApplicationContext()) : this.activity.getApplicationContext();
    }






    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }


    public boolean matchPhone(String text) {
        if (Pattern.compile("(\\d{11})|(\\+\\d{3,})").matcher(text).matches()) {
            return true;
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        //MobclickAgent.onPageStart("MainScreen"); //统计页面，"MainScreen"为页面名称，可自定义
    }
    public void onPause() {
        super.onPause();
        //MobclickAgent.onPageEnd("MainScreen");
    }

    protected void showUserDialog() {
        // TODO Auto-generated method stub
       /* if (checkUserDialog != null)
            if (!checkUserDialog.isShowing())
                checkUserDialog.show();*/

    }
}
