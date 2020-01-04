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

import com.nightcoder.pubgtips.Adapters.AttachmentAdapter;
import com.nightcoder.pubgtips.Adapters.GrenadeAdapter;
import com.nightcoder.pubgtips.Adapters.WeaponsAdapter;
import com.nightcoder.pubgtips.Models.Attachments;
import com.nightcoder.pubgtips.Models.Grenades;
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
            case "GRENADE":
                addGrenades(mode);
                title.setText("Best Grenades");
                break;
            case "ATTACHMENT":
                addAttachment(mode);
                title.setText("Attachments");
                break;
        }
    }

    private void addAttachment(boolean mode) {
        ArrayList<Attachments> attach = new ArrayList<>();
        attach.add(new Attachments("Flash Hider (AR)", "AKM, M16A4, M416, SCAR-L, S12K",
                R.mipmap.ar_fh, getResources().getString(R.string.ar_fh)));
        attach.add(new Attachments("Flash Hider (Sniper)", "M24, AWM, SKS, Kar98K",
                R.mipmap.sn_fh, getResources().getString(R.string.sn_fh)));
        attach.add(new Attachments("Flash Hider (SMG)", "Sub Machine Guns",
                R.mipmap.smg_fh, getResources().getString(R.string.smg_fh)));
        attach.add(new Attachments("Suppressor(AR)", "AR, S12K", R.mipmap.ar_sup,
                "Reduces firing sound and bullet echo.\n-5.00% Deviation"));
        attach.add(new Attachments("Suppressor(SMG)", "Sub Machine Guns", R.mipmap.smg_sup,
                "Reduces firing sound and bullet echo.\n-5.00% Deviation"));
        attach.add(new Attachments("Suppressor(Sniper)", "M24, AWM, SKS, Kar98K", R.mipmap.sn_sup,
                "Reduces firing sound and bullet echo.\n-5.00% Deviation"));
        attach.add(new Attachments("Suppressor(Pistol)", "Pistol", R.mipmap.pistol_sup,
                "Reduces firing sound and bullet echo.\n-5.00% Deviation"));
        attach.add(new Attachments("Compensator", "AKM, M16A4, M416, SCAR-L, S12K", R.mipmap.ar_comp,
                getResources().getString(R.string.ar_comp)));
        attach.add(new Attachments("Compensator (SMG)", "Sub Machine Guns", R.mipmap.smg_comp,
                getResources().getString(R.string.smg_comp)));
        attach.add(new Attachments("Compensator (Sniper)", "M24, AWM, SKS, Kar98K", R.mipmap.sniper_comp,
                getResources().getString(R.string.sn_comp)));
        attach.add(new Attachments("Angled Foregrip", "M416, SCAR-L, UMP9", R.mipmap.ar_af,
                getResources().getString(R.string.af)));
        attach.add(new Attachments("Vertical Foregrip", "M416, SCAR-L, UMP9, Vector", R.mipmap.ar_vf,
                getResources().getString(R.string.vf)));
        attach.add(new Attachments("Stock", "M416, Vector", R.mipmap.ar_stock,
                getResources().getString(R.string.stock)));
        attach.add(new Attachments("Stock for Micro UZI", "Micro UZI", R.mipmap.uzi_stock,
                getResources().getString(R.string.stock_uzi)));
        attach.add(new Attachments("Extended Mag", "AR", R.mipmap.ar_ext_mag,
                "-Increases magazine capacity"));
        attach.add(new Attachments("QuickDraw Mag", "AR", R.mipmap.ar_q_mag,
                "– 30.00% Reload Duration"));
        attach.add(new Attachments("Extended & QuickDraw Mag", "AR", R.mipmap.ar_ext_q_mag,
                "– 30.00% Reload Duration \n -Increases magazine capacity"));
        attach.add(new Attachments("Red Dot", "", R.mipmap.red_dor,
                "+20.00% Faster ADS\nSuitable for \n UMP9, AKM, M16A4, M416, SCAR-L, SKS, S12K, M249, " +
                        "Kar98k, M24, AWM, Crossbow, KRISS Vector"));
        attach.add(new Attachments("Holographic Sight", "", R.mipmap.holo_sight,
                "+20.00% Faster ADS\nSuitable for\n UMP9, AKM, M16A4, M416, SCAR-L, SKS, S12K, M249, " +
                        "Kar98k, M24, AWM, Crossbow, KRISS Vector"));
        attach.add(new Attachments("2X Aimpoint Scope", "", R.mipmap.s2x,
                "+10.00% Faster ADS\n 1.80X Magnification\nSuitable for\n UMP9, AKM, M16A4, M416, SCAR-L, SKS, " +
                        "S12K, M249, Kar98k, M24, AWM, Crossbow, KRISS Vector"));
        attach.add(new Attachments("4X ACCOG Scope", "", R.mipmap.s4x,
                "4.00X Magnification\nSuitable for \nUMP9, AKM, M16A4, M416, SCAR-L, SKS, S12K," +
                        " M249, Kar98k, M24, AWM, Crossbow, KRISS Vector"));
        attach.add(new Attachments("8X CQBSS Scope", "", R.mipmap.s8x,
                "7.25X Magnification\nSuitable for\nAKM, M16A4, M416, SCAR-L, SKS, S12K, M249, Kar98k, M24, AWM"));
        attach.add(new Attachments("15X PM II Scope", "", R.mipmap.s16x,
                "12.00X Magnification\nSuitable for\nAKM, M16A4, M416, SCAR-L, SKS, S12K, M249, Kar98k, M24, AWM"));
        attach.add(new Attachments("Check Pad", "Sniper Rifle", R.mipmap.check_pad,
                getResources().getString(R.string.check_pad)));
        attach.add(new Attachments("Bullet Loop", "S1897, S686", R.mipmap.bl_s,
                "Improved accuracy and stability.\n-30.00% Reload Duration"));
        attach.add(new Attachments("Bullet Loop", "Kar98k", R.mipmap.bl_k,
                getResources().getString(R.string.bl_k)));
        AttachmentAdapter adapter = new AttachmentAdapter(this, attach, mode);
        recyclerView.setAdapter(adapter);
    }

    private void addGrenades(boolean mode) {
        ArrayList<Grenades> grenade = new ArrayList<>();

        grenade.add(new Grenades("Frag Grenade", getResources().getString(R.string.frag_grenade), R.mipmap.frag));
        grenade.add(new Grenades("Stun Grenade", getResources().getString(R.string.stun_grenade), R.mipmap.stun_grenade));
        grenade.add(new Grenades("Moloto Cocktail", getResources().getString(R.string.moloto_cocktail), R.mipmap.moloto));
        grenade.add(new Grenades("Smoke Grenade", getResources().getString(R.string.smoke_grenade), R.mipmap.smoke));

        GrenadeAdapter adapter = new GrenadeAdapter(this, grenade, mode);
        recyclerView.setAdapter(adapter);
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
                "Mini 14", "Marksman Rifle", R.mipmap.mini14, "5.56",
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
                getString(R.string.win98)
        ));
        weapons.add(new Weapons(
                "SKS", "Marksman Rifle", R.mipmap.sks, "7.62",
                R.mipmap.b762, 55, 10, 800, 800, 0.090f, 7,
                getString(R.string.sks_description)
        ));
        weapons.add(new Weapons(
                "VSS", "Marksman Rifle", R.mipmap.vss, "9mm",
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
