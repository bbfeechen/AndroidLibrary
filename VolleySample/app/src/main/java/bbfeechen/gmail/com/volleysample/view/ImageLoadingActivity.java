package bbfeechen.gmail.com.volleysample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import bbfeechen.gmail.com.volleysample.R;
import bbfeechen.gmail.com.volleysample.control.RequestManager;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class ImageLoadingActivity extends AppCompatActivity {
    private NetworkImageView mImageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loading);

        mImageView = (NetworkImageView) findViewById(R.id.iv_image);

        Button btnImageLoadingRequest = (Button) findViewById(R.id.btn_image_loading);
        btnImageLoadingRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoader imageLoader = RequestManager.getImageLoader();
                mImageView
                    .setImageUrl(
                        "http://c.hiphotos.baidu.com/image/w%3D1280%3Bcrop%3D0%2C0%2C1280%2C800/sign=2abcf809eb24b899de3c7d3a563626f6/43a7d933c895d143afcf362a71f082025aaf0779.jpg",
                        imageLoader);
            }
        });
    }
}
