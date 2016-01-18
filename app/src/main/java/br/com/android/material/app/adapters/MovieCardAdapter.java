package br.com.android.material.app.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import br.com.android.material.app.adapters.views.MovieCardView;
import br.com.android.material.app.adapters.views.MovieCardView_;
import br.com.android.material.app.adapters.views.ViewHolder;
import br.com.android.material.core.model.Movie;

@EBean
public class MovieCardAdapter extends RecyclerView.Adapter<ViewHolder<MovieCardView>> {

    @RootContext
    protected Context context;

    private List<Movie> items;

    public void setItems(@Nullable List<Movie> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder<MovieCardView> onCreateViewHolder(ViewGroup parent, int viewType) {

        MovieCardView movieCardView = MovieCardView_.build(context);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        movieCardView.setLayoutParams(layoutParams);

        return new ViewHolder<>(movieCardView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder<MovieCardView> holder, int position) {
        Movie item = items.get(position);
        MovieCardView itemView = holder.getItemView();

        itemView.bind(item);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    @Nullable
    public Movie getItem(int position) {
        return items != null && items.size() > 0 ? items.get(position) : null;
    }
}
