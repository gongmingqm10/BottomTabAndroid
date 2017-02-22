# BottomTabAndroid

Android 底部栏组件。主要为了仿制 Android 底部栏组件效果。按照 Material Design 的设计标准，官方推荐使用抽屉栏效果，但是目前还是存在很多应用使用和 iOS 一套的设计标准。即仍然使用传统的底部栏操作交互。

效果如如下：

![Demo](https://raw.githubusercontent.com/gongmingqm10/BottomTabAndroid/master/arts/bintray_demo.png =200x)


## 用法

由于此组件同时依赖于 appcompt-v7 库，所以请同时添加 appcompt-v7：

```
compile 'com.android.support:appcompat-v7:23.3.0'
compile 'net.gongmingqm10.uikit:bottomtab:0.2.0'
```

引入后，请直接在 MainActivity 中配置如下：

```
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
```

其中 DemoFragment 主要展示 BottomTab 对应的不同模块内容区域。DemoFragment 需要继承自 anroid.support.v4.app.Fragment。

```
class DemoFragment extends android.support.v4.app.Fragment {
    ...
}
```

## API

为了适应多样化的需求，你需要知道如下 API。

**BottomTabItem.setLabel(String label)**：设置 BottomTabItem 的描述文字；

**BottomTabItem.setIcon(int iconResId)**：设置 BottomTabItem 的图标，一般是 PNG 格式，选中状态图标默认使用 selectedColor 自动渲染，除非进行特殊指定；

**BottomTabItem.setNormalColor(int normalColorResId)**：设置 BottomTabItem文字以及图标未选中状态下的颜色；

**BottomTabItem.setSelectedColor(int selectedColorResId)**：设置 BottomTabItem文字以及图标选中状态下的颜色；

**BottomTabItem.setSelectedIcon(int selectedIconResId)**：设置 BottomTabItem 选中状态的图标。如果图标选中和未选中状态样式(除颜色之外)不一致，则需要特殊指定图标，否则使用选中颜色默认渲染；

**BottomTabLayout.setCurrentPosition(int position)**：设置底部操作栏初始选中位置；


## LICENSE

```
Copyright 2017 gongmingqm10

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```