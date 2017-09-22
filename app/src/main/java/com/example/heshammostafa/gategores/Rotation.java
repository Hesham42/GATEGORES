package com.example.heshammostafa.gategores;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Hesham Mostafa on 7/5/2017.
 */

class Rotation implements ViewPager.PageTransformer {

    private int degrees = 150;
    private float centerFactor = (float) Math.tan(Math.toRadians(degrees / 2)) / 2;


    @Override
    public void transformPage(View v, float position) {
        int pageWidth = v.getWidth();
        int pageHight=v.getHeight();
        v.setPivotX((float)pageWidth/2);

        v.setPivotY(pageHight+pageWidth*centerFactor);

        if (position<-1)
        {
//            (-infinty,1)
//            off to the left by alot
            v.setRotation(0);
            v.setAlpha(0);

        }
       else if (position<=1)
        {
            v.setTranslationX((-position)*pageWidth);
            v.setRotation(position*(180-degrees));//rotate it
//            fade the page relative to it's distanve from the center
            float minAlpha=0.7f;
            v.setAlpha(Math.max(minAlpha,1-Math.abs(pageHight)/3));
        }
           else {
//                [1,+infinty]
                v.setRotation(0);
                v.setAlpha(0);
            }
    }
}
// else if (position<=1)
//        {
//            [1,1]
//                v.setRotation(0);//shift the View over
//                v.setAlpha(0);
//                }