package com.guilherme.popcornapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guilherme.popcornapp.model.Filme;
import com.guilherme.popcornapp.model.ResponseApiFilme;
import com.guilherme.popcornapp.model.ResponseCredits;
import com.guilherme.popcornapp.model.ResponseCrew;
import com.guilherme.popcornapp.model.ResponseResult;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Detail_filme extends AppCompatActivity {


    private TextView tituloTextView;
    private TextView direcaoTextView;
    private TextView lancamentoDetailTextView;
    private TextView descriptionTextView;
    private TextView popularidadeTextView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_filme);
        Intent intent = getIntent();
        Filme filme = (Filme) intent.getSerializableExtra("filme");

        tituloTextView = findViewById(R.id.tituloFilme);
        direcaoTextView = findViewById(R.id.direcaoDetailTextView);
        lancamentoDetailTextView = findViewById(R.id.lancamentoDetailTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        popularidadeTextView = findViewById(R.id.popularidadeTextView);
        imageView = findViewById(R.id.imageView);


        tituloTextView.setText(filme.getTitulo());
        direcaoTextView.setText(filme.getDiretor());
        lancamentoDetailTextView.setText(filme.getDataFormatada());
        descriptionTextView.setText(filme.getDescricao());
        popularidadeTextView.setText(filme.getPopularidade()+"");
        WebServiceGetDirector director = new WebServiceGetDirector();
        director.execute(filme.getId());
        ImageGetter imageGetter = new ImageGetter();
        imageGetter.execute(filme.getPosterPath());

    }

    private class ImageGetter extends AsyncTask<String,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urlS) {
            try {
                URL url = new URL(getApplicationContext().getString(R.string.uri_image) + urlS[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream= connection.getInputStream();
                Bitmap figura = BitmapFactory.decodeStream(inputStream);
                return figura;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
        @Override
        protected void onPostExecute(Bitmap figura) {
            imageView.setImageBitmap(figura);
        }
    }

    private class WebServiceGetDirector extends AsyncTask<Integer,Void,String> {

        @Override
        protected String doInBackground(Integer... idFilme) {
            try {
                String uri = getApplicationContext().getString(R.string.uri_director, idFilme[0]+"");
                URL url = new URL(uri);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String linha = null;
                StringBuilder stringBuilder = new StringBuilder("");
                while ((linha = reader.readLine()) != null) {
                    stringBuilder.append(linha);
                }
                String json = stringBuilder.toString();
                return json;
            } catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String json) {
//            Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
            try {

                Gson gson = new Gson();
                ResponseCredits responseCredits = gson.fromJson(json, ResponseCredits.class);
                List<ResponseCrew> responseResults = responseCredits.getCrew();
                Boolean flag = true;
                Integer contator = 0;
                while (flag){

                    if(responseResults.get(contator).getDepartment().equals("Directing")){
                        direcaoTextView.setText(responseResults.get(contator).getName());
                        flag = false;
                    }

                    contator++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
