package com.yanxw.themechangesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yanxw.base.Constants;
import com.yanxw.base.utils.SPUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isNightMode = SPUtils.getInstance().getBoolean(Constants.IS_NIGHT_MODE, false);
        if (isNightMode) {
            setTheme(R.style.NightTheme);
        } else {
            setTheme(R.style.AppTheme);
        }

        setContentView(R.layout.activity_main);
    }

    public void changeTheme(View view) {
        boolean isNightMode = SPUtils.getInstance().getBoolean(Constants.IS_NIGHT_MODE, false);
        isNightMode = !isNightMode;
        SPUtils.getInstance().putBoolean(Constants.IS_NIGHT_MODE, isNightMode);
        recreate();
    }
}
