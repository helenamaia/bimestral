package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
import bimestral.model.Pergunta;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Jogar {

    @FXML
    TextArea taVerPerguntas;

    @FXML
    public void initialize(){
        String enunciado = "";
        ArrayList<String> resposta = null;
        int res = 0;
        for(Pergunta p : Jogo.getInstance().getListap()){
            resposta = new ArrayList<>();
            enunciado=p.getEnunciado();
            resposta = p.getOpcoes();
            res = p.getCorreta();
            taVerPerguntas.setText(enunciado+"\n"+resposta+"\n\n");
        }


    }
    @FXML
    public void pular(){


    }
    @FXML
    public void avancar(){

    }
    @FXML
    public void desistir(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }

}
