package com.steven.xviewutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.steven.library.OnClick;
import com.steven.library.ViewInject;
import com.steven.library.XViewUtils;

/**
 * @author steven.zhao
 * 主界面
 */
public class MainActivity extends Activity {

    @ViewInject(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注入界面
        XViewUtils.instance().inject(this);

        tvTitle.setText("hello world");
    }

    @OnClick({R.id.btn_fragemt,R.id.btn_view})
    public void onFragmentClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_fragemt:
                startActivity(new Intent(this,TestActivity.class));
                break;
            case R.id.btn_view:
                startActivity(new Intent(this,NavActivity.class));
                break;
            default:
                break;
        }

    }
}
