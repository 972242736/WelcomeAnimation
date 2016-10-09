package com.mmf.welcompage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    private ViewPager vpWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpWelcome = (ViewPager)findViewById(R.id.vp_welcome);
        WelcomePagerTransformer welcomePagerTransformer = new WelcomePagerTransformer();
        welcomePagerTransformer.setEnterTest(new WelcomePagerTransformer.EnterListener() {
            @Override
            public void enter() {
                finish();
            }
        });
        vpWelcome.setPageTransformer(true,welcomePagerTransformer);
        vpWelcome .setAdapter(new WelcomePageAdapter(getSupportFragmentManager()));
    }

    private int[] layouts = {
            R.layout.fragment1,
            R.layout.fragment2,
            R.layout.fragment3
    };
    class  WelcomePageAdapter extends FragmentPagerAdapter{

        public WelcomePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new TranslateFragment();
            Bundle bundle =new Bundle();
            bundle.putInt("layoutId",layouts[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
