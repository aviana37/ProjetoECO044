package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Andre Viana on 06/05/2015.
 *
 * Classe principal da galeria de fotos. Instancia o layout e configura o adaptador.
 */

public class GaleriaDeFotos extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.galeria_de_fotos);

        android.widget.GridView gridView = (android.widget.GridView) findViewById(R.id.galeriaGridView);
        gridView.setAdapter(new GaleriaAdapter(GaleriaDeFotos.this, this));
    }
}
