package com.example.tprime.bitmaptests;

import android.content.Intent;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BitmapTestsMainActivity extends AppCompatActivity {
    private ListView lv_function_lists;
    private String path = "/sdcard/test_images";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_tests_main);
        initWidget();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_btimap_tests_main_listview_item, DataSource.dataOfFunc);
        lv_function_lists.setAdapter(adapter);
        lv_function_lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(BitmapTestsMainActivity.this, "0", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BitmapTestsMainActivity.this, TestDecodeFileActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("file_path", path);
                        bundle.putString("func_name", FunctionName.FUNC_DECODE_FILE);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(BitmapTestsMainActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(BitmapTestsMainActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(BitmapTestsMainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(BitmapTestsMainActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;

                        default:
                            Toast.makeText(BitmapTestsMainActivity.this, "default", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }



    private void initWidget() {
        lv_function_lists = (ListView)findViewById(R.id.lv_function_lists);
    }

}





