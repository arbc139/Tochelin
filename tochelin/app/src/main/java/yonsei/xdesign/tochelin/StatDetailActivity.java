package yonsei.xdesign.tochelin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import yonsei.xdesign.tochelin.databinding.StatDetailActivityBinding;
import yonsei.xdesign.tochelin.models.Restaurant;
import yonsei.xdesign.tochelin.models.Stat;

public class StatDetailActivity extends AppCompatActivity {

    StatDetailActivityBinding binding;
    Restaurant restaurant;
    Stat stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(getIntent());
        initView();
    }

    private void initData(Intent intent) {
        restaurant = intent.getParcelableExtra(
                IntentKeyMap.INTENT_KEY_RESTAURANT_DETAIL_TO_STAT_DETAIL_RESTAURANT_KEY);
        stat = intent.getParcelableExtra(
                IntentKeyMap.INTENT_KEY_RESTAURANT_DETAIL_TO_STAT_DETAIL_STAT_KEY);
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.stat_detail_activity);
        binding.statTitle.setText(restaurant.title + " - " + stat.kind);
        binding.restaurantScore.setText(restaurant.score);
        binding.keywords.setTags(stat.keywords);
        ReviewListAdapter adapter = new ReviewListAdapter(stat.reviews);
        binding.reviews.setAdapter(adapter);
    }
}
