package com.nwt.recyglo_shop.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.delegate.NotificationDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.OnClick;

public class NotificationViewHolder extends BaseViewHolder<NotificationVO> {

    @BindView(R.id.tv_title)
    MMTextView tvTitle;
    @BindView(R.id.btn_accept)
    TextView btnAccept;
    @BindView(R.id.btn_reject)
    TextView btnReject;

    private NotificationDelegate mDelegate;

    public NotificationViewHolder(View itemView, NotificationDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
    }

    @Override
    public void bind(Context context) {
        tvTitle.setText(mData.notification_title);
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.btn_accept)
    void onTapBtnAccept() {
        mDelegate.onTapAccept(mData);
    }

    @OnClick(R.id.btn_reject)
    void onTapBtnReject() {
        mDelegate.onTapReject(mData);
    }

}
