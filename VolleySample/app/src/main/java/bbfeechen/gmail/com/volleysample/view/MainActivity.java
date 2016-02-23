package bbfeechen.gmail.com.volleysample.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import bbfeechen.gmail.com.volleysample.R;
import bbfeechen.gmail.com.volleysample.model.ActivityInfo;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private List<ActivityInfo> mData = Arrays.asList(
        new ActivityInfo("SimpleRequest", SimpleRequestActivity.class),
        new ActivityInfo("JsonRequest", JsonRequestActivity.class),
        new ActivityInfo("PostParamsRequest", ParamsRequestActivity.class),
        new ActivityInfo("GsonRequest", GsonRequestActivity.class),
        new ActivityInfo("ImageLoading", ImageLoadingActivity.class));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<ActivityInfo>(this,
            android.R.layout.simple_list_item_1, mData));
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent intent = new Intent(activity, mData.get(arg2).name);
        startActivity(intent);
    }
}
