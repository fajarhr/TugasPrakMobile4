package com.example.tugas_2_123170100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tugas_2_123170100.R;

import androidx.appcompat.app.AppCompatActivity;

public class PahlawanDetail extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private ImageView adivPhoto;
    private TextView adtvHeroName, adtvHeroDesc;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        adivPhoto   = findViewById(R.id.adiv_hero_image);
        adtvHeroName    = findViewById(R.id.adtv_hero_name);
        adtvHeroDesc    = findViewById(R.id.adtv_hero_desc);
        btnShare  = findViewById(R.id.btn_share);

        com.example.tugas_2_123170100.PahlawanModel hero = getIntent().getParcelableExtra(EXTRA_DATA);
        int image       = hero.getHeroImage();
        String name     = hero.getHeroName();
        final String desc     = hero.getHeroDesc();

        if (hero != null) {
            Glide.with(this).load(image).into(adivPhoto);
            adtvHeroName.setText(name);
            adtvHeroDesc.setText(desc);
        }

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, desc);
                intent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(intent, null);
                startActivity(shareIntent);
            }
        });
    }
}
