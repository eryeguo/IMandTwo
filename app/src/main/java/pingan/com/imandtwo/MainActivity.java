package pingan.com.imandtwo;

import android.graphics.Color;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import pingan.com.imandtwo.fragments.AddressbookFragment;
import pingan.com.imandtwo.fragments.MineFragment;
import pingan.com.imandtwo.fragments.NewsFragment;
import pingan.com.imandtwo.fragments.ScienceFragment;
import pingan.com.imandtwo.utils.BaseActivity;


public class MainActivity extends BaseActivity {

    private BottomTabBar mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mb =(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(40,40)
                .setFontSize(10)
                .setTabPadding(4,6,10)
                .setChangeColor(getResources().getColor(R.color.colorAll),Color.DKGRAY)
                .addTabItem("资讯",R.mipmap.form, NewsFragment.class)
                .addTabItem("科技圈",R.mipmap.calendar, ScienceFragment.class)
                .addTabItem("通讯录",R.mipmap.comments, AddressbookFragment.class)
                .addTabItem("我的",R.mipmap.account, MineFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
