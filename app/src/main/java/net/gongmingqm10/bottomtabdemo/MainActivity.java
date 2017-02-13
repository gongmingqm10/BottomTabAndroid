package net.gongmingqm10.bottomtabdemo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.gongmingqm10.bottomtab.BottomTabItem;
import net.gongmingqm10.bottomtab.BottomTabLayout;

public class MainActivity extends AppCompatActivity {

    private BottomTabLayout bottomTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bottomTabLayout = new BottomTabLayout(this);
        setContentView(bottomTabLayout);

        initTabLayout();
    }

    private void initTabLayout() {
        BottomTabItem homeTab = new BottomTabItem.Builder(this)
                .setLabel(R.string.label_home)
                .setIcon(R.mipmap.ic_account_balance_black_36dp)
                .setNormalColor(R.color.tab_color_normal)
                .setSelectedColor(R.color.tab_color_selected)
                .build();
        BottomTabItem starTab = new BottomTabItem.Builder(this)
                .setLabel(R.string.label_singer)
                .setIcon(R.mipmap.ic_account_balance_wallet_black_36dp)
                .setNormalColor(R.color.tab_color_normal)
                .setSelectedColor(R.color.tab_color_selected)
                .build();
        BottomTabItem songTab = new BottomTabItem.Builder(this)
                .setLabel(R.string.label_song)
                .setIcon(R.mipmap.ic_account_box_black_36dp)
                .setNormalColor(R.color.tab_color_normal)
                .setSelectedColor(R.color.tab_color_selected)
                .build();
        BottomTabItem mineTab = new BottomTabItem.Builder(this)
                .setLabel(R.string.label_me)
                .setIcon(R.mipmap.ic_add_shopping_cart_black_36dp)
                .setNormalColor(R.color.tab_color_normal)
                .setSelectedColor(R.color.tab_color_selected)
                .build();
        bottomTabLayout
                .addNewTab(homeTab, DemoFragment.newInstance("Home fragment"))
                .addNewTab(starTab, DemoFragment.newInstance("Star fragment"))
                .addNewTab(songTab, DemoFragment.newInstance("Song fragment"))
                .addNewTab(mineTab, DemoFragment.newInstance("Mine fragment"));
    }

}
