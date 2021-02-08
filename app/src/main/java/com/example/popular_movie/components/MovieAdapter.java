package com.example.popular_movie.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.example.popular_movie.R;
import com.example.popular_movie.components.MovieAdapter.ItemViewHolder;
import com.example.popular_movie.database.PopularMovieModel;
import java.util.List;


class MovieAdapter extends RecyclerView.Adapter<ItemViewHolder>
{
    private LiveData<List<PopularMovieModel>> popularMovieList;
    private ListItemClickListener mListItemClickListener;

//    public MovieAdapter(LiveData<List<PopularMovieModel>> popularMovieList, ListItemClickListener clickListener)
    public MovieAdapter(LiveData<List<PopularMovieModel>> popularMovieList)
    {
        this.popularMovieList = popularMovieList;
        //mListItemClickListener = clickListener;
    }

//    public void setDataSource(int nSize){}

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
        TextView itemNumberTextView = holder.movieNameTextView;
        if(popularMovieList.getValue() != null) {
            itemNumberTextView
                    .setText(String.valueOf(position) + popularMovieList.getValue().get(position).getOriginalTitle());
        }
    }

    @Override
    public int getItemCount() {
        return this.popularMovieList.getValue() == null ? 0 : this.popularMovieList.getValue().size();
    }

    //caching view before binding.
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView movieNameTextView;

        // root view of the item in item.xml normally.
        public ItemViewHolder(final View itemView) {
            super(itemView);
            movieNameTextView = (TextView) itemView.findViewById(R.id.tv_movie_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
//            mListItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    interface  ListItemClickListener {
        // put unique primary key movie id and search for that in database
        public void onItemClick(int itemPosition);
    }
}