package com.pandasoft.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pandasoft.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sobre);

        String descricao = "A ATM consultoria busca melhorar, Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI\n\n"
                +"quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("atmconsultoria@mail.com","envie um email")
                .addWebsite("google.com","acesse nosso site")
                .addGroup("Acesse nossas redes Sociais")
                .addFacebook("google","Acesse nosso Facebook")
                .addTwitter("ATM","Twiter")
                .addYoutube("ATM","Youtube")
                .addPlayStore("ATM","PlayStore")
                .addInstagram("ATM","Instagram")
                .addGitHub("ATM","GitHub")
                .create();

        setContentView(sobre);


    }
}
