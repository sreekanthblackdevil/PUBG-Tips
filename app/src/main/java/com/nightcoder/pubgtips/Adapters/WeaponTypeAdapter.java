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

import com.nightcoder.pubgtips.Models.WeaponTypeModel;
import com.nightcoder.pubgtips.R;
import com.nightcoder.pubgtips.WeaponsListActivity;

import java.util.List;

public class WeaponTypeAdapter extends RecyclerView.Adapter<WeaponTypeAdapter.ViewHolder> {

    private Context mContext;
    private List<WeaponTypeModel> mData;
    private boolean enableDarkMode;

    public WeaponTypeAdapter(Context context, List<WeaponTypeModel> list, boolean darkMode) {
        this.mContext = context;
        this.mData = list;
        this.enableDarkMode = darkMode;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_weapon_type_light, parent, false));
        } else {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_weapon_type_dark, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (enableDarkMode)
            return 1;
        else return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final WeaponTypeModel type = mData.get(position);
        holder.container.setVisibility(View.VISIBLE);
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.feature_item_animation));
        holder.text.setText(type.getText());
        holder.title.setText(type.getTitle());
        holder.imageView.setImageResource(type.getImageId());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type.getImageId()) {
                    case R.mipmap.assault_rifle:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class)
                                .putExtra("type", "AR"));
                        break;
                    case R.mipmap.shotgun:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class)
                                .putExtra("type", "SHOTGUN"));
                        break;
                    case R.mipmap.sniper:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class)
                                .putExtra("type", "SNIPER"));
                        break;
                    case R.mipmap.submachinegun:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class)
                                .putExtra("type", "SMG"));
                        break;
                    case R.mipmap.pistol:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class)
                                .putExtra("type", "PISTOL"));
                        break;
                    case R.mipmap.grenade:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class)
                                .putExtra("type", "GRENADE"));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title, text;
        private RelativeLayout container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            container = itemView.findViewById(R.id.container);
            container.setVisibility(View.GONE);
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);
        }
    }
}
