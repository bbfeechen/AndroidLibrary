package bbfeechen.gmail.com.volleysample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import bbfeechen.gmail.com.volleysample.R;
import bbfeechen.gmail.com.volleysample.util.VolleyApi;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

public class JsonRequestActivity extends BaseActivity {

    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnRequest = (Button) findViewById(R.id.btn_json_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest(new JsonObjectRequest(Request.Method.GET, VolleyApi.JSON_TEST, "",
                    responseListener(), errorListener()));
            }
        });
    }

    private Response.Listener<JSONObject> responseListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mTvResult.setText(response.toString());
            }
        };
    }
}
