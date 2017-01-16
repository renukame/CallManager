package com.ar.callmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ar.callmanager.R;
import com.ar.callmanager.model.WhiteDetails;

import java.util.List;

/**
 * Created by Renuka on 16-01-2017.
 */

public class WhiteAdapter extends RecyclerView.Adapter<WhiteAdapter.ViewHolder> {

    List<WhiteDetails> whiteList;
    public WhiteAdapter(List<WhiteDetails> list){
        whiteList = list;
    }

    @Override
    public WhiteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.white_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WhiteAdapter.ViewHolder holder, int position) {
        holder.name.setText(whiteList.get(position).getName());
        holder.number.setText(whiteList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return whiteList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView number;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
        }
    }
}
