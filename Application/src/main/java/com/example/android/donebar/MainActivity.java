package com.example.android.donebar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * 主页面
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private Sample[] mSamples;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 内容提供
        mSamples = new Sample[]{
                new Sample(R.string.donebaractivity_title, R.string.donebaractivity_description,
                        DoneBarActivity.class),
                new Sample(R.string.donebuttonactivity_title, R.string.donebuttonactivity_description,
                        DoneButtonActivity.class),
                new Sample(R.string.donebuttonactivity_title2, R.string.refreshDesc,
                        RefreshActivity.class)
        };

        GridView mGridView = (GridView) findViewById(android.R.id.list);
        mGridView.setAdapter(new SampleAdapter());
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> container, View view, int position, long id) {
        startActivity(mSamples[position].intent);
    }

    /**
     * 适配器
     */
    private class SampleAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mSamples.length;
        }

        @Override
        public Object getItem(int position) {
            return mSamples[position];
        }

        @Override
        public long getItemId(int position) {
            return mSamples[position].hashCode();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.sample_dashboard_item,
                        container, false);
            }

            ((TextView) convertView.findViewById(android.R.id.text1)).setText(
                    mSamples[position].titleResId);
            ((TextView) convertView.findViewById(android.R.id.text2)).setText(
                    mSamples[position].descriptionResId);
            return convertView;
        }
    }

    private class Sample {
        private int titleResId;
        private int descriptionResId;
        /* 启动的意图 */
        private Intent intent;

        /**
         * 构造函数
         *
         * @param titleResId       titleResId
         * @param descriptionResId descriptionResId
         * @param intent           intent
         */
        private Sample(int titleResId, int descriptionResId, Intent intent) {
            this.intent = intent;
            this.titleResId = titleResId;
            this.descriptionResId = descriptionResId;
        }

        /**
         * 构造函数
         *
         * @param titleResId       titleResId
         * @param descriptionResId descriptionResId
         * @param activityClass    activityClass
         */
        private Sample(int titleResId, int descriptionResId,
                       Class<? extends Activity> activityClass) {
            this(titleResId, descriptionResId,
                    new Intent(MainActivity.this, activityClass));
        }
    }

}
