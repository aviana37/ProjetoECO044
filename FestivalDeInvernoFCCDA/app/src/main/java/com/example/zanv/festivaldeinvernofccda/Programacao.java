package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.List;

/**
 * Created by André on 29/06/2015.
 *
 * Activity responsável por mostrar um listview com eventos.
 * Os eventos são selecionados a partir da categoria definida no Intent.
 *
 * Quando um evento é clicado, é criada uma nova intent com o seu identificador para a classe MostraEvento,
 * que mostra uma visão detalhada do mesmo.
 */

public class Programacao extends Activity {

    private ListView listview;
    private Context context;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        context = this;
        setContentView(R.layout.lista_de_eventos);

        Intent i = getIntent();
        int categoria = i.getIntExtra("EVENTO_CATEGORIA", Evento.CATEGORIA_TODOS);
        List<Evento> listaEventos = Database.getList(categoria);

        listview = (ListView) findViewById(R.id.lv_eventos);
        listview.setAdapter(new EventoAdapter(context, R.layout.evento, listaEventos));

        listview.setClickable(true);
        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Evento o = (Evento) parent.getItemAtPosition(position);
                Intent i = new Intent(Programacao.this, MostraEvento.class);
                i.putExtra("EVENTO_IDENTIFICADOR", o.identificador);
                startActivity(i);
            }
        });
    }

}
