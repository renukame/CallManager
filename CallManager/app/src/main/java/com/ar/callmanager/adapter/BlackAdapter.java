package com.ar.callmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ar.callmanager.R;
import com.ar.callmanager.model.BlackDetails;

import java.util.List;

/**
 * Created by Renuka on 16-01-2017.
 */

public class BlackAdapter extends RecyclerView.Adapter<BlackAdapter.ViewHolder> {

    List<BlackDetails> blackList;

    public BlackAdapter(List<BlackDetails> list){
        blackList = list;
    }

    @Override
    public BlackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.black_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BlackAdapter.ViewHolder holder, int position) {
        holder.name.setText(blackList.get(position).getName());
        holder.number.setText(blackList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return blackList.size();
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
