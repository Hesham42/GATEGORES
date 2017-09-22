package com.example.heshammostafa.gategores;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Hesham Mostafa on 7/5/2017.
 */

class depth_page implements ViewPager.PageTransformer {

    private static final float Min_Scale=0.80f;


    @Override
    public void transformPage(View v, float position) {
        int pageWidth=v.getWidth();

        if (position<-1)
        {
//            (infintity,-1) this way of screen to the left
            v.setAlpha(0);
        }
        else if (position<=0)
        {
//            (-1,0) modify the default slide transition to shrink the page as well

            v.setAlpha(1);
            v.setTranslationX(0);
            v.setScaleX(1);
            v.setScaleY(1);


        }
        else if (position<=1) {
//    fade the page out
        v.setAlpha(1-position);
//            Counteract the default slide Transition
            v.setTranslationX(pageWidth*-position);

//            Scale the page down(Between Min_Scale and 1)
            float ScaleFactor =Min_Scale+(1-Min_Scale)*(1-Math.abs(position));
            v.setScaleX(ScaleFactor);
            v.setScaleY(ScaleFactor);

        }else
            {
//                (1,+infinty)
                v.setAlpha(0);
            }
    }
}



