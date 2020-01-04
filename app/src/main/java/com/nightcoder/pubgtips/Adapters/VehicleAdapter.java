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

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.nightcoder.pubgtips.Models.Vehicles;
import com.nightcoder.pubgtips.R;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {

    private Context mContext;
    private List<Vehicles> mItems;
    private boolean darkMode;

    public VehicleAdapter(Context context, List<Vehicles> weapons, boolean mode) {
        this.darkMode = mode;
        this.mItems = weapons;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_vehicle, parent, false));
        else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_vehicle_dark, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Vehicles item = mItems.get(position);
        holder.title.setText(item.getTitle());
        holder.type.setText(item.getMap());
        holder.about.setText(item.getAbout());
        holder.image.setImageResource(item.getImageId());

        holder.container.setVisibility(View.VISIBLE);
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.feature_item_animation));

        holder.seatVal.setText(String.valueOf(item.getSeats()));
        holder.speedVal.setText(String.valueOf(item.getSpeed()));
        holder.healthVal.setText(String.valueOf(item.getHealth()));

        holder.speed.setProgress(item.getSpeed());
        holder.seats.setProgress(item.getSeats());
        holder.health.setProgress(item.getHealth());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (darkMode)
            return 1;
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, about, type, speedVal, seatVal, healthVal;
        private ImageView image;
        private RelativeLayout container;
        private RoundCornerProgressBar speed, seats, health;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            container = itemView.findViewById(R.id.container);
            container.setVisibility(View.GONE);
            about = itemView.findViewById(R.id.about);
            image = itemView.findViewById(R.id.image);
            type = itemView.findViewById(R.id.map);
            speedVal = itemView.findViewById(R.id.val_speed);
            seatVal = itemView.findViewById(R.id.val_seats);
            healthVal = itemView.findViewById(R.id.val_health);
            speed = itemView.findViewById(R.id.speed);
            seats = itemView.findViewById(R.id.seats);
            health = itemView.findViewById(R.id.health);
        }
    }
}
