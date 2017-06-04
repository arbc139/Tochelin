package yonsei.xdesign.tochelin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import yonsei.xdesign.tochelin.databinding.SearchRestaurantCellViewBinding;
import yonsei.xdesign.tochelin.models.Restaurant;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Restaurant[] restaurants;
    SearchListActivity.SearchItemListener listener;

    public SearchListAdapter(Restaurant[] restaurants,
                             SearchListActivity.SearchItemListener listener) {
        this.restaurants = restaurants;
        this.listener = listener;
    }

    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SearchRestaurantCellViewBinding binding = SearchRestaurantCellViewBinding.inflate(
                inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Restaurant restaurant = restaurants[position];
        holder.bind(restaurant);
    }

    @Override
    public int getItemCount() {
        return restaurants.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        SearchRestaurantCellViewBinding binding;
        Restaurant restaurant;

        public ViewHolder(SearchRestaurantCellViewBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setOnClickListener(this);
            this.binding = binding;
        }

        public void bind(Restaurant restaurant) {
            this.restaurant = restaurant;
            binding.title.setText(restaurant.title);
            binding.location.setText(restaurant.location);
            binding.category.setText(restaurant.category);
            binding.reviewCount.setText(String.valueOf(restaurant.reviewCount));
            binding.score.setText(restaurant.score);

            String[] keywords = restaurant.keywords;
            if (keywords == null || keywords.length == 0) {
                binding.keywords.setVisibility(View.GONE);
                return;
            }
            binding.keywords.setVisibility(View.VISIBLE);
            if (keywords.length == 1) {
                binding.keyword1Image.setVisibility(View.VISIBLE);
                binding.keyword1.setText(keywords[0]);
                binding.keyword2Image.setVisibility(View.GONE);
                binding.keyword2.setVisibility(View.GONE);
            }
            if (keywords.length == 2) {
                binding.keyword1Image.setVisibility(View.VISIBLE);
                binding.keyword1.setText(keywords[0]);
                binding.keyword2Image.setVisibility(View.VISIBLE);
                binding.keyword2.setText(keywords[1]);
            }
        }

        @Override
        public void onClick(View view) {
            listener.onSearchItemClicked(restaurant);
            Toast.makeText(view.getContext(), "Restaurant clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
