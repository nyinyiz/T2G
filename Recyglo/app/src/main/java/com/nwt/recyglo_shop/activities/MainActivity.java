package com.nwt.recyglo_shop.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TextView;

import com.bhargavms.podslider.PodSlider;
import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.adapters.ViewPagerAdapter;
import com.nwt.recyglo_shop.components.dialogs.ProfileDialog;
import com.nwt.recyglo_shop.fragments.junkshop.ItemListFragment;
import com.nwt.recyglo_shop.fragments.junkshop.NewsFragment;
import com.nwt.recyglo_shop.fragments.junkshop.NotificationFragment;
import com.nwt.recyglo_shop.fragments.junkshop.ShopPlaceFragment;

import butterknife.BindView;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends BaseActivity {

    @BindView(R.id.pager)
    ViewPager mPager;
    @BindView(R.id.tv_page_title)
    TextView tvPageTitle;


    public static Intent getIntent(Context context) {
        return new Intent(context,MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addImageToSliderImage();

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.profile_image)
    void onTapProfileImage() {
        ProfileDialog fragment = ProfileDialog.newInstance();
        fragment.show(getSupportFragmentManager(),"profile");
//        fragment.show(getFragmentManager(), "product_album");

    }

    private void addImageToSliderImage() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ItemListFragment(this),"Creating Something");
        adapter.addFragment(new ShopPlaceFragment(this),"A Place For You");
        adapter.addFragment(new NewsFragment(this),"Today News");
        adapter.addFragment(new NotificationFragment(this),"Notification");
        mPager.setAdapter(adapter);

        PodSlider indicator = findViewById(R.id.indicator);
        indicator.setUpWithViewPager(mPager);
        indicator.setNumberOfPods(4);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    tvPageTitle.setText(adapter.getPageTitle(position));
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }

}
