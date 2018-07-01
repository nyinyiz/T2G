package com.nwt.recyglo_shop.fragments.junkshop;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.activities.NewsDetailActivity;
import com.nwt.recyglo_shop.adapters.NewsRecyclerAdapter;
import com.nwt.recyglo_shop.components.rvset.SmartRecyclerView;
import com.nwt.recyglo_shop.data.vos.NewsVO;
import com.nwt.recyglo_shop.delegate.NewsDelegate;
import com.nwt.recyglo_shop.fragments.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class NewsFragment extends BaseFragment implements NewsDelegate {
    @BindView(R.id.rv_view)
    SmartRecyclerView rvView;

    private Context context;
    private NewsRecyclerAdapter mAdapter;

    public NewsFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        ButterKnife.bind(this,view);

        setUpRecyclerView();

        return view;
    }

    private void setUpRecyclerView() {
        mAdapter = new NewsRecyclerAdapter(context,this);
        rvView.setLayoutManager(new LinearLayoutManager(context));
        rvView.setAdapter(mAdapter);

        getAppModel().getNews().observe(this, newsVOS -> mAdapter.setNewData(newsVOS));
    }

    @Override
    public void onTapNewsItem(NewsVO newsVO) {
        getContext().startActivity(NewsDetailActivity.getIntent(getContext(),newsVO));
    }
}
