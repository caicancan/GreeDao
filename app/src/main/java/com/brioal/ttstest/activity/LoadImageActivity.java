package com.brioal.ttstest.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.brioal.ttstest.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class LoadImageActivity extends Activity {
    @ViewInject(R.id.main_simple_drawee_view)
    private SimpleDraweeView draweeView;
    private Uri uri =  Uri.parse("http://dynamic-image.yesky.com/740x-/uploadImages/2015/163/50/690V3VHW0P77.jpg");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        ViewUtils.inject(this);
        //加载图片
        setImageView();
    }

    private void setImageView() {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        draweeView.setController(controller);
    }

}
