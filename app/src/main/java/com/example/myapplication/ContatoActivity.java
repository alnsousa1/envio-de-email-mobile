package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContatoActivity  extends AppCompatActivity {

    EditText edtAssunto, edtTexto;

    Button btnEnviar;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        //vinculando o objeto button do java com o da  tela (XML)
        edtAssunto = findViewById(R.id.edtAssunto);
        edtTexto = findViewById(R.id.edtTexto);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar();
            }
        });
    }

    private void enviar(){
        try {
            String[] emailPara = new String[] {"paramim@gmail.com.br"};
            String corpoMensagem = "Email enviado via App Android<br />" + edtTexto.getText();

            Intent telaEmail = new Intent(Intent.ACTION_SEND);
            telaEmail.setType("text/html");
            telaEmail.setType("message/rfc822");
            telaEmail.putExtra(Intent.EXTRA_SUBJECT, edtAssunto.getText().toString());
            telaEmail.putExtra(Intent.EXTRA_TEXT, corpoMensagem);
            telaEmail.putExtra(Intent.EXTRA_EMAIL, emailPara);

            startActivity(Intent.createChooser(telaEmail, "Enviar E-mail"));
        }catch (Exception ex){

        }
    }
}
