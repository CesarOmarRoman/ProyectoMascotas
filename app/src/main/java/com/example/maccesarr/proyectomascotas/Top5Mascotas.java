package com.example.maccesarr.proyectomascotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import Adaptadores.AdaptadorMascotas;
import Dominio.Mascota;

public class Top5Mascotas extends AppCompatActivity {

    String sesion;

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeUsuarios;
    SharedPreferences.Editor editor;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5_mascotas);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaDeUsuarios= (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        preferencias=getSharedPreferences("SICAM", Context.MODE_PRIVATE);
        editor =preferencias.edit();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeUsuarios.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        AdaptadorMascotas adaptadorMascotas = new AdaptadorMascotas(mascotas, this);
        listaDeUsuarios.setAdapter(adaptadorMascotas);
    }



    public  void burbuja(ArrayList<Mascota> mascotas){
        int i;

        for(i=0;i<=mascotas.size();i++){
            if(mascotas.get(mascotas.size()-i).getVotación()==0){
                mascotas.remove(mascotas.size()-i);
        }}

/**
        for(i=0;i<mascotas.size()-1;i++){
            while (mascotas.get(i).getVotación()<mascotas.get(i+1).getVotación()) {
                    Mascota movimiento = mascotas.get(i);
                    mascotas.remove(i);
                    mascotas.add(movimiento);

            }
           }

 **/




    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascota>();



        if((Integer.parseInt(preferencias.getString("Bronco","0"))==0)){

        }else{
            mascotas.add(new Mascota(1, "Bronco", R.drawable.dog1, Integer.parseInt(preferencias.getString("Bronco","0"))));
        }

        if((Integer.parseInt(preferencias.getString("Barto","0"))==0)){

        }else{
            mascotas.add(new Mascota(2, "Barto", R.drawable.dog2, Integer.parseInt(preferencias.getString("Barto","0"))));
        }

        if((Integer.parseInt(preferencias.getString("Spiderman","0"))==0)){

        }else{
            mascotas.add(new Mascota(3, "Spiderman", R.drawable.dog3, Integer.parseInt(preferencias.getString("Spiderman","0"))));
        }

        if((Integer.parseInt(preferencias.getString("Intenso","0"))==0)){

        }else{
            mascotas.add(new Mascota(4, "Intenso", R.drawable.dog4, Integer.parseInt(preferencias.getString("Intenso","0"))));
        }


        if((Integer.parseInt(preferencias.getString("Max","0"))==0)){

        }else{
            mascotas.add(new Mascota(5, "Max", R.drawable.dog5, Integer.parseInt(preferencias.getString("Max","0"))));
        }

        if((Integer.parseInt(preferencias.getString("Macho","0"))==0)){

        }else{
            mascotas.add(new Mascota(6, "Macho", R.drawable.dog6, Integer.parseInt(preferencias.getString("Macho","0"))));
        }


    }
}
