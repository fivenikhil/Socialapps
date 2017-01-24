package com.lazycrazyinc.socialapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.lazycrazyinc.socialapps.social.SocialActivity;
import com.lazycrazyinc.socialapps.social.TopicsListFragment;

public class Dashboard extends AppCompatActivity {

    ImageView imHeader;
    MaterialViewPager mViewPager;
    PagerSlidingTabStrip tabs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = ((MaterialViewPager)findViewById(R.id.materialViewPager));
        imHeader = ((ImageView)findViewById(R.id.imHeader));
        toolbar = mViewPager.getToolbar();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(false);
                actionBar.setDisplayShowHomeEnabled(false);
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(false);
            }
        }

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Intent i = new Intent(getApplicationContext(), SocialActivity.class);
                startActivity(i);

            }
        });*/

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    default:
                        return null;
                    case 0:
                        return TopicsListFragment.newInstance();
                }
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position)
                {
                    default:
                        return "";
                    case 0:
                        return "Categories";
                }
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener()
        {
            public HeaderDesign getHeaderDesign(int position) {
                switch (position) {
                    default:
                        return null;

                    case 0:

                        return HeaderDesign.fromColorAndDrawable(getResources().getColor(R.color.colorPrimaryDark), getResources().getDrawable(R.drawable.books));

                }

            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(2);
        tabs = mViewPager.getPagerTitleStrip();
        tabs.setShouldExpand(true);
        tabs.setViewPager(mViewPager.getViewPager());
        tabs.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
