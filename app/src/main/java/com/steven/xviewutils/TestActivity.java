package com.steven.xviewutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author 86569
 *
 * 测试Fragment
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TestFragment testFragment = TestFragment.newInstance("测试fragment绑定");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container,testFragment)
                .commitAllowingStateLoss();
    }
}
