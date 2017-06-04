package yonsei.xdesign.tochelin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import yonsei.xdesign.tochelin.databinding.RestaurantDetailActivityBinding;
import yonsei.xdesign.tochelin.models.Restaurant;
import yonsei.xdesign.tochelin.models.Stat;

public class RestaurantDetailActivity extends AppCompatActivity implements View.OnClickListener {

    RestaurantDetailActivityBinding binding;
    Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(getIntent());
        initView();
    }

    private void initData(Intent intent) {
        restaurant = intent.getParcelableExtra(
                IntentKeyMap.INTENT_KEY_SEARCH_TO_RESTAURANT_DETAIL_RESTAURANT_KEY);
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.restaurant_detail_activity);
        binding.restaurantTitle.setText(restaurant.title);
        binding.restaurantScore.setText(restaurant.score);
        binding.keywords.setTags(restaurant.keywords);
        setStatsView(restaurant.stats);
        binding.statDetail1.setOnClickListener(this);
        binding.statDetail2.setOnClickListener(this);
        binding.statDetail3.setOnClickListener(this);
        binding.statDetail4.setOnClickListener(this);
        binding.statDetail5.setOnClickListener(this);
        binding.statDetail6.setOnClickListener(this);
    }

    private void setStatsView(Stat[] stats) {
        final List<RadarEntry> entries = new ArrayList<>();
        final List<String> labels = new ArrayList<>();
        for (Stat stat: stats) {
            RadarEntry entry = new RadarEntry((float) stat.score, stat.kind);
            entries.add(entry);
            labels.add(stat.kind);
        }
        RadarDataSet dataSet = new RadarDataSet(entries, "1233");
        dataSet.setDrawIcons(false);
        dataSet.setDrawValues(false);
        dataSet.setDrawFilled(false);
        dataSet.setColor(getResources().getColor(R.color.colorAccent));
        dataSet.setLineWidth(3);
        dataSet.setDrawHighlightCircleEnabled(false);
        RadarData data = new RadarData(dataSet);
        // TODO(totoro): Find way to change label.
        data.setLabels(labels);
        binding.stats.setData(data);
        binding.stats.getData().setLabels(labels);
        binding.stats.getDescription().setEnabled(false);
        binding.stats.getLegend().setEnabled(false);
        YAxis axis = binding.stats.getYAxis();
        axis.setGranularity(1f);
        axis.setAxisMaximum(5);
        axis.setAxisMinimum(0);
        axis.setTextSize(12f);
        axis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(Math.round(value));
            }
        });
        binding.stats.invalidate();
    }

    @Override
    public void onClick(View view) {
        Stat stat = null;
        switch (view.getId()) {
            case R.id.stat_detail_1:
                stat = restaurant.stats[0];
                break;
            case R.id.stat_detail_2:
                stat = restaurant.stats[1];
                break;
            case R.id.stat_detail_3:
                stat = restaurant.stats[2];
                break;
            case R.id.stat_detail_4:
                stat = restaurant.stats[3];
                break;
            case R.id.stat_detail_5:
                stat = restaurant.stats[4];
                break;
            case R.id.stat_detail_6:
                stat = restaurant.stats[5];
                break;
            default:
                throw new RuntimeException();
        }
        Intent intent = new Intent(this, StatDetailActivity.class);
        intent.putExtra(
                IntentKeyMap.INTENT_KEY_RESTAURANT_DETAIL_TO_STAT_DETAIL_RESTAURANT_KEY, restaurant);
        intent.putExtra(
                IntentKeyMap.INTENT_KEY_RESTAURANT_DETAIL_TO_STAT_DETAIL_STAT_KEY, stat);
        startActivity(intent);
    }
}
