package com.example.mmc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class Tela2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent intent = getIntent();
        double imc = intent.getDoubleExtra("imc", 0.0);
        String nome = intent.getStringExtra("nome");
        int idade = intent.getIntExtra("idade", 0);
        double peso = intent.getDoubleExtra("peso", 0.0);
        double altura = intent.getDoubleExtra("altura", 0.0);
        String classificacao = intent.getStringExtra("classification_imc");


        EditText classificationEdit = findViewById(R.id.classification_edit);
        EditText imcEdit = findViewById(R.id.imc_edit);
        EditText nomeEdit = findViewById(R.id.nome_edit);
        EditText idadeEdit = findViewById(R.id.idade_edit);
        EditText pesoEdit = findViewById(R.id.peso_edit);
        EditText alturaEdit = findViewById(R.id.altura_edit);

        classificationEdit.setText(classificacao);
        imcEdit.setText(String.valueOf(imc));
        nomeEdit.setText(nome);
        idadeEdit.setText(String.valueOf(idade));
        pesoEdit.setText(String.valueOf(peso));
        alturaEdit.setText(String.valueOf(altura));


        classificationEdit.setEnabled(false);
        imcEdit.setEnabled(false);
        nomeEdit.setEnabled(false);
        idadeEdit.setEnabled(false);
        pesoEdit.setEnabled(false);
        alturaEdit.setEnabled(false);
    }

    public void voltar(View v){
        finish();
    }
}