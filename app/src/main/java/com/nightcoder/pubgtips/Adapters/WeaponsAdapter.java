package com.nightcoder.pubgtips.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.nightcoder.pubgtips.GunDetailsActivity;
import com.nightcoder.pubgtips.Models.Weapons;
import com.nightcoder.pubgtips.R;

import java.util.List;

public class WeaponsAdapter extends RecyclerView.Adapter<WeaponsAdapter.ViewHolder> {

    private Context mContext;
    private List<Weapons> mWeapons;
    private boolean darkMode;

    public WeaponsAdapter(Context context, List<Weapons> weapons, boolean mode) {
        this.darkMode = mode;
        this.mWeapons = weapons;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.weapon_item, parent, false));
        else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.weapon_item_dark, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Weapons weapon = mWeapons.get(position);
        holder.title.setText(weapon.getTitle());
        holder.range.setProgress(weapon.getRange());
        holder.damage.setProgress(weapon.getDamage());
        holder.gun.setImageResource(weapon.getWeaponImageId());
        holder.ammo.setImageResource(weapon.getAmmoImageId());
        holder.ammoName.setText(weapon.getAmmoGuage());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, GunDetailsActivity.class)
                .putExtra("weapon", weapon));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWeapons.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (darkMode)
            return 1;
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, ammoName;
        private ImageView ammo, gun;
        private RoundCornerProgressBar damage, range;
        private RelativeLayout container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            damage = itemView.findViewById(R.id.damage);
            range = itemView.findViewById(R.id.range);
            title = itemView.findViewById(R.id.title);
            container = itemView.findViewById(R.id.container);
            ammo = itemView.findViewById(R.id.bullet);
            gun = itemView.findViewById(R.id.gun);
            ammoName = itemView.findViewById(R.id.ammo_name);
        }
    }
}
