package com.example.heshammostafa.gategores;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener,
        View.OnClickListener {

    protected View view;

    private ImageButton btnNext, btnFinish;

    private ViewPager viewPager;

    private LinearLayout linearLayout;
    int dotsCount;
    ImageView[] dots;
    ViewPagerAdapter mAdapter;

    private String[] mImageResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageResources = new String[]{
                "https://www.planwallpaper.com/static/images/latest.jpg",
                "https://www.planwallpaper.com/static/images/Light-Wood-Background-Wallpaper.jpg",
                "https://www.planwallpaper.com/static/images/maxresdefault.jpg",
                "https://www.planwallpaper.com/static/images/old-paper-floral-parchment-background-texture_wunZAKZ.jpg",
                "https://www.planwallpaper.com/static/images/recycled_texture_background.jpg",
                "https://www.planwallpaper.com/static/images/background-pattern-design-41.jpg",
                "https://www.planwallpaper.com/static/images/background-pattern-design-65_u4rxk5B.jpg",
                "https://www.planwallpaper.com/static/images/background-pattern-design-86.jpg",
                "https://www.planwallpaper.com/static/images/bg1.jpg",
                "https://www.planwallpaper.com/static/images/creative-web-designs-background1.jpg",
                "https://www.planwallpaper.com/static/images/design-background-wallpaper-i16.jpg"
        };

        viewPager = (ViewPager) findViewById(R.id.pager_introduction);
        btnNext = (ImageButton) findViewById(R.id.btn_next);
        btnFinish = (ImageButton) findViewById(R.id.btn_finish);

        linearLayout = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        btnNext.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

        mAdapter = new ViewPagerAdapter(MainActivity.this, mImageResources);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {
        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            linearLayout.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.zoom_out:
                viewPager.setPageTransformer(true, new ZoomOut());
                break;
            case R.id.depth_page:
                viewPager.setPageTransformer(true, new depth_page());
                break;
            case R.id.rotation_page:
                viewPager.setPageTransformer(true, new Rotation());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {
            btnNext.setVisibility(View.GONE);
            btnFinish.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnFinish.setVisibility(View.GONE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                viewPager.setCurrentItem((viewPager.getCurrentItem() < dotsCount)
                        ? viewPager.getCurrentItem() + 1 : 0);
                break;

            case R.id.btn_finish:
                finish();
                break;
        }

    }
}
