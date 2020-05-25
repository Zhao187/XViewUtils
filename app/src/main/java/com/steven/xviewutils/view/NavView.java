package com.steven.xviewutils.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.steven.library.OnClick;
import com.steven.library.ViewInject;
import com.steven.library.XViewUtils;
import com.steven.xviewutils.R;

import org.w3c.dom.Text;

/**
 * Copyright (C)
 * <p>
 * FileName: NavView
 *
 * @author: Steven.zhao
 * <p>
 * Date: 2020/5/25 10:09
 * <p>
 * Description: 导航View
 */
public class NavView extends LinearLayout {

    @ViewInject(R.id.tv_title)
    TextView tvTitle;
    @ViewInject(R.id.tv_right_des)
    TextView tvRightDes;

    public NavView(Context context) {
        this(context,null);
    }

    public NavView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NavView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    /**
     * 初始化视图
     */
    private void initView(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.layout_nav, this);

        XViewUtils.instance().inject(view);

        tvTitle.setText("自定义导航栏");
        tvRightDes.setText("分享");
    }

    @OnClick(R.id.tv_back)
    public void onBack(View view)
    {
        ((Activity)getContext()).finish();
    }
}
