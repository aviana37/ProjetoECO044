package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

/**
 * Created by André on 30/06/2015.
 *
 * Activity adaptada de uma popup criada por Rogério Oliveira.
 * Responsável por mostrar um calendário e um relógio para auxiliar o usuário
 * a configurar alarmes para os eventos.
 * Para ajudar o usuário mais, o layout se adapta às informações do evento selecionado,
 * configurando o alarme para uma hora antes do evento.
 *
 * Os alarmes podem não funcionar em alguns dispositivos.
 */

public class SelecionaNotificacao extends Activity {

    public static DatePicker data;
    public static TimePicker time;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.seleciona_notificacao);

        Intent i = getIntent();
        int id = i.getIntExtra("EVENTO_IDENTIFICADOR", -1);

        if(id > -1)
        {
            Evento e = Database.getEvento(id);
            TextView titulo = (TextView) findViewById(R.id.eventoTituloNotificacao);
            TextView info = (TextView) findViewById(R.id.eventoInfoNotificacao);
            time = (TimePicker) findViewById(R.id.eventoTimePicker);
            data = (DatePicker) findViewById(R.id.eventoDatePicker);

            String [] buffer = e.horario.split(":");
            int hora = Integer.parseInt(buffer[0]);
            int min  = Integer.parseInt(buffer[1]);
            --hora;

            buffer = e.data.split("/");
            int dia = Integer.parseInt(buffer[0]);
            int mes = Integer.parseInt(buffer[1]);
            --mes;

            titulo.setText(e.titulo);
            info.setText("Local: " + e.local + "\n" + "Data: " + e.data + " - " + e.horario);
            time.setIs24HourView(true);
            time.setCurrentHour(hora);
            time.setCurrentMinute(min);
            data.updateDate(2015, mes, dia);

            Switch notifica = (Switch) findViewById(R.id.eventoNotificacaoSwitch);
            notifica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Intent i = getIntent();
                    int id = i.getIntExtra("EVENTO_IDENTIFICADOR", -1);
                    Context context = SelecionaNotificacao.this;

                    if(id>-1)
                    {
                        Evento e  = Database.getEvento(id);
                        if(isChecked)
                        {
                            if(e.alarme == null)
                            {
                                AlarmManager alarmMgr;
                                alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
                                Intent intent = new Intent(context, AlarmeReceptor.class);
                                intent.putExtra("EVENTO_IDENTIFICADOR", id);
                                e.alarme = PendingIntent.getBroadcast(context, 0, intent, 0);

                                SelecionaNotificacao.ativaAlarme(context, e.alarme);
                            }
                        }
                        else
                        {
                            if(e.alarme != null)
                            {
                                SelecionaNotificacao.desativaAlarme(context, e.alarme);
                                e.alarme = null;
                            }
                        }
                    }
                }
            });
        }
    }

    public static void ativaAlarme(Context context, PendingIntent intent)
    {

        AlarmManager alarmManager;
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if(alarmManager != null)
            alarmManager.set(AlarmManager.ELAPSED_REALTIME, getData().getTimeInMillis(), intent);

        Toast toast = Toast.makeText(context, "Alarme para " + String.format("%02d",getData().get(Calendar.DAY_OF_MONTH))
                                    + "/" + String.format("%02d", (getData().get(Calendar.MONTH) + 1))
                                    + " às " + String.format("%02d", getData().get(Calendar.HOUR_OF_DAY))
                                    + ":" + String.format("%02d", getData().get(Calendar.MINUTE)) + " ativado!", Toast.LENGTH_SHORT);
        toast.show();
        data.setVisibility(View.GONE);
        time.setVisibility(View.GONE);

    }
    public static void desativaAlarme(Context context, PendingIntent intent)
    {
        AlarmManager alarmManager;
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if(alarmManager != null)
            alarmManager.cancel(intent);

        Toast toast = Toast.makeText(context, "Alarme desativado!", Toast.LENGTH_SHORT);
        toast.show();

        data.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
    }

    public static Calendar getData(){
        int dia = data.getDayOfMonth();
        int mes = data.getMonth();
        int ano =  data.getYear();
        int hora = time.getCurrentHour();
        int minuto = time.getCurrentMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia, hora, minuto);

        return calendar;
    }
}
