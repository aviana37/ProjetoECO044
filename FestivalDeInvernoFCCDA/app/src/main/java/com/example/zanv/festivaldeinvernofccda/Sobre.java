package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by André on 01/07/2015.
 *
 * Tela sobre o festival.
 */

public class Sobre extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sobre_festival);
        TextView wv = (TextView) findViewById(R.id.sobreTextView);
        wv.setMovementMethod(new ScrollingMovementMethod());
    }
}
