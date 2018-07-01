package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.delegate.NotificationDelegate;
import com.nwt.recyglo_shop.viewholder.NotificationViewHolder;

public class NotificationRecyclerAdapter extends BaseRecyclerAdapter<NotificationViewHolder,NotificationVO> {

    private NotificationDelegate mDelegate;

    public NotificationRecyclerAdapter(Context context, NotificationDelegate delegate) {
        super(context);
        mDelegate = delegate;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_view_notification,parent,false);
        return new NotificationViewHolder(view,mDelegate);
    }

}
