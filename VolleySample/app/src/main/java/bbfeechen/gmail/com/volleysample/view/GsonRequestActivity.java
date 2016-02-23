package bbfeechen.gmail.com.volleysample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import bbfeechen.gmail.com.volleysample.R;
import bbfeechen.gmail.com.volleysample.model.GsonClass;
import bbfeechen.gmail.com.volleysample.model.GsonRequest;
import bbfeechen.gmail.com.volleysample.util.VolleyApi;
import com.android.volley.Response;
import com.google.gson.Gson;

public class GsonRequestActivity extends BaseActivity {

    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_request);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnRequest = (Button) findViewById(R.id.btn_gson_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest(new GsonRequest<GsonClass>(VolleyApi.GSON_TEST, GsonClass.class,
                    responseListener(), errorListener()));
            }
        });
    }

    private Response.Listener<GsonClass> responseListener() {
        return new Response.Listener<GsonClass>() {
            @Override
            public void onResponse(GsonClass response) {
                mTvResult.setText(new Gson().toJson(response));
            }
        };
    }
}
