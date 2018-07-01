package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.NewsVO;
import com.nwt.recyglo_shop.delegate.NewsDelegate;
import com.nwt.recyglo_shop.viewholder.NewsViewHolder;

public class NewsRecyclerAdapter extends BaseRecyclerAdapter<NewsViewHolder,NewsVO> {

    private NewsDelegate mDelegate;

    public NewsRecyclerAdapter(Context context, NewsDelegate delegate) {
        super(context);
        mDelegate = delegate;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_view_news,parent,false);
        return new NewsViewHolder(view,mDelegate);
    }

}
