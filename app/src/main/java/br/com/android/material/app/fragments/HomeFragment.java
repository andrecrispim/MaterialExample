package br.com.android.material.app.fragments;

import android.support.v4.app.Fragment;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.android.material.R;
import br.com.android.material.app.adapters.AlbumTileAdapter;
import br.com.android.material.core.model.Album;

@EFragment(R.layout.fragment_albums)
public class HomeFragment extends Fragment {

    @ViewById(R.id.album_grid)
    protected GridView gridView;

    @Bean
    protected AlbumTileAdapter adapter;

    @AfterViews
    protected void initialize() {
        gridView.setAdapter(adapter);
        update();
    }

    private void update() {
        List<Album> movies = new ArrayList<>();

        Album album = new Album();
        album.setImage("bornthisway.jpg");
        album.setName("Born This Way");
        album.setArtist("Lady Gaga");
        movies.add(album);

        album = new Album();
        album.setImage("adele21.jpg");
        album.setName("Adele 21");
        album.setArtist("Adele");
        movies.add(album);

        album = new Album();
        album.setImage("motorhead.jpg");
        album.setName("Motorhead");
        album.setArtist("Motorhead");
        movies.add(album);

        album = new Album();
        album.setImage("nevermind.jpg");
        album.setName("Nevermind");
        album.setArtist("Nirvana");
        movies.add(album);

        album = new Album();
        album.setImage("ramones.jpg");
        album.setName("Ramones");
        album.setArtist("Ramones");
        movies.add(album);

        album = new Album();
        album.setImage("thebookofsouls.jpg");
        album.setName("The Book of Souls");
        album.setArtist("Iron Maiden");
        movies.add(album);

        album = new Album();
        album.setImage("thesmiths.jpg");
        album.setName("The Smiths");
        album.setArtist("The Smiths");
        movies.add(album);

        adapter.setItems(movies);
    }
}