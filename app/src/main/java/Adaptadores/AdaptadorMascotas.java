package Adaptadores;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.Top5Mascotas;

import java.util.ArrayList;

import Dominio.Mascota;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;



    public AdaptadorMascotas(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    //Inflar el layout y lo pasará el viewHolder
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {

        SharedPreferences preferencias= activity.getSharedPreferences("SICAM", Context.MODE_PRIVATE);



        final Mascota mascota = mascotas.get(position);
        holder.imagen.setImageResource(mascota.getFotografía());
        holder.nombre.setText(mascota.getName());
        holder.ranking.setText(String.valueOf(Integer.parseInt(preferencias.getString(mascota.getName(),"0"))));

        if(holder.ranking.getText().toString().equals("0")){
            holder.btnRanking.setImageResource(R.drawable.dog_bone_96_2);
        }else{
            holder.btnRanking.setImageResource(R.drawable.dog_bone_96);
        }


////AJUSTAR PARA MOSTRAR EL LIKEEEEEE
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override




            public void onClick(View view) {
                if(holder.btnRanking.getDrawable().getConstantState().equals( activity.getResources().getDrawable(R.drawable.dog_bone_96_2).getConstantState())) {

                    holder.btnRanking.setImageResource(R.drawable.dog_bone_96);
                    holder.ranking.setText(String.valueOf(Integer.parseInt(holder.ranking.getText().toString())+1));

                    SharedPreferences preferencias= activity.getSharedPreferences("SICAM", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString(holder.nombre.getText().toString(), holder.ranking.getText().toString());
                    editor.commit();
                }else{
                    holder.btnRanking.setImageResource(R.drawable.dog_bone_96);
                    holder.ranking.setText(String.valueOf(Integer.parseInt(holder.ranking.getText().toString())+1));

                    SharedPreferences preferencias= activity.getSharedPreferences("SICAM", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString(holder.nombre.getText().toString(), holder.ranking.getText().toString());
                    editor.commit();

                }
            }
        });

    }



    //Cantidad de contactos del tamaño
    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public  class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private TextView ranking;
        private ImageView imagen;
        private LinearLayout cardView;
        private ImageView btnLike;
        private ImageView btnRanking;




        public ContactoViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView)itemView.findViewById(R.id.imgFoto);
            nombre = (TextView)itemView.findViewById(R.id.tvNombre);
            ranking = (TextView)itemView.findViewById(R.id.tvRanking);
            cardView = (LinearLayout)itemView.findViewById(R.id.cardViewLayout);
            btnLike = (ImageView) itemView.findViewById(R.id.imgB_Favorite);
            btnRanking = (ImageView) itemView.findViewById(R.id.imgB_Ranking);


        }


    }



}
