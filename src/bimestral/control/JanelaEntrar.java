package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
import bimestral.model.Pergunta;
import javafx.fxml.FXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JanelaEntrar extends Controlador {


    @FXML
    public void initialize(){

    }

    @FXML
    public void jogar() {
        String a = "b";
        Jogo.getInstance().carregarPerguntas(a);
        NavegadorCenas.loadJanela(NavegadorCenas.JOGAR);

    }
    @FXML
    public void ranking(){
        NavegadorCenas.loadJanela(NavegadorCenas.RANKING);
    }
    @FXML
    public void ajuda(){
        NavegadorCenas.loadJanela(NavegadorCenas.AJUDA);
    }

    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }


}
