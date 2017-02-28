package com.yanxw.compattheme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.yanxw.base.Constants;
import com.yanxw.base.utils.SPUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeTheme(View view) {
        boolean isNightMode = SPUtils.getInstance().getBoolean(Constants.IS_NIGHT_MODE, false);
        isNightMode = !isNightMode;
        SPUtils.getInstance().putBoolean(Constants.IS_NIGHT_MODE, isNightMode);

        if (!isNightMode) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
