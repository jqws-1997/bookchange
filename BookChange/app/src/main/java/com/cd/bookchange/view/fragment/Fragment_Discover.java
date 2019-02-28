package com.cd.bookchange.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cd.bookchange.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Timer;
import java.util.TimerTask;

/*  发现页面
 */

public class Fragment_Discover extends Fragment implements OnClickListener {
    private Activity ctx;
    private View layout;
    private TextView tv1,tv2;
    private TextView tv3,tv4;
    private SimpleDraweeView sdv1,sdv2;
    private SimpleDraweeView sdv3,sdv4;


    private Handler handler=null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (layout == null) {
            ctx = this.getActivity();
            layout = ctx.getLayoutInflater().inflate(R.layout.nearby_reading, null);
            //创建属于主线程的handler
            handler=new Handler();
            setOnListener();
        } else {
            ViewGroup parent = (ViewGroup) layout.getParent();
            if (parent != null) {
                parent.removeView(layout);
            }
        }
        return layout;
    }

    //增加监听器
    private void setOnListener() {
        tv1 = (TextView)layout.findViewById(R.id.nearby_reading_tv);
        tv2 = (TextView)layout.findViewById(R.id.nearby_reading_tv2);
        layout.findViewById(R.id.nearby_reading_iv).setOnClickListener(this);
        layout.findViewById(R.id.nearby_reading_iv2).setOnClickListener(this);
        sdv1 = (SimpleDraweeView) layout.findViewById(R.id.nearby_reading_iv);
        Uri uri1 = Uri.parse("android.resource://com.cd.bookchange/"+ R.drawable.discover_man1);
        sdv1.setImageURI(uri1);
        sdv2 = (SimpleDraweeView) layout.findViewById(R.id.nearby_reading_iv2);
        Uri uri2 = Uri.parse("android.resource://com.cd.bookchange/"+ R.drawable.discover_girl);
        sdv2.setImageURI(uri2);

        tv3 = (TextView)layout.findViewById(R.id.copy_nearby_reading_tv);
        tv4 = (TextView)layout.findViewById(R.id.copy_nearby_reading_tv2);
        layout.findViewById(R.id.copy_nearby_reading_iv).setOnClickListener(this);
        layout.findViewById(R.id.copy_nearby_reading_iv2).setOnClickListener(this);
        sdv3 = (SimpleDraweeView) layout.findViewById(R.id.copy_nearby_reading_iv);
        Uri uri3 = Uri.parse("android.resource://com.cd.bookchange/"+ R.drawable.discover_man);
        sdv3.setImageURI(uri3);
        sdv4 = (SimpleDraweeView) layout.findViewById(R.id.copy_nearby_reading_iv2);
        Uri uri4 = Uri.parse("android.resource://com.cd.bookchange/"+ R.drawable.discover_girl1);
        sdv4.setImageURI(uri4);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nearby_reading_iv:
                tv1.setVisibility(View.VISIBLE);
                tv1.setText("《" + "玉女心经" + "》");
                Destroy();
                break;
            case R.id.nearby_reading_iv2:
                tv2.setVisibility(View.VISIBLE);
                tv2.setText("《" + "金瓶梅" + "》");
                Destroy();
                break;
            case R.id.copy_nearby_reading_iv:
                tv3.setVisibility(View.VISIBLE);
                tv3.setText("《" + "黄帝内经" + "》");
                Destroy();
                break;
            case R.id.copy_nearby_reading_iv2:
                tv4.setVisibility(View.VISIBLE);
                tv4.setText("《" + "这个世界会好吗" + "》");
                Destroy();
                break;

        }
    }

    private void Destroy(){

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                new Thread(){
                    public void run(){
                        handler.post(runnableUi);
                    }
                }.start();
            }
        };
        timer.schedule(task, 1065 * 1);  //1秒后结束显示

    }

    Runnable runnableUi = new Runnable() {
        @Override
        public void run() {
            //更新界面
            tv1.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            tv3.setVisibility(View.INVISIBLE);
            tv4.setVisibility(View.INVISIBLE);
        }
    };


}
