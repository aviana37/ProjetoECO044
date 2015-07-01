package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;

/**
 * Created by Roger on 10/05/2015.
 *
 * Instancia o layout da tela de splash e espera por 3 segundos
 * até fazer a chamada da tela principal.
 */
public class Splash extends Activity implements Runnable {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    public void run() {
        startActivity(new Intent(this, TelaPrincipal.class));
        finish();
    }
}
