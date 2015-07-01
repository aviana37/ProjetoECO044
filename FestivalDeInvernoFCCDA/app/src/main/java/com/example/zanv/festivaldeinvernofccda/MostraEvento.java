package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by André on 30/06/2015.
 *
 * Activity que mostra o evento, alterando o layout de acordo com sua categoria e outras informações.
 * Também são instanciados os listeners dos botões compartilhar e notifique-me.
 */
public class MostraEvento extends Activity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mostra_evento);

        Intent i = getIntent();
        int id = i.getIntExtra("EVENTO_IDENTIFICADOR", -1);

        if(id > -1)
        {
            Evento e = Database.getEvento(id);
            TextView titulo = (TextView) findViewById(R.id.eventoTitulo);
            TextView descricao = (TextView) findViewById(R.id.eventoInfo);
            ImageView imagem = (ImageView) findViewById(R.id.eventoImagem);
            ImageView background = (ImageView) findViewById(R.id.eventoBackground);
            descricao.setMovementMethod(new ScrollingMovementMethod());

            titulo.setText(e.titulo);
            descricao.setText(e.descricao);
            imagem.setImageResource(e.imagem);

            switch(e.categoria)
            {
                case Evento.CATEGORIA_OFICINAS:
                    background.setImageResource(R.drawable.backgroundoficinas);
                    break;
                case Evento.CATEGORIA_CULTURA:
                    background.setImageResource(R.drawable.backgroundcultura);
                    break;
                case Evento.CATEGORIA_MUSICA:
                    background.setImageResource(R.drawable.backgroundmusica);
                    break;
                case Evento.CATEGORIA_CINEMA:
                    background.setImageResource(R.drawable.backgroundcinema);
                    break;
                case Evento.CATEGORIA_LITERATURA:
                    background.setImageResource(R.drawable.backgroundliteratura);
                    break;
            }

            Button compartilhar = (Button) findViewById(R.id.eventoCompartilhar);
            compartilhar.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent i = getIntent();
                    int id = i.getIntExtra("EVENTO_IDENTIFICADOR", -1);

                    if (id > -1) {
                        Evento e = Database.getEvento(id);
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, e.titulo +" no 41º Festival de Inverno Itabira");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, e.titulo
                                + " no 41º Festival de Inverno Itabira\n"
                                + "Local: " + e.local + "\n"
                                + "Data: " + e.data + " " + e.horario + "\n\n"
                                + "Via Aplicativo da FCCDA");
                        startActivity(Intent.createChooser(sharingIntent, "Compartilhar evento via"));
                    }
                }
            });

            Button notificar = (Button) findViewById(R.id.eventoNotificar);
            notificar.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = getIntent();
                    int id = i.getIntExtra("EVENTO_IDENTIFICADOR", -1);

                    if (id > -1) {
                        Intent notificar = new Intent(MostraEvento.this, SelecionaNotificacao.class);
                        notificar.putExtra("EVENTO_IDENTIFICADOR", id);
                        startActivity(notificar);
                    }
                }
            });
        }
    }
}
