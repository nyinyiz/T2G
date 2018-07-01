package com.nwt.recyglo_shop.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.NewsVO;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;

public class NewsDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_des)
    TextView tvDes;

    public static NewsVO mNewsVO;

    public static Intent getIntent(Context context, NewsVO newsVO) {
        mNewsVO = newsVO;
        return new Intent(context,NewsDetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvTitle.setText(mNewsVO.title);
        tvDes.setText(mNewsVO.des);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_news_detail;
    }
}
