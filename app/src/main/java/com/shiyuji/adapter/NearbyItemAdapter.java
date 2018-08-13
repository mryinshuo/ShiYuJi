package com.shiyuji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shiyuji.R;
import com.shiyuji.model.TrendsItem;

import java.util.List;

public class NearbyItemAdapter extends ArrayAdapter {
    private final int resourceId;
    private LayoutInflater inflater;

    public NearbyItemAdapter(@NonNull Context context, int resource, List<TrendsItem> items) {
        super(context, resource, items);
        resourceId = resource;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrendsItem item = (TrendsItem) getItem(position);
        View view = inflater.inflate(resourceId, null);

        ((ImageView)view.findViewById(R.id.trendsHeadIV)).setImageResource(item.getHead());
        ((TextView)view.findViewById(R.id.trendsNameTV)).setText(item.getName());
        ((TextView)view.findViewById(R.id.trendsTimeTV)).setText(item.getTime());
        Button follow = (Button) view.findViewById(R.id.trendsFollow);
        changeFollow(position, view.findViewById(R.id.trendsFollow));
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TrendsItem) getItem(position)).setFollowed(!((TrendsItem) getItem(position)).isFollowed());
                changeFollow(position, v);
            }
        });
        ((TextView)view.findViewById(R.id.trendsContentTV)).setText(item.getContent());
        ((ImageView)view.findViewById(R.id.trendsContentIV)).setImageResource(item.getImage());
        ((TextView)view.findViewById(R.id.trendsLikeNum)).setText(item.getLikeNum());
        ((TextView)view.findViewById(R.id.trendsCommentNum)).setText(item.getCommentNum());
        ((TextView)view.findViewById(R.id.trendsShareNum)).setText(item.getShareNum());

        return view;
    }

    public void changeFollow(int i, View view) {
        TrendsItem item = (TrendsItem) getItem(i);
        Button v = (Button) view;
        if (item.isFollowed()) {
            v.setText("已关注");
            v.setTextColor(view.getResources().getColor(R.color.colorPrimary));
        } else {
            v.setText("+ 关注");
            v.setTextColor(view.getResources().getColor(R.color.black));
        }
    }
}
