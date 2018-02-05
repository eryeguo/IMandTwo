package pingan.com.imandtwo.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigamole.library.navigationtabstrip.NavigationTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pingan.com.imandtwo.R;
import pingan.com.imandtwo.fragments.newsfragments.OneFragment;
import pingan.com.imandtwo.fragments.newsfragments.ThreenFragment;
import pingan.com.imandtwo.fragments.newsfragments.TwoFragment;

/**
 * Created by xsj on 2018/2/1.
 * 这是首页
 */

public class NewsFragment extends Fragment {

    @BindView(R.id.nts)
    NavigationTabStrip navigationTabStrip;
    @BindView(R.id.viewpager)
    ViewPager vp;
    Unbinder unbinder;

    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] str = new String[]{"Nav","TAB","Strip"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfragment, container, false);

        //黄油刀
        unbinder = ButterKnife.bind(this, view);

        //顶部导航栏
        inittab();

        return view;
    }

    //tableLayout
    private void inittab() {

        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreenFragment());

        //适配器
        vp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                //当选中的位置是对应的索引值的话 就加载那个Fragment
                switch (position) {
                    case 0:
                        fragment=fragmentList.get(0);
                        break;
                    case 1:
                        fragment=fragmentList.get(1);
                        break;
                    case 2:
                        fragment=fragmentList.get(2);
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationTabStrip.setTabIndex(position, false);
                navigationTabStrip.setAnimationDuration(300);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navigationTabStrip.setTitles(str);
        navigationTabStrip.setTabIndex(0, true);
        navigationTabStrip.setTitleSize(15);
        navigationTabStrip.setStripColor(getResources().getColor(R.color.colorAll));
        navigationTabStrip.setStripFactor(2);
        navigationTabStrip.setStripType(NavigationTabStrip.StripType.POINT);
        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
        navigationTabStrip.setTypeface("fonts/typeface.ttf");
        navigationTabStrip.setCornersRadius(3);
        navigationTabStrip.setAnimationDuration(300);
        navigationTabStrip.setInactiveColor(Color.GRAY);
        navigationTabStrip.setActiveColor(Color.RED);
        navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                vp.setCurrentItem(index);
            }

            @Override
            public void onEndTabSelected(String title, int index) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
