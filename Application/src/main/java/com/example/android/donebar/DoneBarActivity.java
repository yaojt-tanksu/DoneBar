package com.example.android.donebar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * desc:完成和取消按钮页面
 * <p>
 * author:kuyu.yaojt (tanksu)
 * <p>
 * email:yaojt@kuyumall.com
 * <p>
 * date:17/3/12
 */

public class DoneBarActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 首先在actionbar里头加载自定义的确定和取消的布局
        final LayoutInflater inflater = (LayoutInflater) getActionBar().getThemedContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        final View customActionBarView = inflater.inflate(
                R.layout.actionbar_custom_view_done_cancel, null);
        customActionBarView.findViewById(R.id.actionbar_done).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 用户点击完成按钮
                        finish();
                    }
                });
        customActionBarView.findViewById(R.id.actionbar_cancel).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 用户点击了取消按钮
                        finish();
                    }
                });

        final ActionBar actionBar = getActionBar();
        // 设置actionbar，并且隐藏返回按钮和title
        actionBar.setDisplayOptions(
                ActionBar.DISPLAY_SHOW_CUSTOM,
                ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
                        | ActionBar.DISPLAY_SHOW_TITLE);
        // actionbar设置自定义的布局和布局参数
        actionBar.setCustomView(customActionBarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        // 最后加载自己的布局
        setContentView(R.layout.activity_done_bar);
    }

}
