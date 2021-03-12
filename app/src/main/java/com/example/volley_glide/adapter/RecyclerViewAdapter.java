package com.example.volley_glide.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.volley_glide.R;
import com.example.volley_glide.activities.AnimeActivity;
import com.example.volley_glide.model.Anime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    Context context;
    ArrayList<Anime> animeList;
    RequestOptions requestOptions;

    public RecyclerViewAdapter(Context context, ArrayList<Anime> animeList){

        this.context=context;
        this.animeList=animeList;

        requestOptions=new RequestOptions().centerCrop();

    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.anime_item_row,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        holder.tv_name.setText(animeList.get(position).getName());
        holder.tv_category.setText(animeList.get(position).getCategory());
        holder.tv_rating.setText(animeList.get(position).getRating());
        holder.tv_studio.setText(animeList.get(position).getRating());
        Log.d("onBindViewHolder: ",""+animeList.get(position).getImage_url());
        Glide.with(context).load(animeList.get(position).getImage_url()).apply(requestOptions).into(holder.img_thumbnail);

           holder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, AnimeActivity.class);
//                intent.putExtra("animeList", animeList);
//                intent.putExtra("pos",position);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name ;
        TextView tv_rating ;
        TextView tv_studio ;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_category = itemView.findViewById(R.id.categorie);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }

}
