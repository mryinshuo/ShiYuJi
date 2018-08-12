package com.shiyuji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.shiyuji.R;
import com.shiyuji.model.CommentItem;

import java.util.List;

public class CommentItemAdapter extends ArrayAdapter {

    private final int resourceId;           // 当前视图id
    private Context context;

    private TextView follow;
    private ImageButton favorite;

    public CommentItemAdapter(@NonNull Context context, int resourceId, List<CommentItem> items) {
        super(context, resourceId, items);
        this.context = context;
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CommentItem item = (CommentItem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        follow = (TextView) view.findViewById(R.id.CommentFollowTV);
        favorite = (ImageButton) view.findViewById(R.id.CommentFavoriteIB);

        ((ImageView) view.findViewById(R.id.CommentHeadIV)).setImageResource(item.getHead());
        ((TextView) view.findViewById(R.id.CommentNameTV)).setText(item.getName());
        ((TextView) view.findViewById(R.id.CommentIdTV)).setText("#" + item.getId());
        ((TextView) view.findViewById(R.id.CommentTimeTV)).setText(item.getTime());
        changeFollow(position, view.findViewById(R.id.CommentFollowTV));
        ((TextView) view.findViewById(R.id.CommentTextTV)).setText(item.getText());
        ((TextView) view.findViewById(R.id.CommentLikeNumTV)).setText(Integer.toString(item.getLikeNum()));
        ((TextView) view.findViewById(R.id.CommentShareNumTV)).setText(Integer.toString(item.getShareNum()));
        changeFavorite(position, view.findViewById(R.id.CommentFavoriteIB));

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CommentItem) getItem(position)).setFollowed(!((CommentItem) getItem(position)).isFollowed());
                changeFollow(position, v);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CommentItem) getItem(position)).setFavorite(!((CommentItem) getItem(position)).isFavorite());
                changeFavorite(position, v);
            }
        });

        return view;
    }

    public void changeFollow(int i, View view) {
        CommentItem item = (CommentItem) getItem(i);
        TextView v = (TextView) view;
        if (item.isFollowed()) {
            v.setText("已关注");
            v.setTextColor(context.getResources().getColor(R.color.gray));
        } else {
            v.setText("关注");
            v.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        }
    }

    public void changeFavorite(int i, View view) {
        CommentItem item = (CommentItem) getItem(i);
        ImageButton v = (ImageButton) view;
        if (item.isFavorite()) {
            v.setBackgroundResource(R.drawable.xihuanhou);
        } else {
            v.setBackgroundResource(R.drawable.xihuan);
        }
    }
}
