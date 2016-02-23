package bbfeechen.gmail.com.retrofitmvpsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import bbfeechen.gmail.com.retrofitmvpsample.adapters.PostsAdapter;
import bbfeechen.gmail.com.retrofitmvpsample.models.Post;
import bbfeechen.gmail.com.retrofitmvpsample.presenters.ListPresenter;
import bbfeechen.gmail.com.retrofitmvpsample.services.ForumService;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    @InjectView(R.id.listViewPosts) ListView mListViewPosts;

    PostsAdapter mPostsAdapter;

    ListPresenter mListPresenter;
    ForumService mForumService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.inject(this);

        ArrayList<Post> dummyPosts = new ArrayList<Post>();
        mPostsAdapter = new PostsAdapter(this, dummyPosts);
        mListViewPosts.setAdapter(mPostsAdapter);

        mForumService = new ForumService();
        mListPresenter = new ListPresenter(this, mForumService);
        mListPresenter.loadPosts();
    }

    @OnItemClick(R.id.listViewPosts)
    public void onPostSelect(int position) {

        Post p = mPostsAdapter.getItem(position);
        int postId = p.id;

        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("postId", postId);
        startActivity(detailIntent);
    }

    public void displayPosts(List<Post> posts) {

        mPostsAdapter.clear();
        mPostsAdapter.addAll(posts);
        mPostsAdapter.notifyDataSetInvalidated();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
