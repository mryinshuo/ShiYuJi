package com.shiyuji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shiyuji.R;
import com.shiyuji.model.IndexItem;

import java.util.List;

public class IndexItemAdapter extends ArrayAdapter {
    private final int resourceId;           // 当前视图id
    private Context context;

    public IndexItemAdapter(@NonNull Context context, int resource, List<IndexItem> items) {
        super(context, resource, items);
        resourceId = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        IndexItem item = (IndexItem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        ((ImageView)view.findViewById(R.id.indexIV1)).setImageResource(item.getImage1());
        ((TextView)view.findViewById(R.id.indexTV1)).setText(item.getText1());
        ((ImageView)view.findViewById(R.id.indexIV2)).setImageResource(item.getImage2());
        ((TextView)view.findViewById(R.id.indexTV2)).setText(item.getText2());

        view.findViewById(R.id.CV1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CardView1", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.CV2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CardView2", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
