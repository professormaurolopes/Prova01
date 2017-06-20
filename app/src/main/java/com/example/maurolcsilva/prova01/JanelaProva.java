package com.example.maurolcsilva.prova01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class JanelaProva extends Activity implements View.OnClickListener {

    private Spinner spdisciplinas;
    private CheckBox chkTeorica,chkPratica;
    private RadioGroup rgNotas;
    private EditText txtComentario;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela_prova);
        //Captura dos componentes da Tela
        spdisciplinas = (Spinner) findViewById(R.id.spDisciplinas);
        chkTeorica = (CheckBox) findViewById(R.id.chkTeorica);
        chkPratica = (CheckBox) findViewById(R.id.chkPratica);
        rgNotas = (RadioGroup) findViewById(R.id.rgNotas);
        txtComentario = (EditText) findViewById(R.id.txtComentario);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String disciplina="", tipoaula="",notaaula="",comentario="";
        int idRadioSelecionado=0;
        //Recuperação dos dados da Tela
        //Recuperação da disciplina
        disciplina = spdisciplinas.getSelectedItem().toString();
        //Recuperação do tipo da aula
        if (chkTeorica.isChecked()) {
            tipoaula = tipoaula + " Teórica ";
        }
        if (chkPratica.isChecked()){
            tipoaula = tipoaula + " Prática ";
        }
        //Recuperação da Nota da Aula
        idRadioSelecionado = rgNotas.getCheckedRadioButtonId();
        switch (idRadioSelecionado){
            case (R.id.rd10):
                notaaula = "10";
                break;
            case (R.id.rd9):
                notaaula = "9";
                break;
            case (R.id.rd8):
                notaaula = "8";
                break;
            case (R.id.rd7):
                notaaula = "7";
                break;
        }
        //Recuperação do Comentário
        comentario = txtComentario.getText().toString();
        //Criação da Intent
        Intent it = new Intent(this,VisualizaDados.class);
        //Criação do objeto de parametros
        Bundle param = new Bundle();
        param.putString("disc",disciplina);
        param.putString("tipo",tipoaula);
        param.putString("nota",notaaula);
        param.putString("comentario",comentario);
        //Vinculação dos paramentros a Intent
        it.putExtras(param);
        //Chama a nova Activity
        startActivity(it);

    }
}
