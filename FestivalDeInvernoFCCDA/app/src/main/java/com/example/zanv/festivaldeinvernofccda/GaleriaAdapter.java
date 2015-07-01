package com.example.zanv.festivaldeinvernofccda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Andre Viana on 06/05/2015.
 *
 * Classe responsável por adaptar cada imagem da galeria ao grid view da galeria de fotos.
 * O método de atualização do tamanho das imagens no grid pode ser retrabalhado, uma vez que
 * foi observado em tablets no modo retrato uma distorção do layout bastante grotesca.
 */

public class GaleriaAdapter extends BaseAdapter{
    private Context context;
    private Activity activity;
    private int size, padding;

    public GaleriaAdapter(Activity a, Context c) {
        activity = a;
        context  = c;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        float f;
        if(metrics.heightPixels > metrics.widthPixels)
            f = metrics.widthPixels;
        else
            f = metrics.heightPixels;
        f*=0.32;

        size = (int)f;
        padding = 4;
    }

    public int getCount() {
        return photos.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(size, size));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(padding, padding, padding, padding);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(photos[position]);
        imageView.setOnClickListener(new OnPhotoClickListener(position));
        return imageView;
    }

    // Identificadores das fotos
    private Integer[] photos = {
            R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
            R.drawable.g4,
            R.drawable.g5,
            R.drawable.g6,
            R.drawable.g7,
            R.drawable.g8,
            R.drawable.g9,
            R.drawable.g10,
            R.drawable.g11,
            R.drawable.g12,
            R.drawable.g13
    };

    class OnPhotoClickListener implements OnClickListener
    {
        int pos;

        public OnPhotoClickListener(int position) {
            this.pos = position;
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(activity, GaleriaSlideActivity.class);

            i.putExtra("CURRENT_PHOTO", pos);

            ArrayList<Integer> photoList = new ArrayList<Integer>();
            for(int c=0; c<photos.length; ++c)
                photoList.add((Integer) photos[c]);
            i.putExtra("PHOTO_GALLERY", photoList);

            activity.startActivity(i);
        }
    }
}
