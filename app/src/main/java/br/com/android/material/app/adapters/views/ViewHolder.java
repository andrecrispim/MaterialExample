package br.com.android.material.app.adapters.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder
 *
 * A ViewHolder describes an item view and metadata about its place within a RecyclerView.
 *
 * @author andre.moreira
 */
public class ViewHolder<T extends View> extends RecyclerView.ViewHolder {

    private T itemView;

    /**
     * Constructor
     *
     * @param itemView Item view
     */
    public ViewHolder(T itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    /**
     * @return Item view
     */
    public T getItemView() {
        return itemView;
    }
}