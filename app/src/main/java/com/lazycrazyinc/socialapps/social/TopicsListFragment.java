package com.lazycrazyinc.socialapps.social;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.lazycrazyinc.socialapps.R;
import com.lazycrazyinc.socialapps.adapters.Topics_Adapter;

import java.util.ArrayList;
import java.util.Arrays;


public class TopicsListFragment extends Fragment
{
    RecyclerView.Adapter mAdapter;
    Context mContext;
    RecyclerView mRecyclerView;

    public static TopicsListFragment newInstance()
    {
        return new TopicsListFragment();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle)
    {
        return inflater.inflate(R.layout.fragment_topics_list, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        mContext = getActivity();
        mRecyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        String[] datalist = mContext.getResources().getStringArray(R.array.main_topics);
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(datalist));

        mAdapter = new RecyclerViewMaterialAdapter(new Topics_Adapter(mContext, stringList));
        mRecyclerView.setAdapter(mAdapter);
        MaterialViewPagerHelper.registerRecyclerView(mContext, mRecyclerView);
    }
}
