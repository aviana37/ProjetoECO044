package com.example.zanv.festivaldeinvernofccda;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by André on 30/06/2015.
 *
 * O receptor dos alarmes criados pelo usuário na tela de notificações.
 * Testes se mostraram inconclusivos.
 */

public class AlarmeReceptor extends BroadcastReceiver{
    public void onReceive(Context context, Intent intent)
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.agendacompleta)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        Intent myIntent = new Intent(context, TelaPrincipal.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        myIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(1, mBuilder.build());
    }
}
