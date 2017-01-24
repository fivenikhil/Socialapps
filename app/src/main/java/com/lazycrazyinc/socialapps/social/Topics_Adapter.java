package com.lazycrazyinc.socialapps.social;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lazycrazyinc.socialapps.R;

import java.util.ArrayList;


public class Topics_Adapter extends RecyclerView.Adapter<Topics_Adapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<String> contents;

    public Topics_Adapter(Context mContext, ArrayList<String> contents)
    {
        this.mContext=mContext;
        this.contents = contents;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title, sub_title;
        public RelativeLayout rl,rll;

        public ViewHolder(View v)
        {
            super(v);

            title = (TextView) v.findViewById(R.id.tvTitle);
            sub_title = (TextView)v.findViewById(R.id.tvSubtitle);
            rl = (RelativeLayout)v.findViewById(R.id.rl);
            rll = (RelativeLayout)v.findViewById(R.id.rlTitle);

        }
    }

    @Override
    public Topics_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_cardview_top, parent, false);
        ViewHolder  vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Topics_Adapter.ViewHolder holder,final int position) {
        holder.title.setText(contents.get(position));
        holder.sub_title.setVisibility(View.GONE);
        holder.title.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "MuchoSansBold.ttf"));

        if(position == 0)
        {

            holder.rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(mContext, SocialActivity.class);
                    //i.putExtra("sub_topic", position);
                    mContext.startActivity(i);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }
}
