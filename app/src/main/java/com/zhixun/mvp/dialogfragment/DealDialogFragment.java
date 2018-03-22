package com.zhixun.mvp.dialogfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * 交易确认底部弹窗
 * Created by Administrator on 2018/3/21.
 */

public class DealDialogFragment extends BaseDialogFragment {
    private List<Fragment> fragmentList = new ArrayList<>();
    private CustomViewpagerAdapter customViewpagerAdapter;



    @Override
    protected void attachView() {

    }

    public int getLayoutResId() {
        return R.layout.dialogframent_deal;
    }


    protected void initView(View dialog) {
        ViewPager viewPagerff = dialog.findViewById(R.id.view_pager);
        fragmentList.add(new BottomFragment1());
        fragmentList.add(new BottomFragment2());
        customViewpagerAdapter = new CustomViewpagerAdapter(getChildFragmentManager(),fragmentList);
        viewPagerff.setAdapter(customViewpagerAdapter);
        viewPagerff.setCurrentItem(0);
    }

//    @OnClick({R.id.rl_use_coupon, R.id.rl_pay_method, R.id.left_image})
//    public void onViewClicked(View view) {
//        Animation slide_left_to_left = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_left);
//        Animation slide_right_to_left = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_to_left);
//        Animation slide_left_to_left_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_left_in);
//        Animation slide_left_to_right = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_right);
//        switch (view.getId()) {
//            case R.id.rl_use_coupon:
//                //使用抵扣卷
//                break;
//            case R.id.rl_pay_method:
//                //选择付款方式
//                break;
//            case R.id.left_image:
//                //余额界面返回
//                break;
//        }
//    }


    public class CustomViewpagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        public CustomViewpagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
            super(fragmentManager);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

}
