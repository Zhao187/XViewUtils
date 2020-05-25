package com.steven.xviewutils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.steven.library.OnClick;
import com.steven.library.ViewInject;
import com.steven.library.XViewUtils;

/**
 * Copyright (C)
 * <p>
 * FileName: TestFragment
 *
 * @author: Steven.zhao
 * <p>
 * Date: 2020/5/25 10:23
 * <p>
 * Description: 测试Fragment
 */
public class TestFragment extends Fragment {

    public static TestFragment newInstance(String title)
    {
        TestFragment testFragment = new TestFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        testFragment.setArguments(bundle);

        return testFragment;
    }

    @ViewInject(R.id.tv_fragment_title)
    TextView tvTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        XViewUtils.instance().inject(this);

        final Bundle arguments = getArguments();
        if(arguments!=null)
        {
            final String title = arguments.getString("title");
            tvTitle.setText(title);
        }
    }

    @OnClick(R.id.btn_fragment_refresh)
    public void onRefresh(View view)
    {
        Toast.makeText(getContext(), "点击刷新", Toast.LENGTH_SHORT).show();
    }
}
