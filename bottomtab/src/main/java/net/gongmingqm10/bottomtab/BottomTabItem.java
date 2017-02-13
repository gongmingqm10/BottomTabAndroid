package net.gongmingqm10.bottomtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BottomTabItem extends RelativeLayout {

    private ImageView iconImage;
    private TextView labelText;

    private int color;
    private int selectedColor;
    private Drawable iconDrawable;
    private Drawable selectedIconDrawable;
    private String label;
    private boolean selected;

    public BottomTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomTabItem);
        color = typedArray.getColor(R.styleable.BottomTabItem_normalColor, 0);
        selectedColor = typedArray.getColor(R.styleable.BottomTabItem_selectedColor, 0);
        iconDrawable = typedArray.getDrawable(R.styleable.BottomTabItem_normalIcon);
        selectedIconDrawable = typedArray.getDrawable(R.styleable.BottomTabItem_selectedIcon);
        label = typedArray.getString(R.styleable.BottomTabItem_normalText);
        typedArray.recycle();

        updateView();
    }

    public BottomTabItem(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.bottom_tab_item, this, true);
        iconImage = (ImageView) findViewById(R.id.tab_icon);
        labelText = (TextView) findViewById(R.id.tab_label);
    }

    public void updateView() {
        labelText.setText(label);

        if (selected) {
            labelText.setTextColor(selectedColor);
            iconImage.setImageDrawable(selectedIconDrawable == null ? iconDrawable : selectedIconDrawable);
        } else {
            labelText.setTextColor(color);
            iconImage.setImageDrawable(iconDrawable);
        }

        iconImage.setColorFilter(selected ? selectedColor : color);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;

        updateView();
    }

    public boolean isSelected() {
        return selected;
    }

    public static class Builder {
        private BottomTabItem tabItem;
        private Context context;
        public Builder(Context context) {
            this.context = context;
            this.tabItem = new BottomTabItem(context);
        }

        public Builder setNormalColor(int colorResId) {
            tabItem.color = ContextCompat.getColor(context, colorResId);
            return this;
        }

        public Builder setSelectedColor(int selectedColorResId) {
            tabItem.selectedColor = ContextCompat.getColor(context, selectedColorResId);
            return this;
        }

        public Builder setLabel(int labelResId) {
            tabItem.label = context.getString(labelResId);
            return this;
        }

        public Builder setIcon(int iconResId) {
            tabItem.iconDrawable = ContextCompat.getDrawable(context, iconResId);
            return this;
        }

        public Builder setSelectedIcon(int selectedIconResId) {
            tabItem.selectedIconDrawable = ContextCompat.getDrawable(context, selectedIconResId);
            return this;
        }

        public BottomTabItem build() {
            tabItem.updateView();
            return tabItem;
        }

    }
}
