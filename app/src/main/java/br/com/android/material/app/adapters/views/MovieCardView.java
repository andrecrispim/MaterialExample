package br.com.android.material.app.adapters.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.android.material.R;
import br.com.android.material.core.model.Movie;

@EViewGroup(R.layout.movie_card)
public class MovieCardView extends CardView {

    @ViewById(R.id.movie_widePoster)
    ImageView imageView;

    public MovieCardView(Context context) {
        super(context);
    }

    public void bind(@NonNull Movie movie) {
        String uri = "file:///android_asset/" + movie.getImage();
        Picasso.with(super.getContext()).load(uri).into(imageView);
    }
}
