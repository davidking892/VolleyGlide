package com.example.volley_glide.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley_glide.R;
import com.example.volley_glide.adapter.RecyclerViewAdapter;
import com.example.volley_glide.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private ArrayList<Anime> listAnime;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAnime=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);

        jsonRequest();

    }

    private void jsonRequest(){

        jsonArrayRequest=new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject=null;

                for(int i=0;i<response.length();i++){

                    try{

                        jsonObject=response.getJSONObject(i);
                        Anime anime=new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setCategory(jsonObject.getString("categorie"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setImage_url(jsonObject.getString("img"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setStudio(jsonObject.getString("episode"));
                        listAnime.add(anime);

                    }catch(JSONException e){
                        e.printStackTrace();
                    }

                }

                setUpRecyclerView(listAnime);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);

    }

    private void setUpRecyclerView(ArrayList<Anime> listAnime) {

        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,listAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(recyclerViewAdapter);

    }


}
