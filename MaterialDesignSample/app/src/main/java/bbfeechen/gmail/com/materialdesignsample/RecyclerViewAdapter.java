package bbfeechen.gmail.com.materialdesignsample;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author  : KAILIANG CHEN
 * Version : 0.1
 * Date    : 3/1/16
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override public int getItemCount() {
        return 10;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_card_main, parent, false);
        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        final View view = holder.mView;
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationZ", 20, 0);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override public void onAnimationStart(Animator animation) {

                    }

                    @Override public void onAnimationEnd(Animator animation) {
                        mContext.startActivity(new Intent(mContext, DetailActivity.class));
                    }

                    @Override public void onAnimationCancel(Animator animation) {

                    }

                    @Override public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.start();
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
        }
    }
}
