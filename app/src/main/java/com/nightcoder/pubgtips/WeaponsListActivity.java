package com.nightcoder.pubgtips;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nightcoder.pubgtips.Adapters.WeaponsAdapter;
import com.nightcoder.pubgtips.Models.Weapons;
import com.nightcoder.pubgtips.Supports.Checks;

import java.util.ArrayList;

public class WeaponsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        title = findViewById(R.id.title);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        if (Checks.isDarkMode(this)) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            addContent(true);
            toolbar.setBackground(getDrawable(R.drawable.toolbar_background_dark));
            window.setStatusBarColor(getResources().getColor(R.color.dark));
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            addContent(false);
            toolbar.setBackground(getDrawable(R.drawable.toolbar_background));
            window.setStatusBarColor(getResources().getColor(R.color.white));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void addContent(boolean mode) {
        String type = getIntent().getStringExtra("type");
        assert type != null;
        switch (type) {
            case "AR":
                addAR(mode);
                title.setText("Best Assault Rifles (AR)");
                break;
            case "SHOTGUN":
                addShotGun(mode);
                title.setText("Best Shotguns");
                break;
            case "SNIPER":
                addSnipers(mode);
                title.setText("Best Snipers");
                break;
            case "SMG":
                addSMG(mode);
                title.setText("Best Machine Guns");
                break;
            case "PISTOL":
                addPistol(mode);
                title.setText("Best Pistols");
                break;
        }
    }

    private void addAR(boolean mode) {
        ArrayList<Weapons> weapons = new ArrayList<>();

        weapons.add(new Weapons(
                "Groza", "Assault Rifle (AR)", R.mipmap.groza, "7.62",
                R.mipmap.b762, 48, 30, 400, 715, 0.080f, 1,
                getString(R.string.groza_description)
        ));
        weapons.add(new Weapons(
                "AKM", "Assault Rifle (AR)", R.mipmap.akm, "7.62",
                R.mipmap.b762, 48, 30, 400, 715, 0.100f, 2,
                getString(R.string.akm_description)
        ));
        weapons.add(new Weapons(
                "SCAR-L", "Assault Rifle (AR)", R.mipmap.scar_l, "5.56",
                R.mipmap.b556, 41, 30, 600, 870, 0.096f, 3,
                getString(R.string.scarl_description)
        ));
        weapons.add(new Weapons(
                "M16A4", "Assault Rifle (AR)", R.mipmap.m16a4, "5.56",
                R.mipmap.b556, 41, 30, 600, 900, 0.075f, 4,
                getString(R.string.m16a4_description)
        ));
        weapons.add(new Weapons(
                "M416", "Assault Rifle (AR)", R.mipmap.m416, "5.56",
                R.mipmap.b556, 41, 30, 600, 880, 0.086f, 5,
                getString(R.string.m416_description)
        ));
        WeaponsAdapter adapter = new WeaponsAdapter(this, weapons, mode);
        recyclerView.setAdapter(adapter);
    }

    private void addShotGun(boolean mode) {
        ArrayList<Weapons> weapons = new ArrayList<>();

        weapons.add(new Weapons(
                "S12K", "Shotgun", R.mipmap.siga12, "12 Gauge",
                R.mipmap.b12g, 22, 5, 25, 350, 0.250f, 1,
                getString(R.string.s12k_description)
        ));
        weapons.add(new Weapons(
                "S1897", "Shotgun", R.mipmap.s1897, "12 Gauge",
                R.mipmap.b12g, 25, 5, 25, 360, 0.750f, 2,
                getString(R.string.s1897_description)
        ));
        weapons.add(new Weapons(
                "S686", "Shotgun", R.mipmap.s686, "12 Gauge",
                R.mipmap.b12g, 25, 2, 25, 370, 0.200f, 1,
                getString(R.string.s12k_description)
        ));
        WeaponsAdapter adapter = new WeaponsAdapter(this, weapons, mode);
        recyclerView.setAdapter(adapter);
    }

    private void addSnipers(boolean mode) {
        ArrayList<Weapons> weapons = new ArrayList<>();

        weapons.add(new Weapons(
                "AWM", "Sniper", R.mipmap.awm, ".300",
                R.mipmap.b300, 132, 5, 1000, 910, 1.850f, 1,
                getString(R.string.awm_description)
        ));
        weapons.add(new Weapons(
                "MK14", "Marksman Rifle", R.mipmap.mk14, "7.62",
                R.mipmap.b762, 60, 10, 800, 853, 0.090f, 2,
                getString(R.string.mk14_description)
        ));
        weapons.add(new Weapons(
                "M24", "Sniper", R.mipmap.m24, "7.62",
                R.mipmap.b762, 82, 5, 800, 790, 1.800f, 3,
                getString(R.string.m24_description)
        ));
        weapons.add(new Weapons(
                "Mini 14", "Sniper", R.mipmap.mini14, "5.56",
                R.mipmap.b556, 44, 20, 600, 990, 0.100f, 4,
                getString(R.string.mini14_description)
        ));
        weapons.add(new Weapons(
                "Kar98k", "Sniper", R.mipmap.kar98k, "7.62",
                R.mipmap.b762, 72, 5, 600, 760, 1.900f, 5,
                getString(R.string.kar98_description)
        ));
        weapons.add(new Weapons(
                "Win94", "Sniper", R.mipmap.win98, ".45",
                R.mipmap.b45, 72, 8, 200, 760, 1.900f, 6,
                getString(R.string.weapon_tire_list_text)
        ));
        weapons.add(new Weapons(
                "SKS", "Sniper", R.mipmap.sks, "7.62",
                R.mipmap.b762, 55, 10, 800, 800, 0.090f, 7,
                getString(R.string.sks_description)
        ));
        weapons.add(new Weapons(
                "VSS", "Sniper", R.mipmap.vss, "9mm",
                R.mipmap.b9mm, 35, 10, 100, 330, 0.086f, 8,
                getString(R.string.vss_description)
        ));
        WeaponsAdapter adapter = new WeaponsAdapter(this, weapons, mode);
        recyclerView.setAdapter(adapter);
    }

    private void addSMG(boolean mode) {
        ArrayList<Weapons> weapons = new ArrayList<>();

        weapons.add(new Weapons(
                "M249", "Light bMachine Gun (LMG)", R.mipmap.m249, "5.56",
                R.mipmap.b556, 44, 100, 500, 915, 0.075f, 1,
                getString(R.string.m249_description)
        ));
        weapons.add(new Weapons(
                "Micro UZI", "SubMachine Gun (SMG)", R.mipmap.uzi, "9mm",
                R.mipmap.b9mm, 23, 25, 200, 350, 0.048f, 2,
                getString(R.string.uzi_description)
        ));
        weapons.add(new Weapons(
                "Vector", "SubMachine Gun (SMG)", R.mipmap.vector, ".45",
                R.mipmap.b45, 31, 13, 50, 300, 0.055f, 3,
                getString(R.string.vector_description)
        ));
        weapons.add(new Weapons(
                "DP-28", "Light Machine Gun (LMG)", R.mipmap.dp28, "7.62",
                R.mipmap.b762, 49, 47, 300, 350, 0.048f, 4,
                getString(R.string.dp28_description)
        ));
        weapons.add(new Weapons(
                "Tommy Gun", "SubMachine Gun (SMG)", R.mipmap.tommy_gun, ".45",
                R.mipmap.b45, 38, 100, 200, 280, 0.086f, 5,
                getString(R.string.tommy_description)
        ));
        weapons.add(new Weapons(
                "UMP9", "SubMachine Gun (SMG)", R.mipmap.ump9, "9mm",
                R.mipmap.b9mm, 35, 30, 300, 400, 0.092f, 6,
                getString(R.string.ump9_description)
        ));

        WeaponsAdapter adapter = new WeaponsAdapter(this, weapons, mode);
        recyclerView.setAdapter(adapter);
    }

    private void addPistol(boolean mode) {
        ArrayList<Weapons> weapons = new ArrayList<>();

        weapons.add(new Weapons(
                "P18C", "Pistol", R.mipmap.p18c, "9mm",
                R.mipmap.b9mm, 19, 17, 25, 375, 0.060f, 1,
                getString(R.string.p18c_description)
        ));
        weapons.add(new Weapons(
                "P92", "Pistol", R.mipmap.p92, "9mm",
                R.mipmap.b9mm, 29, 7, 25, 380, 0.110f, 2,
                getString(R.string.p92_description)
        ));
        weapons.add(new Weapons(
                "P1911", "Pistol", R.mipmap.p18c, ".45",
                R.mipmap.b45, 35, 15, 25, 250, 0.090f, 3,
                getString(R.string.p1911_description)
        ));
        weapons.add(new Weapons(
                "R1895", "Pistol", R.mipmap.r1895, "7.62",
                R.mipmap.b762, 45, 7, 25, 330, 0.400f, 4,
                getString(R.string.r1895_description)
        ));
        WeaponsAdapter adapter = new WeaponsAdapter(this, weapons, mode);
        recyclerView.setAdapter(adapter);
    }
}
