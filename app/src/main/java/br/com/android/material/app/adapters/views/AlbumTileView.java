package br.com.android.material.app.adapters.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.android.material.R;
import br.com.android.material.core.model.Album;

@EViewGroup(R.layout.album)
public class AlbumTileView extends LinearLayout {

    @ViewById(R.id.album_infoLayout)
    RelativeLayout albumInfoLayout;

    @ViewById(R.id.album_image)
    ImageView imageView;

    @ViewById(R.id.album_artist)
    TextView artistView;

    @ViewById(R.id.album_name)
    TextView nameView;

    public AlbumTileView(Context context) {
        super(context);
    }

    public void bind(@NonNull Album album) {
        String uri = "file:///android_asset/" + album.getImage();
        Picasso.with(super.getContext()).load(uri).into(imageView, imageLoadCallback);
        artistView.setText(album.getArtist());
        nameView.setText(album.getName());
    }

    Callback imageLoadCallback = new Callback() {
        @Override
        public void onSuccess() {
            Bitmap innerBitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            Palette.from(innerBitmap).generate(paletteListener);
        }

        @Override
        public void onError() {
        }
    };

    Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
        @Override
        public void onGenerated(Palette palette) {
            Palette.Swatch swatch = palette.getVibrantSwatch();

            if (swatch == null) {
                swatch = palette.getLightVibrantSwatch();
            }

            if (swatch == null) {
                swatch = palette.getDarkMutedSwatch();
            }

            if (swatch != null) {
                albumInfoLayout.setBackgroundColor(swatch.getRgb());
                nameView.setTextColor(swatch.getTitleTextColor());
                artistView.setTextColor(swatch.getTitleTextColor());
            }
        }
    };
}