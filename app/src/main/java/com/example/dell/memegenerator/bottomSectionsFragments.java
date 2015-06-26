package com.example.dell.memegenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class bottomSectionsFragments extends Fragment implements View.OnClickListener {
    private static TextView toptextView;
    private static TextView bottomtextView;
    final static int cameraData=0;
    ImageView imageView;
    Button buttonCam;
    Bitmap bmp;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_section_fragment, container, false);
        toptextView=(TextView)view.findViewById(R.id.toptextView);
        bottomtextView=(TextView)view.findViewById(R.id.bottomtextView);
        imageView=(ImageView)view.findViewById(R.id.imageView);
        buttonCam=(Button)view.findViewById(R.id.buttonCam);
        buttonCam.setOnClickListener(this);
        InputStream is=getResources().openRawResource(R.drawable.ic_launcher);
        bmp= BitmapFactory.decodeStream(is);
        return view;
    }
    public void setMemeText(String top,String bottom){
        toptextView.setText(top);
        bottomtextView.setText(bottom);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,cameraData);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                   Bundle extras=data.getExtras();
            bmp=(Bitmap)extras.get("data");
            imageView.setImageBitmap(bmp);
    }
}
