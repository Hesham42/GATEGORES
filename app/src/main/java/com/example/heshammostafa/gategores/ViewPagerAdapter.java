package com.example.heshammostafa.gategores;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;


/**
 * Created by Hesham Mostafa on 7/5/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mcContext;
    private String[]mImageID;
    private LayoutInflater mInflater;

    public ViewPagerAdapter(Context mcContext, String[] mImageID) {
        this.mcContext = mcContext;
        this.mImageID = mImageID;
    }

    @Override
    public int getCount() {
        return mImageID.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageFashion;
        View itemView = LayoutInflater.from(mcContext).inflate(R.layout.pager_item, container, false);

//        locate the Image View in Viewpager
        imageFashion= itemView.findViewById(R.id.img_pager_item);

//        picasso.with(mcContext).load("file:///android_asset/DvpvklR.png").into(imageFashion);
        Picasso.with(mcContext).load(mImageID[position]).into(imageFashion);
//        imageFashion.setImageResource(mImageID[position]);

        container.addView(itemView);
        return itemView;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
