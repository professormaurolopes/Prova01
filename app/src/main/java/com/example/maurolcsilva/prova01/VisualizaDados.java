package com.example.maurolcsilva.prova01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VisualizaDados extends Activity {

    private TextView lblValDisciplina,lblValTipoAula,lblValNotaAula,lblValComentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Variaveis para recuperacao de dados
        String disciplina,tipoaula,notaaula,comentario;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_dados);
        //Captura dos objetos da Tela
        lblValDisciplina = (TextView) findViewById(R.id.lblValDisciplina);
        lblValTipoAula = (TextView) findViewById(R.id.lblValTipoAula);
        lblValNotaAula = (TextView) findViewById(R.id.lblValNotaAula);
        lblValComentario = (TextView) findViewById(R.id.lblValComentario);
        //Recuperação do objeto de paramentros
        Bundle param = getIntent().getExtras();
        disciplina = param.getString("disc");
        tipoaula = param.getString("tipo");
        notaaula = param.getString("nota");
        comentario = param.getString("comentario");
        //Atualização dos TEXT dos TextViews
        lblValDisciplina.setText(disciplina);
        lblValTipoAula.setText(tipoaula);
        lblValNotaAula.setText(notaaula);
        lblValComentario.setText(comentario);

    }
}
