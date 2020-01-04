package com.nightcoder.pubgtips.Adapters;

import android.content.Context;
import android.content.Intent;
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
import com.nightcoder.pubgtips.GunDetailsActivity;
import com.nightcoder.pubgtips.Models.Attachments;
import com.nightcoder.pubgtips.Models.Weapons;
import com.nightcoder.pubgtips.R;

import java.util.List;

public class AttachmentAdapter extends RecyclerView.Adapter<AttachmentAdapter.ViewHolder> {

    private Context mContext;
    private List<Attachments> mWeapons;
    private boolean darkMode;

    public AttachmentAdapter(Context context, List<Attachments> weapons, boolean mode) {
        this.darkMode = mode;
        this.mWeapons = weapons;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_attachment, parent, false));
        else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_attachment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Attachments weapon = mWeapons.get(position);
        holder.title.setText(weapon.getTitle());
        holder.type.setText(weapon.getType());
        holder.about.setText(weapon.getAbout());
        holder.image.setImageResource(weapon.getImageId());

        holder.container.setVisibility(View.VISIBLE);
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.feature_item_animation));
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

        private TextView title, about, type;
        private ImageView image;
        private RelativeLayout container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            container = itemView.findViewById(R.id.container);
            container.setVisibility(View.GONE);
            about = itemView.findViewById(R.id.about);
            image = itemView.findViewById(R.id.image);
            type = itemView.findViewById(R.id.type);
        }
    }
}
