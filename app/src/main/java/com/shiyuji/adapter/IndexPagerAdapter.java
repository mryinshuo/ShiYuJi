package com.shiyuji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shiyuji.R;
import com.shiyuji.model.IndexItem;

import java.util.ArrayList;
import java.util.List;

public class IndexPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Integer> list;
    private List<String> title;
    private List<IndexItem> recommendItems;
    private List<IndexItem> liveItems;

    public IndexPagerAdapter(Context context , List<Integer> list, List<String> title) {
        this.context = context;
        this.list = list;
        this.title = title;
    }

    public void init() {
        recommendItems = new ArrayList<>();
        recommendItems.add(new IndexItem(R.drawable.hequminge, "山西省河曲县 河曲民歌 原生态乡土民歌", R.drawable.quju, "北京曲剧,曲艺单弦牌子曲为主发展而成"));
        recommendItems.add(new IndexItem(R.drawable.suonayishu, "河南省沁阳市唢呐《九峰情话》、《沁阳春》", R.drawable.kongquewu, "最负盛名的传统表演性舞蹈傣族民间舞孔雀舞"));
        recommendItems.add(new IndexItem(R.drawable.kunqu, "苏州太仓南码头百戏之祖昆曲", R.drawable.andaiwu, "内蒙古通辽市蒙古族舞蹈活化石安代舞"));
        recommendItems.add(new IndexItem(R.drawable.liyuanxi, "闽浙之音、古南戏活化石 梨园戏", R.drawable.chuanju, "中国传统戏曲川剧"));

        liveItems = new ArrayList<>();
        liveItems.add(new IndexItem(R.drawable.daoqingxi, "陕西关中道情戏正在直播...", R.drawable.zhuangju, "壮剧壮剧正在直播..."));
        liveItems.add(new IndexItem(R.drawable.buyixi, "兴义布依戏正在直播...", R.drawable.nonglewu, "东北朝鲜族农乐舞正在直播..."));
        liveItems.add(new IndexItem(R.drawable.huagu, "山西省翼城花鼓正在直播...", R.drawable.puningyingge, "广东省普宁英歌正在直播..."));
        liveItems.add(new IndexItem(R.drawable.shiwu, "舞狮子表演正在直播...", R.drawable.yangge, "秧歌舞正在直播..."));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        init();
        int item = list.get(position);
        View view = View.inflate(context, item, null);
        if (item == R.layout.activity_index_recommend) {
            ListView recommendLV = (ListView) view.findViewById(R.id.indexLV);
            recommendLV.setAdapter(new IndexItemAdapter(context, R.layout.activity_index_item, recommendItems));
            recommendLV.setDivider(null);
        } else if (item == R.layout.activity_index_live) {
            ListView liveLV = (ListView) view.findViewById(R.id.liveLV);
            liveLV.setAdapter(new IndexItemAdapter(context, R.layout.activity_index_item, liveItems));
            liveLV.setDivider(null);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
