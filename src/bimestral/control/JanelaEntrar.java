package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
import bimestral.model.Pergunta;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JanelaEntrar extends Controlador {

    @FXML
    ToggleGroup grupoTema;

    @FXML
    public void initialize(){

    }


    @FXML
    public void jogar() {
        int sim = 0;
        String a = "";
        String select = String.valueOf(grupoTema.getSelectedToggle());
        if(!select.equals("null")) {
            sim = 0;
            String[] div = select.split(",");
            div = div[0].split("=");

            select = div[1];
            if (select.equals("bio")){
              a = "b";
            }
        }
        else if(select.equals("null")){
            mensagem("Por favor selecione uma opção");
            sim=1;
        }
        if(sim == 0){
            Jogo.getInstance().carregarPerguntas(a);
            NavegadorCenas.loadJanela(NavegadorCenas.JOGAR);

        }

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
