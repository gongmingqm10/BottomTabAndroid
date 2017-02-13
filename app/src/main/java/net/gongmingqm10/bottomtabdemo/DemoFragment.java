package net.gongmingqm10.bottomtabdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoFragment extends Fragment {

    private static final String ARG_MESSAGE = "message";

    public static Fragment newInstance(String message) {
        Fragment fragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_MESSAGE, message);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String message = getArguments().getString(ARG_MESSAGE);
        TextView textView = (TextView) view.findViewById(R.id.page_info);

        textView.setText(message);
    }
}
