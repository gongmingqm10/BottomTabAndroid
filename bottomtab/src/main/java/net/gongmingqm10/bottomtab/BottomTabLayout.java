package net.gongmingqm10.bottomtab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class BottomTabLayout extends RelativeLayout {

    private LinearLayout tabContainer;
    private ViewPager tabViewPager;
    private List<BottomTabItem> tabItems;
    private List<Fragment> tabFragments;

    private TabFragmentAdapter tabFragmentAdapter;


    public BottomTabLayout(Context context) {
        super(context);
        init();
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        tabItems = new ArrayList<>();
        tabFragments = new ArrayList<>();

        LayoutInflater.from(getContext()).inflate(R.layout.bottom_tab, this, true);
        tabContainer = (LinearLayout) findViewById(R.id.tab_container);
        tabViewPager = (ViewPager) findViewById(R.id.tab_view_pager);

        if (getContext() instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            tabFragmentAdapter = new TabFragmentAdapter(fragmentActivity.getSupportFragmentManager());
            tabViewPager.setAdapter(tabFragmentAdapter);
            tabViewPager.addOnPageChangeListener(onPageChangeListener);
        } else {
            throw new RuntimeException("The host activity should be an instance of FragmentActivity");
        }
    }

    public BottomTabLayout addNewTab(@NonNull BottomTabItem tabItem, @NonNull Fragment fragment) {
        if (tabItems.size() == 0) {
            tabItem.setSelected(true);
        }

        tabItems.add(tabItem);
        int position = tabItems.indexOf(tabItem);
        tabItem.setOnClickListener(new TabItemClickListener(position));

        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.MATCH_PARENT);
        itemParams.weight = 1;
        tabContainer.addView(tabItem, itemParams);

        tabFragments.add(fragment);
        tabFragmentAdapter.notifyDataSetChanged();

        return this;
    }

    public void setCurrentPosition(int position) {
        tabViewPager.setCurrentItem(position);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            selectTabItem(position);
        }
    };

    private class TabItemClickListener implements OnClickListener {

        private int position;

        TabItemClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            tabViewPager.setCurrentItem(position);
        }
    }

    private void selectTabItem(int position) {
        if (tabItems.get(position).isSelected()) {
            return;
        }
        for (int index = 0; index < tabItems.size(); index++) {
            tabItems.get(index).setSelected(index == position);
        }
    }

    private class TabFragmentAdapter extends FragmentPagerAdapter {

        TabFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabFragments == null ? 0 : tabFragments.size();
        }
    }
}
