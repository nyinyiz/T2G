package com.nwt.recyglo_shop.components;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by nyi on 11/26/2017.
 */

public class SmartScrollListener extends RecyclerView.OnScrollListener {


    public interface OnSmartScrollListener{
        void onListEndReach();
    }

    private int visibleItemCount, pastVisibleItems, totalItemCount;
    private boolean isListEndReached = false;
    private int previousDy, currentDy;/*Dy = Delta Y position*/

    private OnSmartScrollListener mSmartScrollListener;

    public SmartScrollListener(OnSmartScrollListener mSmartScrollListener) {
        this.mSmartScrollListener = mSmartScrollListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        currentDy = dy;
        if (currentDy > previousDy)
        {
            //form top to bottom
        }else if (currentDy< previousDy)
        {
            //from bottom to top
            isListEndReached = false;
        }

        visibleItemCount = recyclerView.getLayoutManager().getChildCount();//visible item count
        totalItemCount = recyclerView.getLayoutManager().getItemCount();//total item count
        pastVisibleItems = ((LinearLayoutManager)recyclerView.getLayoutManager())
                .findFirstVisibleItemPosition();//item count past show item

        previousDy = currentDy;

    }

    /**Will be call after scroll to recyclerView*/
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE)
        {
            if ((visibleItemCount + pastVisibleItems) >= totalItemCount && !isListEndReached)
            {
                isListEndReached = true;
                mSmartScrollListener.onListEndReach();
            }
        }
    }
}
