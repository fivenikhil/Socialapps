package com.lazycrazyinc.socialapps.social;

import android.animation.Animator;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.lazycrazyinc.socialapps.R;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.ViewAnimationUtils;
import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.util.ViewAnimator;


public class Social_Activity extends AppCompatActivity implements ViewAnimator.ViewAnimatorListener
{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private List<SlideMenuItem> list = new ArrayList<>();
    private Social_Fragment contentFragment;
    private ViewAnimator viewAnimator;
    private int res = R.mipmap.ic_launcher;
    private LinearLayout linearLayout, linearLayout2;
   // private String s="start";
    private Fragment fragment;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_new);

        contentFragment = new Social_Fragment();
        bundle = new Bundle();
       // bundle.putInt("imag", R.mipmap.ic_launcher);
        bundle.putString("url","https://en-gb.facebook.com/login/");
        contentFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, contentFragment)
                .commit();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
        //linearLayout2 = (LinearLayout) findViewById(R.id.right_drawer);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // s="start";
               // drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.closeDrawers();

            }
        });

        /*linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  s="end";
               // drawerLayout.closeDrawer(GravityCompat.END);
                drawerLayout.closeDrawers();
            }
        });*/

        setActionBar();
        createMenuList();
       // createList();
        viewAnimator = new ViewAnimator<>(this, list, contentFragment, drawerLayout, this);

        NavigationView rightNavigationView = (NavigationView) findViewById(R.id.nav_right_view);
       // NavigationMenuView navMenuView = (NavigationMenuView) rightNavigationView.getChildAt(0);
       // navMenuView.addItemDecoration(new DividerItemDecoration(Social_Activity.this,DividerItemDecoration.VERTICAL));

        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Right navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_rate)
                {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    myAppLinkToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(myAppLinkToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                        Snackbar snackbar = Snackbar
                                .make(findViewById(R.id.container_frame), "App Not Found", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }

                }

                else if(id ==R.id.nav_share)
                {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    String shareBody = "https://play.google.com/store/apps/details?id="+ getPackageName();
                    sendIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sendIntent, "Share via"));
                }

                else if(id ==R.id.nav_feedback)
                {
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra("android.intent.extra.EMAIL", new String[] {"lazycrazyteam@gmail.com"});
                    intent.putExtra("android.intent.extra.SUBJECT", "Feedback");
                    if (intent.resolveActivity(Social_Activity.this.getPackageManager()) != null)
                    {
                        startActivity(intent);
                    }
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.container_frame), "No Email Client Found", Snackbar.LENGTH_SHORT);

                    snackbar.show();
                }

                else if(id ==R.id.nav_settings)
                {

                }

                else if(id ==R.id.nav_play)
                {
                    String url = "https://play.google.com/store/apps/developer?id=LazyCrazy%20Inc.&hl=en";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }

                else if(id == R.id.nav_about)
                {
                    new MaterialDialog.Builder(Social_Activity.this)
                            .title("About us...")
                            .customView(R.layout.about_us_layout,true)
                            .negativeText("CLOSE").show();
                }

                else if(id ==R.id.nav_exit)
                {
                    finishAffinity();
                }

                drawerLayout.closeDrawer(GravityCompat.END);
                return true;
            }

        });

    }

    private void createMenuList() {
        SlideMenuItem menuItem1 = new SlideMenuItem(Social_Fragment.CLOSE, R.mipmap.icn_close);
        list.add(menuItem1);

        SlideMenuItem menuItem2 = new SlideMenuItem(Social_Fragment.FACE, R.drawable.facebook);
        list.add(menuItem2);
        SlideMenuItem menuItem3 = new SlideMenuItem(Social_Fragment.INST, R.drawable.instagram);
        list.add(menuItem3);

        SlideMenuItem menuItem4 = new SlideMenuItem(Social_Fragment.WHAT, R.drawable.whatsapp);
        list.add(menuItem4);
        SlideMenuItem menuItem5 = new SlideMenuItem(Social_Fragment.SNAP, R.drawable.snapchat);
        list.add(menuItem5);

        SlideMenuItem menuItem6 = new SlideMenuItem(Social_Fragment.TWIT, R.drawable.twitter);
        list.add(menuItem6);
        SlideMenuItem menuItem7 = new SlideMenuItem(Social_Fragment.LINK, R.drawable.linkedin);
        list.add(menuItem7);

        SlideMenuItem menuItem8 = new SlideMenuItem(Social_Fragment.QUORA, R.drawable.quora);
        list.add(menuItem8);
        SlideMenuItem menuItem9 = new SlideMenuItem(Social_Fragment.TUMB, R.drawable.tumblr);
        list.add(menuItem9);

        SlideMenuItem menuItem10 = new SlideMenuItem(Social_Fragment.PINT, R.drawable.pinterest);
        list.add(menuItem10);
        SlideMenuItem menuItem11 = new SlideMenuItem(Social_Fragment.REDD, R.drawable.reddit);
        list.add(menuItem11);

        SlideMenuItem menuItem12 = new SlideMenuItem(Social_Fragment.GPLUS, R.drawable.google_plus);
        list.add(menuItem12);
        SlideMenuItem menuItem13 = new SlideMenuItem(Social_Fragment.YOUT, R.drawable.youtube);
        list.add(menuItem13);

        SlideMenuItem menuItem14 = new SlideMenuItem(Social_Fragment.FLICK, R.drawable.flickr);
        list.add(menuItem14);
        SlideMenuItem menuItem15 = new SlideMenuItem(Social_Fragment.FOUR, R.drawable.foursquare);
        list.add(menuItem15);

        SlideMenuItem menuItem16 = new SlideMenuItem(Social_Fragment.BING, R.drawable.bing);
        list.add(menuItem16);
        SlideMenuItem menuItem17 = new SlideMenuItem(Social_Fragment.BUFF, R.drawable.buffer);
        list.add(menuItem17);
    }

    private void setActionBar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.text));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                linearLayout.removeAllViews();
                linearLayout.invalidate();

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset > 0.6 && linearLayout.getChildCount() == 0)
                    viewAnimator.showMenuContent();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        //drawerToggle.syncState();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
       if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
           drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    private ScreenShotable replaceFragment(ScreenShotable screenShotable, int topPosition)
    {
       // this.res = this.res == R.mipmap.ic_launcher ? R.mipmap.ic_launcher : R.mipmap.ic_launcher ;
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(view, 0, topPosition, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);

        findViewById(R.id.content_overlay).setBackgroundDrawable(new BitmapDrawable(getResources(), screenShotable.getBitmap()));
        animator.start();
        /*Social_Fragment contentFragment = Social_Fragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("url","https://en-gb.facebook.com/login/");
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();*/
        return contentFragment;
    }
        @Override
    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position)
    {
        switch (slideMenuItem.getName())
        {
            case Social_Fragment.CLOSE:
                return screenShotable;

            case Social_Fragment.FACE:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://en-gb.facebook.com/login/");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.INST:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://www.instagram.com/accounts/login/   ");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.WHAT:
                /*contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://play.google.com/store/apps/details?id=com.whatsapp&hl=en");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();*/
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (intent != null) {
                    // We found the activity now start the activity
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    // Bring user to the market or let them choose an app?
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + "com.whatsapp"));
                    startActivity(intent);
                }
                break;

            case Social_Fragment.SNAP:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://accounts.snapchat.com/accounts/login?continue=https%3A%2F%2Faccounts.snapchat.com%2Faccounts%2Fwelcome");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.TWIT:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://twitter.com/login");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.LINK:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://www.linkedin.com/uas/login");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.QUORA:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://www.quora.com/");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.TUMB:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://www.tumblr.com/login");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.PINT:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://in.pinterest.com/login/");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.REDD:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://www.reddit.com/login");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.GPLUS:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://play.google.com/store/apps/details?id=com.google.android.apps.plus&hl=en");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.YOUT:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://play.google.com/store/apps/details?id=com.google.android.youtube&hl=en");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.FLICK:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://www.flickr.com/");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.FOUR:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://foursquare.com/login?continue=%2F&clicked=true");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.BING:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://play.google.com/store/apps/details?id=com.microsoft.bing&hl=en");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

            case Social_Fragment.BUFF:
                contentFragment = new Social_Fragment();
                bundle = new Bundle();
                bundle.putString("url","https://buffer.com/");
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
                break;

        }
        return replaceFragment(screenShotable, position);
    }

    @Override
    public void disableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @Override
    public void enableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout.closeDrawers();
    }

    @Override
    public void addViewToContainer(View view) {
        linearLayout.addView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            drawerLayout.openDrawer(GravityCompat.END); /*Opens the Right Drawer*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
