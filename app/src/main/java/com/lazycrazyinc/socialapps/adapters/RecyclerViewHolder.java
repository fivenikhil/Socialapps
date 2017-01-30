package com.lazycrazyinc.socialapps.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lazycrazyinc.socialapps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolder extends RecyclerView.Adapter<RecyclerViewHolder.ViewHolder>
{
    private Context context;
    LayoutInflater inflater;
    int[] datalist;

    public RecyclerViewHolder(Context context, int[] datalist) {
        this.context = context;
        this.datalist = datalist;
        inflater = LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.image) ImageView img;

        public ViewHolder(View v)
        {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerViewHolder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);
        ViewHolder  vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder.ViewHolder holder, final int position) {

        Glide.with(context).load(datalist[position]).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.facebook.katana"));
                        context.startActivity(intent);
                    }
                }
                if (position ==1)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.instagram.android"));
                        context.startActivity(intent);
                    }
                }

                if (position ==2)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.twitter.android");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.twitter.android"));
                        context.startActivity(intent);
                    }
                }

                if (position ==3)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.linkedin.android");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.linkedin.android"));
                        context.startActivity(intent);
                    }
                }

                if (position ==4)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.snapchat.android"));
                        context.startActivity(intent);
                    }
                }

                if (position ==5)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.whatsapp"));
                        context.startActivity(intent);
                    }
                }

                if (position ==6)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.apps.plus");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.google.android.apps.plus"));
                        context.startActivity(intent);
                    }
                }

                if (position ==7)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.google.android.youtube"));
                        context.startActivity(intent);
                    }
                }

                if (position ==8)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.tumblr");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.tumblr"));
                        context.startActivity(intent);
                    }
                }

                if (position ==9)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.pinterest");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.pinterest"));
                        context.startActivity(intent);
                    }
                }

                if (position ==10)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.reddit.frontpage");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.reddit.frontpage"));
                        context.startActivity(intent);
                    }
                }


                if (position ==11)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.skype.raider");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.skype.raider"));
                        context.startActivity(intent);
                    }
                }

                if (position ==12)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.quora.android");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.quora.android"));
                        context.startActivity(intent);
                    }
                }

                if (position ==13)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.yahoo.mobile.client.android.flickr");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.yahoo.mobile.client.android.flickr"));
                        context.startActivity(intent);
                    }
                }

                if (position ==14)
                {
                    Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.joelapenna.foursquared");
                    if (intent != null) {
                        // We found the activity now start the activity
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Bring user to the market or let them choose an app?
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.joelapenna.foursquared"));
                        context.startActivity(intent);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.length;
    }
}
