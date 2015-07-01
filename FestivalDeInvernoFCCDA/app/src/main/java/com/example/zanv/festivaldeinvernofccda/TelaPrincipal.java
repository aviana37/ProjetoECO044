package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class TelaPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        findViewById(R.id.btn_galeria).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, GaleriaDeFotos.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_sobre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Sobre.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_agenda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_TODOS);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_cinema).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_CINEMA);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_extensao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_CULTURA);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_hoje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_HOJE);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_literatura).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_LITERATURA);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_musica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_MUSICA);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_oficina).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Programacao.class);
                i.putExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_OFICINAS);
                startActivity(i);
            }
        });
    }

}
