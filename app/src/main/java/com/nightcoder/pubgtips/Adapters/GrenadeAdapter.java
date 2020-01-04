package com.nightcoder.pubgtips.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nightcoder.pubgtips.Models.Grenades;
import com.nightcoder.pubgtips.R;

import java.util.List;

public class GrenadeAdapter extends RecyclerView.Adapter<GrenadeAdapter.ViewHolder> {

    private Context mContext;
    private List<Grenades> grenades;
    private boolean mode;

    public GrenadeAdapter(Context context, List<Grenades> grenades, boolean mode) {
        this.mContext = context;
        this.grenades = grenades;
        this.mode = mode;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1)
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.grenade_item_dark, parent, false));
        else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.grenade_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Grenades grenade = grenades.get(position);

        holder.about.setText(grenade.getAbout());
        holder.title.setText(grenade.getTitle());
        holder.image.setImageResource(grenade.getImageId());
        holder.container.setVisibility(View.VISIBLE);
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.feature_item_animation));
    }

    @Override
    public int getItemViewType(int position) {
        if (mode)
            return 1;
        else return 0;

    }

    @Override
    public int getItemCount() {
        return grenades.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, about;
        private ImageView image;
        private RelativeLayout container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            about = itemView.findViewById(R.id.about);
            container = itemView.findViewById(R.id.container);
            container.setVisibility(View.GONE);
        }
    }
}
