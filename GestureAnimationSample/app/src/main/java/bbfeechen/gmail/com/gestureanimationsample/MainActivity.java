package bbfeechen.gmail.com.gestureanimationsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchDemo(View v) {
        if (v.getId() == R.id.btnAnimationDemo) {
            startActivity(new Intent(this, AnimationDemoActivity.class));
        } else {
            startActivity(new Intent(this, GestureDemoActivity.class));
        }
    }
}
