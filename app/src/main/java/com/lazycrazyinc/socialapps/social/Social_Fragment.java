package com.lazycrazyinc.socialapps.social;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lazycrazyinc.socialapps.R;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

public class Social_Fragment extends Fragment implements ScreenShotable
{
    public static final String CLOSE = "Close";
    public static final String RATE = "Rate us";
    public static final String SHARE = "Share app";
    public static final String BACK = "Feedback";
    public static final String SETT = "Settings";
    public static final String INFO = "About us";
    public static final String EXIT = "Exit";

    public static final String FACE = "Facebook";
    public static final String INST = "Instragram";
    public static final String WHAT = "Whatsapp";
    public static final String SNAP = "SnapChat";
    public static final String TWIT = "Twitter";
    public static final String LINK = "Linkdin";
    public static final String QUORA = "Quora";
    public static final String TUMB = "Tumblr";
    public static final String PINT = "Pinterest";
    public static final String REDD = "Reddit";
    public static final String GPLUS = "Google+";
    public static final String YOUT = "Youtube";
    public static final String FLICK = "Flickr";
    public static final String FOUR = "FourSquare";
    public static final String BING = "Bing";
    public static final String BUFF = "Buffer";


    private View containerView;
    protected WebView mView;
    protected int res;
    private Bitmap bitmap;
    Bundle mBundle;
    String url;

   /* public static Social_Fragment newInstance(int resId) {
        Social_Fragment contentFragment = new Social_Fragment();
        *//*Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        contentFragment.setArguments(bundle);*//*
        return contentFragment;
    }*/

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mView = (WebView) rootView.findViewById(R.id.webview);

        mBundle = this.getArguments();
        if (mBundle != null) {
            //res = mBundle.getInt("imag");
            url = mBundle.getString("url");

        }
        /*mImageView.setClickable(true);
        mImageView.setFocusable(true);
        mImageView.setImageResource(res);*/

        mView.setWebViewClient(new Social_Fragment.myWebClient());
        mView.getSettings().setLoadsImagesAutomatically(true);
        mView.getSettings().setJavaScriptEnabled(true);
        mView.getSettings().getBuiltInZoomControls();
        mView.getSettings().setGeolocationEnabled(true);
        mView.getSettings().getDisplayZoomControls();
        mView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        CookieManager.getInstance().setAcceptCookie(true);

        if (Build.VERSION.SDK_INT >= 19) {
            mView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            mView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        mView.loadUrl(url);
        return rootView;
    }


    private class myWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            // progressBar.show();
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //if (progressBar.isShowing()) {
            //    progressBar.dismiss();
            //}
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getArguments().getInt(Integer.class.getName());
    }

    @Override
    public void takeScreenShot() {
       /* Thread thread = new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                Social_Fragment.this.bitmap = bitmap;
            }
        };

        thread.start();*/

    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }
}
