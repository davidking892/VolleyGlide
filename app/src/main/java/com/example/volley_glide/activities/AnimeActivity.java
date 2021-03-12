package com.example.volley_glide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.volley_glide.R;
import com.example.volley_glide.model.Anime;

import java.util.List;

public class AnimeActivity extends AppCompatActivity {

    List<Anime> animeList;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

//       animeList= (List<Anime>) getIntent().getSerializableExtra("animeList");
//        position=  getIntent().getIntExtra("pos",0);

    }
}