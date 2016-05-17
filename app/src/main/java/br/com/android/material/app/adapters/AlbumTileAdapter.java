package br.com.android.material.app.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import br.com.android.material.app.adapters.views.AlbumTileView;
import br.com.android.material.app.adapters.views.AlbumTileView_;
import br.com.android.material.core.model.Album;

@EBean
public class AlbumTileAdapter extends BaseAdapter {

    @RootContext
    protected Context context;

    private List<Album> items;

    public void setItems(@Nullable List<Album> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public Album getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlbumTileView view;

        if (convertView == null) {
            view = AlbumTileView_.build(context);
        } else {
            view = (AlbumTileView) convertView;
        }

        view.bind(getItem(position));

        return view;
    }
}