package com.yusril.submission3async.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.yusril.submission3async.R;
import com.yusril.submission4.R;

public class DetailMovieActivity extends AppCompatActivity {
    public static String EXTRA_MOVIE="extra_movie";
    public static final String EXTRA_POSITION = "extra_position";
    private TextView textViewScore,textViewTitle,textViewDesc;
    private ImageView Poster;
    private ImageButton Btn_Close;
    private Button Add_Fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      