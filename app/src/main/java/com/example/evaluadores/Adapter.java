package com.example.evaluadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements View.OnClickListener{
    private Context mContext;
    private ArrayList<elementovista> mLista;
    private View.OnClickListener listener;

    public Adapter(Context context, ArrayList<elementovista> lista){
        mContext=context;
        mLista=lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.elemento,parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        elementovista actual=mLista.get(position);
        String urlImg=actual.getImgjpg();
        String identificacion=actual.getIdevaluador();
        String nombres=actual.getNombres();
        String area=actual.getArea();

        holder.mIdEvaluador.setText(identificacion);
        holder.mNombres.setText(nombres);
        holder.mArea.setText(area);
        //Picasso.with(mContext).load(urlImg).fit().centerInside().into(holder.mImagen);
        Glide.with(mContext)
                .load(urlImg)
                .placeholder(R.drawable.imgs)
                .error(R.drawable.imgs)
                .into(holder.mImagen);
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImagen;
        public TextView mIdEvaluador;
        public TextView mNombres;
        public TextView mArea;

        public ViewHolder(View itemView) {
            super(itemView);

            mImagen=itemView.findViewById(R.id.imagen_vista);
            mIdEvaluador=itemView.findViewById(R.id.txtIdentificacion);
            mNombres=itemView.findViewById(R.id.txtNombres);
            mArea=itemView.findViewById(R.id.txtArea);
        }
    }
}
