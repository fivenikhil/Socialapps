package com.lazycrazyinc.socialapps.social;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lazycrazyinc.socialapps.R;
import com.lazycrazyinc.socialapps.adapters.RecyclerViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SocialActivity extends AppCompatActivity
{

    @BindView(R.id.recycler_viewG)
    RecyclerView viewG;
    RecyclerView.Adapter adapter;
    GridLayoutManager LayoutManagaer;

    int[] listviewImage = new int[] {
            R.drawable.facebook, R.drawable.instagram,
            R.drawable.twitter, R.drawable.linkedin,
            R.drawable.snapchat, R.drawable.whatsapp,
            R.drawable.google_plus, R.drawable.youtube,
            R.drawable.tumblr, R.drawable.pinterest,
            R.drawable.reddit, R.drawable.skype,
            R.drawable.quora, R.drawable.flickr,
            R.drawable.foursquare
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_activity);
        ButterKnife.bind(this);

        LayoutManagaer = new GridLayoutManager(this, 2);
        viewG.setLayoutManager(LayoutManagaer);
        viewG.setHasFixedSize(true);
        adapter = new RecyclerViewHolder(this,listviewImage);
        viewG.setAdapter(adapter);

       /* DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(viewG.getContext(),
                LayoutManagaer.getOrientation());
        viewG.addItemDecoration(dividerItemDecoration);*/
    }


}
