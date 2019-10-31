package com.sample.viewpagercarousel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created on 2/24/16.
 * This adapter gets the individual fragment into the carousel view
 */
public class ViewPagerCarouselAdapter extends FragmentStatePagerAdapter {
//    private int[] imageResourceIds;

    ArrayList<ImageModel> imageModelsList;
    public ViewPagerCarouselAdapter(FragmentManager fm, ArrayList<ImageModel> imageModelsList) {
        super(fm);
        this.imageModelsList = imageModelsList;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerCarouselFragment.IMAGE_RESOURCE_ID, imageModelsList.get(position).getImageId());
        ViewPagerCarouselFragment frag = new ViewPagerCarouselFragment();
        frag.setArguments(bundle);

        return frag;
    }

    @Override
    public int getCount() {
        return (imageModelsList == null) ? 0: imageModelsList.size();
    }

}