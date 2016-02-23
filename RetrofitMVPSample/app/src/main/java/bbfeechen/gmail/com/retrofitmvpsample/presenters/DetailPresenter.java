package bbfeechen.gmail.com.retrofitmvpsample.presenters;

import bbfeechen.gmail.com.retrofitmvpsample.DetailActivity;
import bbfeechen.gmail.com.retrofitmvpsample.models.Comment;
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
public class DetailPresenter {
    DetailActivity mView;
    ForumService mForum;

    public DetailPresenter(DetailActivity activity, ForumService forum) {
        mView = activity;
        mForum = forum;
    }

    public void loadPost() {
        mForum.getApi()
            .getPost(mView.getPostId())
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Post>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Post post) {
                    mView.displayPost(post);
                }
            });
    }

    public void loadComments() {
        mForum.getApi()
            .getComments(mView.getPostId())
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<Comment>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<Comment> comments) {
                    mView.displayComments(comments);
                }
            });
    }

}
