package com.nwt.recyglo_shop.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.NewsVO;
import com.nwt.recyglo_shop.delegate.NewsDelegate;
import com.nwt.recyglo_shop.utils.ISO8601DateParser;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class NewsViewHolder extends BaseViewHolder<NewsVO> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_des)
    TextView tvDes;

    private NewsDelegate mDelegate;

    public NewsViewHolder(View itemView, NewsDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
    }

    @Override
    public void bind(Context context) {
        tvTitle.setText(mData.title);
        tvDate.setText(mData.posted_date);
        tvDes.setText(mData.des);
    }

    @Override
    public void onClick(View view) {
        mDelegate.onTapNewsItem(mData);
    }
}
