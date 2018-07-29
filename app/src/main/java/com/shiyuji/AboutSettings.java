package com.shiyuji;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutSettings extends AppCompatActivity {

    private long counts[] = new long[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_about);

        final ImageView EASTEREGG = (ImageView) findViewById(R.id.EASTEREGG);
        EASTEREGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.arraycopy(counts, 1, counts, 0, counts.length - 1);
                counts[counts.length - 1] = SystemClock.uptimeMillis();
                if (counts[0] > SystemClock.uptimeMillis() - 1500) {
                    EASTEREGG.setImageResource(R.drawable.ceo);
                }
            }
        });
    }
}
