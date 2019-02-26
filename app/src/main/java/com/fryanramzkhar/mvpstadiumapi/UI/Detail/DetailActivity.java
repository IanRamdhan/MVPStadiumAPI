package com.fryanramzkhar.mvpstadiumapi.UI.Detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;
import com.fryanramzkhar.mvpstadiumapi.R;
import com.fryanramzkhar.mvpstadiumapi.UI.Stadium.StadiumPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailContract.View{

    @BindView(R.id.img_stadium_detail)
    ImageView imgStadiumDetail;
    @BindView(R.id.txt_name_stadium_detail)
    TextView txtNameStadiumDetail;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.card_view_detail)
    CardView cardViewDetail;
    @BindView(R.id.sv_detail)
    ScrollView svDetail;

    private Menu menu;
    private StadiumItem stadiumItem;

    private DetailPresenter detailPresenter = new DetailPresenter(this);
    private Boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Detail Stadium");

        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDetailStadium(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.favorite, menu);
        setFavorite();
        return true;
    }

    private void setFavorite() {
        if (isFavorite){
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite));
        }else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border));
        }
    }

    @Override
    public void showDetailStadium(StadiumItem stadiumItem) {
        this.stadiumItem = stadiumItem;
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken).placeholder(R.drawable.ic_broken);
        Glide.with(this).load(stadiumItem.getStrImageStadium()).apply(options).into(imgStadiumDetail);
        txtNameStadiumDetail.setText(stadiumItem.getStrStadium());
        txtDesc.setText(stadiumItem.getStrStadiumDescription());

        isFavorite = detailPresenter.checkFavorite(this, stadiumItem);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
