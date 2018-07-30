package com.shiyuji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class TrendsItemAdapter extends ArrayAdapter {

    private final int resourceId;           // 当前视图id

    public TrendsItemAdapter(Context context, int textViewResourceId, List<TrendsItem> items) {
        super(context, textViewResourceId, items);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrendsItem item = (TrendsItem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        TextView trendsTitle = (TextView) view.findViewById(R.id.trendsTitle);
        trendsTitle.setText(item.getTitle());
        TextView trendsContent = (TextView) view.findViewById(R.id.trendsContent);
        trendsContent.setText(item.getContent());
        ImageView trendsImg = (ImageView) view.findViewById(R.id.trendsImg);
        if (item.getImg() != 0) {
            trendsImg.setImageResource(item.getImg());
        } else {
            ((LinearLayout) view.findViewById(R.id.trendsLL)).removeView(trendsImg);
        }

        return view;
    }
}
