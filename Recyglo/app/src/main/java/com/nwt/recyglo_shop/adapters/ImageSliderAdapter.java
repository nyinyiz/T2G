package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nwt.recyglo_shop.R;

import java.util.List;

/**
 * Created by nyi on 11/8/2017.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private List<String> images;
    private LayoutInflater inflater;

    public ImageSliderAdapter(Context context) {
        this.context = context;
//        this.images=images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View myImageLayout = inflater.inflate(R.layout.pager_item, container, false);
        ImageView myImage = myImageLayout
                .findViewById(R.id.imageView);

        Glide.with(context)
                .load(R.drawable.first_page)
//                .placeholder(R.drawable.logo_place_holder)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(myImage);

        container.addView(myImageLayout, 0);
        return myImageLayout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
