package com.example.popular_movie.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.example.popular_movie.R;
import com.example.popular_movie.components.MovieAdapter.ItemViewHolder;
import com.example.popular_movie.database.MovieModel;
import java.util.List;


class MovieAdapter extends RecyclerView.Adapter<ItemViewHolder>
{
    private LiveData<List<MovieModel>> mPopularMovieList;
    private ListItemClickListener mListItemClickListener;

    public MovieAdapter(LiveData<List<MovieModel>> popularMovieList, ListItemClickListener clickListener)
    {
        this.mPopularMovieList = popularMovieList;
        this.mListItemClickListener = clickListener;
    }

    // create view holders to cache inflated views in
    @Override
    public ItemViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        // parent viewgroup is a dummy root viewgroup container to hold all the view holders.
        View itemListRoot = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_poster_list_item, parent, false);

        //instantiating ViewHolder
        ItemViewHolder viewHolder = new ItemViewHolder(itemListRoot);
        return viewHolder;
    }

    /*
    bind image views with GLIDE
     */
    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        TextView itemNumberTextView = holder.mMovieNameTextView;
        if(mPopularMovieList.getValue() != null) {
            itemNumberTextView
                    .setText(String.valueOf(position) + mPopularMovieList.getValue().get(position).getOriginalTitle());
        }
    }

    @Override
    public int getItemCount() {
        return this.mPopularMovieList.getValue() == null ? 0 : this.mPopularMovieList.getValue().size();
    }

    //caching view before binding.
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mMovieNameTextView;

        // root view of the item in item.xml normally.
        public ItemViewHolder(final View itemView) {
            super(itemView);
            mMovieNameTextView = (TextView) itemView.findViewById(R.id.tv_movie_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            //depreciated need to figure out later.
            int position = getAdapterPosition();
            int dbId = mPopularMovieList.getValue().get(position).getDbId();
            MovieAdapter.this.mListItemClickListener.onItemClick(dbId);
        }
    }

    interface  ListItemClickListener {
        // put unique primary key movie id and search for that in database
        public void onItemClick(int dbId);
    }
}