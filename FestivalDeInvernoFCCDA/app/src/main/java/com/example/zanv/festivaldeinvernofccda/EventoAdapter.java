package com.example.zanv.festivaldeinvernofccda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by André on 29/06/2015.
 *
 * Classe responsável por adaptar o layout às informações de cada evento.
 * Agradecimentos ao veterano Ricardo Kiki pela ajuda indispensável nesta parte.
 */

public class EventoAdapter extends ArrayAdapter<Evento> {

    private Context context;
    private List<Evento> eventos;
    private int resourceId;

    public EventoAdapter(Context ctx, int resourceId, List<Evento> objects) {
        super(ctx, resourceId);
        this.resourceId = resourceId;
        context = ctx;
        eventos = objects;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Evento getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resourceId, null);
        Evento evento = eventos.get(position);

        TextView dia = (TextView) convertView.findViewById(R.id.listaDataDia);
        TextView mes = (TextView) convertView.findViewById(R.id.listaDataMes);
        TextView titulo = (TextView) convertView.findViewById(R.id.listaEventoTitulo);
        TextView descricao = (TextView) convertView.findViewById(R.id.listaEventoDescricao);
        ImageView faixaEtaria = (ImageView) convertView.findViewById(R.id.listaEventoFaixaEtaria);
        ImageView tipo = (ImageView) convertView.findViewById(R.id.listaEventoTipo);

        String [] data = evento.data.split("/");
        dia.setText(data[0]);
        mes.setText(data[1]);

        titulo.setText(evento.titulo);
        descricao.setText(evento.local);

        switch(evento.faixaEtaria)
        {
            case Evento.FAIXA_ETARIA_10:
                faixaEtaria.setImageResource(R.drawable.c10);
                break;
            case Evento.FAIXA_ETARIA_12:
                faixaEtaria.setImageResource(R.drawable.c12);
                break;
            case Evento.FAIXA_ETARIA_14:
                faixaEtaria.setImageResource(R.drawable.c14);
                break;
            case Evento.FAIXA_ETARIA_16:
                faixaEtaria.setImageResource(R.drawable.c16);
                break;
            case Evento.FAIXA_ETARIA_18:
                faixaEtaria.setImageResource(R.drawable.c18);
                break;
            case Evento.FAIXA_ETARIA_LIVRE:
                faixaEtaria.setImageResource(R.drawable.livre);
                break;
        }

        switch (evento.categoria)
        {
            case Evento.CATEGORIA_CINEMA:
                tipo.setImageResource(R.drawable.iconecinema);
                break;
            case Evento.CATEGORIA_CULTURA:
                tipo.setImageResource(R.drawable.iconecultura);
                break;
            case Evento.CATEGORIA_LITERATURA:
                tipo.setImageResource(R.drawable.iconeliteratura);
                break;
            case Evento.CATEGORIA_MUSICA:
                tipo.setImageResource(R.drawable.iconemusica);
                break;
            case Evento.CATEGORIA_OFICINAS:
                tipo.setImageResource(R.drawable.iconeoficinas);
                break;
        }
/*
        Typeface oswaldFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Oswald/Oswald-Regular.ttf");
        Typeface francoisFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Francois_One/FrancoisOne.ttf");

        dia.setTypeface(francoisFont);
        mes.setTypeface(francoisFont);
        titulo.setTypeface(francoisFont);
        descricao.setTypeface(oswaldFont);
*/
        return convertView;
    }
}
