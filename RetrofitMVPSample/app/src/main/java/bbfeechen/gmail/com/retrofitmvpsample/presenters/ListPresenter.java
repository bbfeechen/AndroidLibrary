package bbfeechen.gmail.com.retrofitmvpsample.presenters;

import bbfeechen.gmail.com.retrofitmvpsample.ListActivity;
import bbfeechen.gmail.com.retrofitmvpsample.models.Post;
import bbfeechen.gmail.com.retrofitmvpsample.services.ForumService;
import java.util.List;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author  : KAILIANG CHEN
 * Version : 0.1
 * Date    : 2/23/16
 */
public class ListPresenter {
    ListActivity mView;
    ForumService mForum;

    public ListPresenter(ListActivity view, ForumService forum) {
        mView = view;
        mForum = forum;
    }

    public void loadPosts() {
        mForum.getApi()
            .getPosts()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<Post>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<Post> posts) {

                    mView.displayPosts(posts);
                }
            });
    }
}
