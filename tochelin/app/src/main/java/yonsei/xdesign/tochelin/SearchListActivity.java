package yonsei.xdesign.tochelin;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import yonsei.xdesign.tochelin.databinding.SearchListActivityBinding;

public class SearchListActivity extends AppCompatActivity {

    private SearchListActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
    }
}
