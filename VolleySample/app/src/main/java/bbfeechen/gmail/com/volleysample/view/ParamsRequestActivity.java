package bbfeechen.gmail.com.volleysample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import bbfeechen.gmail.com.volleysample.R;
import bbfeechen.gmail.com.volleysample.model.ApiParams;
import bbfeechen.gmail.com.volleysample.util.VolleyApi;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.Map;

public class ParamsRequestActivity extends BaseActivity {
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params_request);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnRequest = (Button) findViewById(R.id.btn_params_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest(new StringRequest(Request.Method.POST, VolleyApi.POST_TEST, responseListener(),
                    errorListener()) {
                    protected Map<String, String> getParams() {
                        return new ApiParams().with("param1", "02").with("param2", "14");
                    }
                });
            }
        });
    }

    private Response.Listener<String> responseListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTvResult.setText(response);
            }
        };
    }
}
