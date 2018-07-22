package com.example.tprime.bitmaptests;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestDecodeFileActivity extends TestActivityBase {
    private String LOG_TAG = "TestDecodeFileActivity";
    private ListView listView;
    private Button mRunAllBtn;
    private String path = "";
    private String func_name = "";
    private List<ImageTypeListItem> data;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode_file);
        initWidget();
        parseIntent();

        data = initDataSource();
        ImageTypeAdapter adapter = new ImageTypeAdapter(getApplicationContext(), data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new MyItemClickListener());
    }

    private void parseIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        path = bundle.getString("file_path");
        func_name = bundle.getString("func_name");
    }

    private List<ImageTypeListItem> initDataSource() {
        List<ImageTypeListItem> source = new ArrayList<ImageTypeListItem>();
        Bitmap bitmap = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#FF0000"));
        source.add(new ImageTypeListItem(bitmap, "jpeg", ImageTypeAdapter.RESULT_PASS));
        source.add(new ImageTypeListItem(bitmap, "gif", ImageTypeAdapter.RESULT_FAIL));
        source.add(new ImageTypeListItem(bitmap, "png", ImageTypeAdapter.RESULT_PASS));
        source.add(new ImageTypeListItem(bitmap, "psd", ImageTypeAdapter.RESULT_PASS));
        return source;
    }

    private void initWidget() {
        listView = (ListView)findViewById(R.id.lv_devode_file);
        mRunAllBtn = (Button)findViewById(R.id.btn_run_all);
    }


    class MyItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(TestDecodeFileActivity.this, "我是item点击事件 i = " + i + "l = " + l, Toast.LENGTH_SHORT).show();
        }
    }
}


