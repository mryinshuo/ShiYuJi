package com.shiyuji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shiyuji.adapter.CommentItemAdapter;
import com.shiyuji.model.CommentItem;
import com.shiyuji.model.VideoDetailHeaderItem;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView videoDetail;
    private List<CommentItem> list;
    private ImageView videoDetailHead;
    private VideoDetailHeaderItem header;
    private TextView followTV;
    private ImageButton favoriteIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        videoDetail = (ListView) findViewById(R.id.videoDetailLV);
        init();
        videoDetail.setAdapter(new CommentItemAdapter(this, R.layout.comment_item, list));
        header = new VideoDetailHeaderItem(this, true, true);
        initHeader(header);
        videoDetail.addHeaderView(header);

        videoDetailHead = (ImageView) findViewById(R.id.videoDetailHead);
        followTV = (TextView) findViewById(R.id.videoDetailFollow);
        favoriteIB = (ImageButton) findViewById(R.id.videoDetailFavorite);
        videoDetailHead.setOnClickListener(this);
        followTV.setOnClickListener(this);
        favoriteIB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.videoDetailHead:
                Intent intent = new Intent(this, UserActivity.class);
                startActivity(intent);
                break;
            case R.id.videoDetailFollow:
                header.setFollowed(!header.getFollowed());
                break;
            case R.id.videoDetailFavorite:
                header.setFavorite(!header.getFavorite());
                break;
        }
    }

    public void init() {
        list = new ArrayList<>();
        list.add(new CommentItem(R.drawable.yangge, "落日余晖", "5", "8-10", true, "咏叹了人间离苦、别绪、思念、期盼！", 10, 10, true));
        list.add(new CommentItem(R.drawable.chuanju, "山西某不知名网友", "4", "8-7", true, "蕴含有丰富的美学意味。", 20, 20, true));
        list.add(new CommentItem(R.drawable.pic3, "家里有只小旺仔", "3", "8-7", true, "河曲民歌吟唱内容丰富，涵盖社会生活的各个层面。", 30, 30, true));
        list.add(new CommentItem(R.drawable.kongquewu, "呆酱", "2", "8-7", true, "一个上下句就揭示出一种深邃的感情状况或描绘出一种逼真的生活画面。", 40, 40, true));
        list.add(new CommentItem(R.drawable.kunqu, "李三岁", "1", "8-7", true, "极具文化神韵的传统经典原生态乡土民歌", 50, 50, true));
    }

    public void initHeader(VideoDetailHeaderItem header) {
        header.setHead(R.drawable.hequminge);
        header.setName("山西河曲民歌官方");
        header.setTime("2小时前");
        header.setVisitNum(1802);
        header.setText("河曲民歌在反映中国民歌发展历史与中国民间社会生活状况方面，具有典型的意义。");
        header.setLikeNum(10);
        header.setCommentNum(20);
        header.setShareNum(30);
    }
}
