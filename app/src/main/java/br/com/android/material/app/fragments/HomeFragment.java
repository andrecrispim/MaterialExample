package br.com.android.material.app.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.android.material.R;
import br.com.android.material.app.adapters.MovieCardAdapter;
import br.com.android.material.core.model.Movie;

@EFragment(R.layout.fragment_movies)
public class HomeFragment extends Fragment {

    @ViewById(R.id.movies_cards)
    protected RecyclerView recyclerView;

    @Bean
    protected MovieCardAdapter adapter;

    @AfterViews
    protected void initialize() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        update();
    }

    private void update() {
        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();
        movie.setImage("avengers.jpg");
        movie.setName("Avengers");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("hitman.jpg");
        movie.setName("Hitman");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("iron_man_3.jpg");
        movie.setName("Iron Man 3");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("jurassic_world.jpg");
        movie.setName("Jurassic World");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("looper.jpg");
        movie.setName("Looper");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("pacific_rim.jpg");
        movie.setName("Pacific Rim");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("skyfall_007.jpg");
        movie.setName("Skyfall");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("spectre_007.jpg");
        movie.setName("Spectre");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("star_wars.jpg");
        movie.setName("Star Wars - The Force Awakens");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("the_fantastic_four.jpg");
        movie.setName("The Fantastic Four");
        movies.add(movie);

        movie = new Movie();
        movie.setImage("the_martian.jpg");
        movie.setName("The Martian");
        movies.add(movie);

        adapter.setItems(movies);
    }
}
