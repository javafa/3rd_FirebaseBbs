package com.veryworks.android.firebasebbs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veryworks.android.firebasebbs.domain.Bbs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 7/3/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder>{
    private List<Bbs> data = new ArrayList<>();
    private LayoutInflater inflater;

    public ListAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Bbs> data){
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Bbs bbs = data.get(position);
        holder.setTitle(bbs.title);
        holder.setCount(bbs.count);
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textCount;
        public Holder(View v) {
            super(v);
            textTitle = (TextView) v.findViewById(R.id.textTitle);
            textCount = (TextView) v.findViewById(R.id.textCount);
        }
        public void setTitle(String title){
            textTitle.setText(title);
        }
        public void setCount(long count){
            textCount.setText(count + "");
        }
    }
}
