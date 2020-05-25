package com.steven.library;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Copyright (C)
 * <p>
 * FileName: ViewFinder
 *
 * @author: Steven.zhao
 * <p>
 * Date: 2020/5/24 22:25
 * <p>
 * Description: View查找器
 */
public class ViewFinder {
    private View view;
    private Activity activity;
    private Fragment fragment;

    public ViewFinder(View view) {
        this.view = view;
    }

    public ViewFinder(Activity activity) {
        this.activity = activity;
    }

    public ViewFinder(Fragment fragment) {
        this.fragment = fragment;
    }

    public View findViewById(@IdRes int id)
    {
        View v = null;

        if(this.activity!=null)
        {
            v=this.activity.findViewById(id);
        }
        else if(this.fragment!=null)
        {
            if(fragment.getView()!=null) {
                v=this.fragment.getView().findViewById(id);
            }
        }
        else {
            v=view.findViewById(id);
        }
        return v;
    }
}
