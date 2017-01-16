package com.ar.callmanager.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.callmanager.R;
import com.ar.callmanager.adapter.WhiteAdapter;
import com.ar.callmanager.database.WhiteManager;
import com.ar.callmanager.model.WhiteDetails;

import java.util.ArrayList;
import java.util.List;


public class WhiteFragment extends Fragment {
    private RecyclerView recyclerView;
    private WhiteManager whiteManager;
    private List<WhiteDetails> whiteList = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_white,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.call_list);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        whiteManager = new WhiteManager(getActivity().getApplicationContext());
        whiteList = whiteManager.readWhiteData();
        WhiteAdapter whiteAdapter = new WhiteAdapter(whiteList);
        recyclerView.setAdapter(whiteAdapter);
    }

}
