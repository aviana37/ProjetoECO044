package com.example.zanv.festivaldeinvernofccda;

/**
 * Created by André on 09/05/2015.
 *
 * Fragmento que mostra somente a imagem especificada.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class GaleriaSlideFragment extends Fragment {

    private int photoId;

    public static GaleriaSlideFragment create(int photo) {
        GaleriaSlideFragment fragment = new GaleriaSlideFragment();
        Bundle args = new Bundle();
        args.putInt("PHOTO_ID", photo);
        fragment.setArguments(args);
        return fragment;
    }

    public GaleriaSlideFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoId = getArguments().getInt("PHOTO_ID");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.galeria_slider_fragment, container, false);

        ImageView imageView= (ImageView) rootView.findViewById(R.id.fullImageView);
        imageView.setImageResource(photoId);
        return rootView;
    }
}

