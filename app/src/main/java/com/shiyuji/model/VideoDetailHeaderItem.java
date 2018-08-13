package com.shiyuji.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.shiyuji.R;

public class VideoDetailHeaderItem extends LinearLayout {

    private Context context;
    private LayoutInflater inflater;

    private boolean isFollowed;
    private boolean isFavorite;

    private VideoView videoVV;
    private ImageView headIV;
    private TextView nameTV;
    private TextView timeTV;
    private TextView visitNumTV;
    private TextView followTV;
    private TextView textTV;
    private TextView likeNumTV;
    private TextView commentNumTV;
    private TextView shareNumTV;
    private ImageButton favoriteIB;

    public VideoDetailHeaderItem(Context context) {
        super(context);
    }

    public VideoDetailHeaderItem(Context context, boolean isFollowed, boolean isFavorite) {
        super(context);
        this.context = context;
        this.isFollowed = isFollowed;
        this.isFavorite = isFavorite;

        inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.activity_video_detail_header, null);
        addView(view);

        videoVV = (VideoView) view.findViewById(R.id.videoDetailVV);
        headIV = (ImageView) view.findViewById(R.id.videoDetailHead);
        nameTV = (TextView) view.findViewById(R.id.videoDetailName);
        timeTV = (TextView) view.findViewById(R.id.videoDetailTime);
        visitNumTV = (TextView) view.findViewById(R.id.videoDetailVisitNum);
        followTV = (TextView) view.findViewById(R.id.videoDetailFollow);
        textTV = (TextView) view.findViewById(R.id.videoDetailText);
        likeNumTV = (TextView) view.findViewById(R.id.videoDetailLikeNum);
        commentNumTV = (TextView) view.findViewById(R.id.videoDetailCommentNum);
        shareNumTV = (TextView) view.findViewById(R.id.videoDetailShareNum);
        favoriteIB = (ImageButton) view.findViewById(R.id.videoDetailFavorite);

        setFollowed(isFollowed);
        setFavorite(isFavorite);
    }

    public void setHead(int head) {
        headIV.setImageResource(head);
    }

    public void setName(String name) {
        nameTV.setText(name);
    }

    public void setTime(String time) {
        timeTV.setText(time);
    }

    public void setVisitNum(int visitNum) {
        visitNumTV.setText(Integer.toString(visitNum));
    }

    public boolean getFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        if (followed) {
            followTV.setText("已关注");
            followTV.setTextColor(getResources().getColor(R.color.gray));
            isFollowed = true;
        } else {
            followTV.setText("+ 关注");
            followTV.setTextColor(getResources().getColor(R.color.colorPrimary));
            isFollowed = false;
        }
    }

    public void setText(String text) {
        textTV.setText(text);
    }

    public void setLikeNum(int likeNum) {
        likeNumTV.setText(Integer.toString(likeNum));
    }

    public void setCommentNum(int commentNum) {
        commentNumTV.setText(Integer.toString(commentNum));
    }

    public void setShareNum(int shareNum) {
        shareNumTV.setText(Integer.toString(shareNum));
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        if (favorite) {
            favoriteIB.setBackgroundResource(R.drawable.xihuanhou);
            isFavorite = true;
        } else {
            favoriteIB.setBackgroundResource(R.drawable.xihuan);
            isFavorite = false;
        }
    }
}
