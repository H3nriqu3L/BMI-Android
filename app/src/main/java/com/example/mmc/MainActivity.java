package com.example.mmc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void createRelatorio(View view){
        EditText idade = findViewById(R.id.idade_edit);
        EditText peso = findViewById(R.id.peso_edit);
        EditText altura = findViewById(R.id.altura_edit);
        EditText nome = findViewById(R.id.edit_name);

        String idade_text = (idade.getText().toString());
        String peso_text = (peso.getText().toString());
        String altura_text = (altura.getText().toString());
        String nome_text = (nome.getText().toString());

        if(idade_text.isEmpty()) return;
        if(peso_text.isEmpty()) return;
        if(altura_text.isEmpty()) return;
        if(nome_text.isEmpty()) return;

        int idade_num = Integer.parseInt(idade_text);
        double peso_num = Double.parseDouble(peso_text);
        double altura_num = Double.parseDouble(altura_text);

        double imc = peso_num/(altura_num*altura_num);
        String classification_imc;

        // Definindo a classificação com base no valor do IMC
        if (imc < 18.5) {
            classification_imc = "Abaixo do Peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            classification_imc = "Saudável";
        } else if (imc >= 25 && imc <= 29.9) {
            classification_imc = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            classification_imc = "Obesidade Grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            classification_imc = "Obesidade Grau II (severa)";
        } else {
            classification_imc = "Obesidade Grau III (mórbida)";
        }

        Intent it = new Intent(getBaseContext(), Tela2.class);

        it.putExtra("imc", imc);
        it.putExtra("nome", nome_text);
        it.putExtra("idade", idade_num);
        it.putExtra("peso", peso_num);
        it.putExtra("altura", altura_num);
        it.putExtra("classification_imc", classification_imc);

        startActivity(it);


    }
}

