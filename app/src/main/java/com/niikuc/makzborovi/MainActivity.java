package com.niikuc.makzborovi;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

import java.io.IOException;

import java.util.Scanner;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void lookup(View view){
        EditText the_word=(EditText) findViewById(R.id.txtWord);
        String word=the_word.getText().toString();

        String defn=readDefinition(word);
        TextView definition=(TextView) findViewById(R.id.textView);
        definition.setText(defn);

    }

    private String readDefinition(String word) {
        String a="";
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.mak_zborovi));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] pieces = line.split("\t");
            if (pieces[0].equalsIgnoreCase(word.trim())) {
                 a=pieces[1];
            }
        }
            return a;
    }


    public void pecati(View view){

        String defn=readFile();
        TextView definition=(TextView) findViewById(R.id.textBox2);
        definition.setText(defn);

    }



    private String readFile() {
        String a="";
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.mak_zborovi));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] pieces = line.split("\t");

                a=a+pieces[0]+" ";

        }
        return a;
    }

    public void zvuk(){
        try {
            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource("raw/liftoff.mp3");
            mp.prepare();
            mp.start();

        }
        catch (IOException e){
            e.printStackTrace();

        }

    }




}

