package yonsei.xdesign.tochelin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import yonsei.xdesign.tochelin.models.Restaurant;

public class RestaurantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(getIntent());
    }

    private void initView(Intent intent) {
        Restaurant restaurant = intent.getParcelableExtra(
                IntentKeyMap.INTENT_KEY_SEARCH_TO_DETAIL_RESTAURANT_KEY);
        System.out.println(restaurant.id);
    }
}
