package com.example.zanv.festivaldeinvernofccda;

import android.app.PendingIntent;

/**
 * Created by André on 29/06/2015.
 *
 * Estrutura de dados base Evento
 *
 * O construtor precisa dos seguintes parâmetros:
 *  String Título do evento;
 *  String Local do evento;
 *  String Data do evento (no formato dd/mm);
 *  String Horário do evento (no formato (hh:mm);
 *  String Descrição do evento;
 *  int Categoria do evento (utilize somente as constantes da estrutura Evento);
 *  int Faixa etária do evento (utilize somente as constantes da estrutura Evento);
 *  int Id da imagem do evento; (R.drawable.algumacoisa);
 */

public class Evento {

    public static final int FAIXA_ETARIA_LIVRE = 0;
    public static final int FAIXA_ETARIA_10 = 1;
    public static final int FAIXA_ETARIA_12 = 2;
    public static final int FAIXA_ETARIA_14 = 3;
    public static final int FAIXA_ETARIA_16 = 4;
    public static final int FAIXA_ETARIA_18 = 5;

    public static final int CATEGORIA_MUSICA = 0;
    public static final int CATEGORIA_CINEMA = 1;
    public static final int CATEGORIA_LITERATURA = 2;
    public static final int CATEGORIA_OFICINAS = 3;
    public static final int CATEGORIA_CULTURA = 4;
    public static final int CATEGORIA_TODOS = 5;
    public static final int CATEGORIA_HOJE = 6;

    public String titulo, local, data, horario, descricao;
    public int categoria, faixaEtaria, imagem, identificador;
    public PendingIntent alarme;

    public Evento(String titulo, String local, String data, String horario, String descricao,
                  int categoria, int faixaEtaria, int imagem) {
        this.titulo = titulo;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.descricao=descricao;
        this.categoria=categoria;
        this.faixaEtaria=faixaEtaria;
        this.imagem=imagem;
        identificador=-1;
        alarme=null;
    }

}
