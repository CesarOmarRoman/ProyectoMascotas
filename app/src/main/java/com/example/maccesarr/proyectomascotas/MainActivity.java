package com.example.maccesarr.proyectomascotas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Adaptadores.AdaptadorMascotas;
import Dominio.Mascota;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeUsuarios;
    SharedPreferences.Editor editor;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeUsuarios= (RecyclerView) findViewById(R.id.rvMascotas);



        preferencias=getSharedPreferences("SICAM", Context.MODE_PRIVATE);
        editor =preferencias.edit();




        LinearLayoutManager llm = new LinearLayoutManager(this);
        //GridLayoutManager llm = new GridLayoutManager(this, 2);
        //StaggeredGridLayoutManager llm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaDeUsuarios.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();


    }

    public void inicializarAdaptador(){
        AdaptadorMascotas adaptadorMascotas = new AdaptadorMascotas(mascotas, this);
        listaDeUsuarios.setAdapter(adaptadorMascotas);
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, "Bronco", R.drawable.dog1, Integer.parseInt(preferencias.getString("Bronco","0"))));
        mascotas.add(new Mascota(2, "Barto", R.drawable.dog2, Integer.parseInt(preferencias.getString("Barto","0"))));
        mascotas.add(new Mascota(3, "Spiderman", R.drawable.dog3, Integer.parseInt(preferencias.getString("Spiderman","0"))));
        mascotas.add(new Mascota(4, "Intenso", R.drawable.dog4, Integer.parseInt(preferencias.getString("Intenso","0"))));
        mascotas.add(new Mascota(5, "Max", R.drawable.dog5, Integer.parseInt(preferencias.getString("Max","0"))));
        mascotas.add(new Mascota(6, "Macho", R.drawable.dog6, Integer.parseInt(preferencias.getString("Macho","0"))));

    }

    public void Favorito(View view){
        Intent intent = new Intent(this, Top5Mascotas.class);
        startActivity(intent);
    }

    public void Agregar_Imagen(View view){
        Toast.makeText(this,"En construcción agregar imagenes", Toast.LENGTH_LONG).show();
    }

    public void Reiniciar(View view){
        Toast.makeText(this,"Se reiniciar los parametros", Toast.LENGTH_LONG).show();
        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }




}
