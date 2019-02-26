package com.fryanramzkhar.mvpstadiumapi.UI.Stadium;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;
import com.fryanramzkhar.mvpstadiumapi.R;
import com.fryanramzkhar.mvpstadiumapi.UI.Detail.DetailPresenter;
import com.fryanramzkhar.mvpstadiumapi.Utils.Constant;

import java.util.List;

import butterknife.BindView;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.ViewHolder> {


    private Context context;
    private List<StadiumItem> stadiumItemList;

    public StadiumAdapter(Context context, List<StadiumItem> stadiumItemList) {
        this.context = context;
        this.stadiumItemList = stadiumItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_stadium, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final StadiumItem stadiumItem = stadiumItemList.get(i);

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken).placeholder(R.drawable.ic_broken);
        Glide.with(context).load(stadiumItem.getStrImageStadium()).apply(options).into(viewHolder.imgLogoStadium);
        viewHolder.txtNameStadium.setText(stadiumItem.getStrStadium());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailPresenter.class).putExtra(Constant.KEY_DATA, stadiumItem));
            }
        });
    }

    @Override
    public int getItemCount() {
        return stadiumItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_stadium)
        ImageView imgLogoStadium;
        @BindView(R.id.txt_name_stadium)
        TextView txtNameStadium;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
