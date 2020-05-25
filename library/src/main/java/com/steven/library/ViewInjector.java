package com.steven.library;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Copyright (C)
 * <p>
 * FileName: ViewInjector
 *
 * @author Steven.zhao
 */
public interface ViewInjector {

    /**
     * 注入 activity
     * @param activity 注入 activity
     */
    void inject(Activity activity);
    /**
     * 注入 fragment
     * @param fragment 注入 fragment
     */
    void inject(Fragment fragment);

    /**
     * 注入 view
     * @param view 注入 view
     */
    void inject(View view);
}
