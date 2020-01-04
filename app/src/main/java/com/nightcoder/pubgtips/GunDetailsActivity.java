package com.nightcoder.pubgtips;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.nightcoder.pubgtips.Models.Weapons;
import com.nightcoder.pubgtips.Supports.Checks;

public class GunDetailsActivity extends AppCompatActivity {


    private InterstitialAd interstitialAd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (!Checks.isDarkMode(this)) {
            setContentView(R.layout.activity_gun_details);
            window.setStatusBarColor(getResources().getColor(R.color.white));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            setContentView(R.layout.activity_gun_details_dark);
            window.setStatusBarColor(getResources().getColor(R.color.dark));
        }

        loadAds();

        TextView title = findViewById(R.id.title);
        TextView ammo_gauge = findViewById(R.id.ammo_gauge);
        TextView type = findViewById(R.id.type);
        TextView about = findViewById(R.id.description);
        TextView damage_val = findViewById(R.id.val_damage);
        TextView range_val = findViewById(R.id.val_range);
        TextView rate_val = findViewById(R.id.val_rate);
        TextView speed_val = findViewById(R.id.val_speed);
        TextView mag_val = findViewById(R.id.val_mag);
        TextView rank = findViewById(R.id.rank);
        ImageView image = findViewById(R.id.image);
        ImageView ammo = findViewById(R.id.ammo_image);
        RoundCornerProgressBar damage = findViewById(R.id.damage);
        RoundCornerProgressBar range = findViewById(R.id.range);
        RoundCornerProgressBar mag = findViewById(R.id.mag);
        RoundCornerProgressBar speed = findViewById(R.id.speed);
        RoundCornerProgressBar fire = findViewById(R.id.rate);
        Weapons weapon = (Weapons) getIntent().getSerializableExtra("weapon");

        assert weapon != null;
        title.setText(weapon.getTitle());
        about.setText(weapon.getDescription());
        image.setImageResource(weapon.getWeaponImageId());
        ammo.setImageResource(weapon.getAmmoImageId());
        type.setText(weapon.getType());
        ammo_gauge.setText(weapon.getAmmoGuage());
        rank.setText("Rank: " + weapon.getRank());
        damage.setProgress(weapon.getDamage());
        range.setProgress(weapon.getRange());
        mag.setProgress(weapon.getMagazineCapacity());
        speed.setProgress(weapon.getBulletSpeed());
        fire.setProgress(weapon.getFireRate());
        damage_val.setText(String.valueOf(weapon.getDamage()));
        range_val.setText(String.valueOf(weapon.getRange()));
        mag_val.setText(String.valueOf(weapon.getMagazineCapacity()));
        speed_val.setText(String.valueOf(weapon.getBulletSpeed()));
        rate_val.setText(String.valueOf(weapon.getFireRate()));

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
    public void onBackPressed() {
        super.onBackPressed();
        interstitialAd.setAdListener(null);
    }
}
