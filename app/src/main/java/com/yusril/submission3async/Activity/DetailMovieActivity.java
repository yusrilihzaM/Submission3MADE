package com.yusril.submission3async.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yusril.submission3async.Model.MovieModel;
import com.yusril.submission3async.R;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradasi));
        }
        ImageView image_detail = findViewById(R.id.image_detail);
        TextView textDescription = findViewById(R.id.description_detail);
        TextView textTitle = findViewById(R.id.overview);

        MovieModel movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        textTitle.setText(movies.getName());
        textDescription.setText(movies.getOverview());

        getSupportActionBar().setTitle(movies.getName());

        Glide.with(this)
                .load(movies.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(image_detail);
    }
}
