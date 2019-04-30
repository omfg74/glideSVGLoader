package com.example.rxjava;

import android.content.ContentResolver;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
//import com.bumptech.glide.GenericRequestBuilder;
//import com.bumptech.glide.RequestBuilder;
//import com.bumptech.glide.RequestManager;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
//import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    private RequestBuilder<PictureDrawable> requestBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        requestBuilder = Glide.with(this)
                .as(PictureDrawable.class)
//                .placeholder(R.drawable.image_loading)
//                .error(R.drawable.image_error)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());

        loadNet();
}
    private void loadNet() {
        Uri uri = Uri.parse("https://restcountries.eu/data/alb.svg");
        requestBuilder.load(uri).into(imageView);
    }   }
