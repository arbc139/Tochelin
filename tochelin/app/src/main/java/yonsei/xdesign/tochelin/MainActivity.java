package yonsei.xdesign.tochelin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;

import yonsei.xdesign.tochelin.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.searchBar.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra(IntentKeyMap.INTENT_KEY_MAIN_TO_SEARCH_QUERY_KEY, query);
        startActivity(intent);
        return true;
    }
}
