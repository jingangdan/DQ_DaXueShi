package com.dq.daxueshi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dq.daxueshi.Interface.OnItemClickListener;
import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseRecyclerViewHolder;

/**
 * 首页-机关（适配器）
 * Created by jingang on 2018/6/6.
 */

public class OfficeAdapter extends RecyclerView.Adapter<OfficeAdapter.MyViewHolder> {
    private Context mContext;
    private OnItemClickListener onItemClickListener;

    public OfficeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder vh = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_office, parent, false));
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if(onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
        
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyViewHolder extends BaseRecyclerViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }
}
