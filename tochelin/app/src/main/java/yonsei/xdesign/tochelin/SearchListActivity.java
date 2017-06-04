package yonsei.xdesign.tochelin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import yonsei.xdesign.tochelin.databinding.SearchListActivityBinding;
import yonsei.xdesign.tochelin.models.ModelSampler;
import yonsei.xdesign.tochelin.models.Restaurant;

public class SearchListActivity extends AppCompatActivity {

    public interface SearchItemListener {
        void onSearchItemClicked(Restaurant restaurant);
    }

    private SearchListActivityBinding binding;
    private Restaurant[] restaurants = ModelSampler.getRestaurants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.search_list_activity);

        initView(getIntent());
    }

    private void initView(Intent intent) {
        String query = intent.getStringExtra(IntentKeyMap.INTENT_KEY_MAIN_TO_SEARCH_QUERY_KEY);
        binding.searchBar.setQuery(query, false);

        SearchListAdapter adapter = new SearchListAdapter(restaurants, new SearchItemListener() {
            @Override
            public void onSearchItemClicked(Restaurant restaurant) {
                initiateDetailActivity(restaurant);
            }
        });
        binding.restaurantList.setAdapter(adapter);
    }

    private void initiateDetailActivity(Restaurant restaurant) {
        System.out.println("InitiateDetailActivity");
        Intent intent = new Intent(this, RestaurantDetailActivity.class);
        intent.putExtra(
                IntentKeyMap.INTENT_KEY_SEARCH_TO_DETAIL_RESTAURANT_KEY, restaurant);
        startActivity(intent);
    }
}
