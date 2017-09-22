package com.example.heshammostafa.gategores;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Hesham Mostafa on 7/5/2017.
 */

class ZoomOut implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View v, float position) {
        int pageWidth = v.getWidth();
        int pageHight=v.getHeight();

        if (position<-1)
        {
//            (infintity,-1) this way of screen to the left
            v.setAlpha(0);
        }
        else if (position<=1)
        {
//            (-1,1) modify the default slide transition to shrink the page as well

            float ScaleFactor =Math.max(MIN_SCALE,1-Math.abs(position));
            float vertMargin=pageHight*(1-ScaleFactor)/2;
            float horzMargin=pageWidth*(1-ScaleFactor)/2;
            if (position<0)
            {
                v.setTranslationX(horzMargin-vertMargin/2);
            }else
                {
                    v.setTranslationX(-horzMargin-vertMargin/2);
                }

//        scale the page down (between Min_scale and 1)
            v.setScaleX(ScaleFactor);
            v.setScaleY(ScaleFactor);
//            float the page relative to it's size
            v.setAlpha((MIN_ALPHA+ScaleFactor-MIN_SCALE)
                    / (1-MIN_SCALE)*(1-MIN_ALPHA));
        }else
            {
//                (1,+infinty)
//                rhis page is way off screen to the right
                v.setAlpha(0);
            }




    }
}
