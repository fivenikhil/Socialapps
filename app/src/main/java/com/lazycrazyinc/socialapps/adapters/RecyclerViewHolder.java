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
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.length;
    }
}
