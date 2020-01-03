package com.nightcoder.pubgtips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.nightcoder.pubgtips.Adapters.ContentAdapter;
import com.nightcoder.pubgtips.Models.Contents;

import java.util.ArrayList;

public class BasicActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton themeButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        themeButton = findViewById(R.id.theme_button);
        recyclerView = findViewById(R.id.recycler_view);
        toolbar = findViewById(R.id.toolbar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        if (getUserPrefs("darkMode").equals("true")) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        themeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDelegate().getLocalNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    setUserInfo("darkMode", "true");
                } else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    setUserInfo("darkMode", "false");
                }
            }
        });

        if (getDelegate().getLocalNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
            addContents(false);
            toolbar.setBackground(getDrawable(R.drawable.toolbar_background));
            window.setStatusBarColor(getResources().getColor(R.color.white));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            addContents(true);
            toolbar.setBackground(getDrawable(R.drawable.toolbar_background_dark));
            window.setStatusBarColor(getResources().getColor(R.color.dark));
        }
    }

    private String getUserPrefs(String key) {
        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        return preferences.getString(key, "false");
    }

    public void setUserInfo(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    private void addContents(boolean enableDark) {
        ArrayList<Contents> contents = new ArrayList<>();


        contents.add(new Contents(
                "Get Started",
                getResources().getString(R.string.get_start_text),
                "Go to Get Started",
                R.mipmap.pubg_logo));

        contents.add(new Contents(
                "Tips for PUBG Mobile",
                getResources().getString(R.string.tips_text),
                "Go to PUBG Guide",
                R.mipmap.headshot));

        contents.add(new Contents(
                "Best Weapons in PUBG",
                getResources().getString(R.string.weapon_tire_list_text),
                "Find best Weapons",
                R.mipmap.rifle));



        ContentAdapter contentAdapter = new ContentAdapter(this, contents, enableDark);
        recyclerView.setAdapter(contentAdapter);
    }
}
