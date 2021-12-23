package com.example.evaluadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adaptere extends RecyclerView.Adapter<Adaptere.Evaluar>{
    private Context mContext;
    private ArrayList<elementoevaluarse> mLista;

    public Adaptere(Context context, ArrayList<elementoevaluarse> lista){
        mContext=context;
        mLista=lista;
    }


    @Override
    public Evaluar onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi= LayoutInflater.from(mContext).inflate(R.layout.recyevaluarse,parent, false);
        return new Evaluar(vi);
    }

    @Override
    public void onBindViewHolder(Evaluar holder, int position) {
        elementoevaluarse actual=mLista.get(position);
        String id=actual.getIdevaluado();
        String nombre=actual.getNombres();
        String genero=actual.getGenero();
        String relacion=actual.getSituacion();
        String cargo=actual.getCargo();
        String fechaInicio=actual.getFechainicio();
        String urlImga=actual.getImgjpg();

        holder.mNombre.setText(nombre);
        holder.mRelacion.setText(relacion);
        holder.mCargo.setText(cargo);
        holder.mFechaInicio.setText(fechaInicio);
        Glide.with(mContext)
                .load(urlImga)
                .placeholder(R.drawable.imgs)
                .error(R.drawable.imgs)
                .into(holder.mImg);
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class Evaluar extends RecyclerView.ViewHolder {
        public ImageView mImg;
        public TextView mNombre;
        public TextView mRelacion;
        public TextView mCargo;
        public TextView mFechaInicio;

        public Evaluar(View itemView) {
            super(itemView);

            mImg=itemView.findViewById(R.id.imagen_vistas);
            mNombre=itemView.findViewById(R.id.txtnombre);
            mRelacion=itemView.findViewById(R.id.txtRelacion);
            mCargo=itemView.findViewById(R.id.txtCargo);
            mFechaInicio=itemView.findViewById(R.id.txtfechaInicio);
        }
    }
}
