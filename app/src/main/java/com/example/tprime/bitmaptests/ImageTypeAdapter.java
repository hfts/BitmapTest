package com.example.tprime.bitmaptests;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageTypeAdapter extends BaseAdapter {
    public static final String RESULT_PASS = "PASS";
    public static final String RESULT_FAIL = "FAIL";

    private Context context;
    private LayoutInflater inflater;
    private List<ImageTypeListItem> data;
    private ViewHolder holder;
    private String path;

    ImageTypeAdapter(Context c, List list) {
        this.context = c;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    ImageTypeAdapter(Context c, List list, String path) {
        this.context = c;
        this.data = list;
        inflater = LayoutInflater.from(context);
        this.path = path;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.listview_image_types, viewGroup, false);

            holder = new ViewHolder();
            holder.mImgTypeIcon = (ImageView) view.findViewById(R.id.ib_icon_img_type);
            holder.mFunName = (TextView) view.findViewById(R.id.tv_func_name);
            holder.mResult = (TextView) view.findViewById(R.id.tv_test_result);
            holder.mRunTestBtn = (Button) view.findViewById(R.id.run_test_btn);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ImageTypeListItem item = data.get(pos);
        holder.mImgTypeIcon.setImageBitmap(item.mBitmap);
        holder.mFunName.setText(item.mFunName);
        holder.mFunName.setTextColor(Color.RED); // R:43 G:150 B:60
        holder.mResult.setText(item.mResult);
        if(item.mResult.equals(RESULT_FAIL)){
            holder.mResult.setTextColor(Color.RED);//Color.argb(100, 43, 150, 60)
        } else if(item.mResult.equals(RESULT_PASS)){
            holder.mResult.setTextColor(Color.argb(255, 0, 136, 65));//Color.argb(100, 43, 150, 60)
        }

        holder.mRunTestBtn.setOnClickListener(new RunTestBtnOnClickListener(pos));

        return view;
    }

    class RunTestBtnOnClickListener implements View.OnClickListener{
        private int position;

        RunTestBtnOnClickListener(int position){
            this.position = position;
        }

        @Override
        public void onClick(View view) {

            DecodeResult result = BitmapUtils.decodeFile(path);
            if(result.result.equals("SUCESS")) {
                data.get(position).mResult = String.valueOf(result.elapse_ms) + "ms";
            } else {
                data.get(position).mResult = "FAIL";
            }


            notifyDataSetChanged();
        }
    }
}

class ViewHolder {
    public ImageView mImgTypeIcon;
    public TextView mFunName;
    public TextView mResult;
    public Button mRunTestBtn;
}
