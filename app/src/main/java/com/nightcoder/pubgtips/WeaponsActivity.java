package com.nightcoder.pubgtips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.nightcoder.pubgtips.Adapters.WeaponTypeAdapter;
import com.nightcoder.pubgtips.Models.WeaponTypeModel;
import com.nightcoder.pubgtips.Supports.Checks;

import java.util.ArrayList;

public class WeaponsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        if (Checks.isDarkMode(this)) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            addContents(true);
            toolbar.setBackground(getDrawable(R.drawable.toolbar_background_dark));
            window.setStatusBarColor(getResources().getColor(R.color.dark));
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            addContents(false);
            toolbar.setBackground(getDrawable(R.drawable.toolbar_background));
            window.setStatusBarColor(getResources().getColor(R.color.white));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        ImageButton share = findViewById(R.id.share_btn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        loadAds();
    }

    private void loadAds() {
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_id));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(adListener);
        AdView adView = findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());
    }

    private AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            interstitialAd.show();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        interstitialAd.setAdListener(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void addContents(boolean darkMode) {
        ArrayList<WeaponTypeModel> weapons = new ArrayList<>();

        weapons.add(new WeaponTypeModel(
                "Assault Rifles (AR)",
                getResources().getString(R.string.ar_description),
                R.mipmap.assault_rifle
        ));
        weapons.add(new WeaponTypeModel(
                "Shotguns",
                getResources().getString(R.string.sg_description),
                R.mipmap.shotgun
        ));
        weapons.add(new WeaponTypeModel(
                "Snipers & DMR",
                getResources().getString(R.string.sniper_description),
                R.mipmap.sniper
        ));
        weapons.add(new WeaponTypeModel(
                "Machine Guns (SMG & LMG)",
                getResources().getString(R.string.smg_description),
                R.mipmap.submachinegun
        ));
        weapons.add(new WeaponTypeModel(
                "Pistol",
                getResources().getString(R.string.pistol_description),
                R.mipmap.pistol
        ));
        weapons.add(new WeaponTypeModel(
                "Grenades",
                getResources().getString(R.string.grenade_description),
                R.mipmap.grenade
        ));
        weapons.add(new WeaponTypeModel(
                "Attachments",
                getResources().getString(R.string.attach_description),
                R.mipmap.rifle1
        ));

        WeaponTypeAdapter adapter = new WeaponTypeAdapter(this, weapons, darkMode);
        recyclerView.setAdapter(adapter);
    }
}
