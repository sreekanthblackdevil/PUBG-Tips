package com.nightcoder.pubgtips.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nightcoder.pubgtips.GetStartActivity;
import com.nightcoder.pubgtips.Models.Contents;
import com.nightcoder.pubgtips.R;
import com.nightcoder.pubgtips.TipsActivity;
import com.nightcoder.pubgtips.WeaponsActivity;
import com.nightcoder.pubgtips.WeaponsListActivity;

import java.util.List;


public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private List<Contents> mContents;
    private Context mContext;
    private boolean isDarkMod;

    private final int DARK_MODE_YES = 1;
    private final int DARK_MODE_NO = 0;

    public ContentAdapter(Context context, List<Contents> contents, boolean mode) {
        this.mContents = contents;
        this.mContext = context;
        this.isDarkMod = mode;
    }

    @NonNull
    @Override
    public ContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == DARK_MODE_NO)
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_front_content, parent, false));
        else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_front_content_dark, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        if (isDarkMod)
            return DARK_MODE_YES;
        else return DARK_MODE_NO;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.ViewHolder holder, int position) {
        final Contents content = mContents.get(position);

        holder.imageView.setImageResource(content.getImageId());
        holder.text.setText(content.getText());
        holder.title.setText(content.getTitel());
        holder.button.setText(content.getButtonName());
        holder.container.setVisibility(View.VISIBLE);
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.feature_item_animation));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (content.getImageId()) {
                    case R.mipmap.pubg_logo:
                        mContext.startActivity(new Intent(mContext, GetStartActivity.class));
                        break;
                    case R.mipmap.headshot:
                        mContext.startActivity(new Intent(mContext, TipsActivity.class));
                        break;
                    case R.mipmap.rifle:
                        mContext.startActivity(new Intent(mContext, WeaponsActivity.class));
                        break;
                    case R.mipmap.car:
                        mContext.startActivity(new Intent(mContext, WeaponsListActivity.class).putExtra("type", "VEHICLE"));
                        break;

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mContents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private Button button;
        private TextView title, text;
        private RelativeLayout container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.container);
            container.setVisibility(View.GONE);
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);
            button = itemView.findViewById(R.id.button);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
