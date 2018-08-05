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
import com.shiyuji.model.NearbyItem;

import java.util.List;

public class NearbyItemAdapter extends ArrayAdapter {

    private final int resourceId;
    private LayoutInflater inflater;

    public NearbyItemAdapter(@NonNull Context context, int resource, List<NearbyItem> items) {
        super(context, resource, items);
        resourceId = resource;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NearbyItem item = (NearbyItem) getItem(position);
        View view = inflater.inflate(resourceId, null);
        Button nearbyFollow = (Button) view.findViewById(R.id.nearbyFollow);

        ((ImageView)view.findViewById(R.id.nearbyHeadIV)).setImageResource(item.getHead());
        ((TextView)view.findViewById(R.id.nearbyNameTV)).setText(item.getName());
        if (item.isFollowed()) {
            nearbyFollow.setText("已关注");
            nearbyFollow.setTextColor(view.getResources().getColor(R.color.gray));
            nearbyFollow.setBackground(view.getResources().getDrawable(R.drawable.round_corner_primary));
        }
        ((TextView)view.findViewById(R.id.nearbyContentTV)).setText(item.getContent());
        ((ImageView)view.findViewById(R.id.nearbyContentIV)).setImageResource(item.getImage());
        ((TextView)view.findViewById(R.id.nearbyLikeNum)).setText(item.getLikeNum());
        ((TextView)view.findViewById(R.id.nearbyCommentNum)).setText(item.getCommentNum());
        ((TextView)view.findViewById(R.id.nearbyShareNum)).setText(item.getShareNum());

        nearbyFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if (button.getText().equals("已关注")) {
                    button.setText("+ 关注");
                    button.setTextColor(v.getResources().getColor(R.color.black));
                    button.setBackground(v.getResources().getDrawable(R.drawable.round_corner_gray));
                } else {
                    button.setText("已关注");
                    button.setTextColor(v.getResources().getColor(R.color.gray));
                    button.setBackground(v.getResources().getDrawable(R.drawable.round_corner_primary));
                }
            }
        });

        return view;
    }
}
