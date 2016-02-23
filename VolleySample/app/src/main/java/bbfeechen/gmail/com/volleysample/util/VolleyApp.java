package bbfeechen.gmail.com.volleysample.util;

import android.app.Application;
import bbfeechen.gmail.com.volleysample.control.RequestManager;

/**
 * Author  : KAILIANG CHEN
 * Version : 0.1
 * Date    : 2/23/16
 */
public class VolleyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }


    private void init() {
        RequestManager.init(this);
    }
}
