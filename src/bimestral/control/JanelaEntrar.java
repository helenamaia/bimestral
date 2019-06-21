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
    ToggleGroup grupoNivel;
    @FXML
    public void initialize(){

    }


    @FXML
    public void jogar() {
        int sim = 0;
        String a = "";
        String select = String.valueOf(grupoTema.getSelectedToggle());
        String select1 = String.valueOf(grupoNivel.getSelectedToggle());
        System.out.println(select1);
        if(!select.equals("null") && !select1.equals("null")) {
            sim = 0;
            String[] div = select.split(",");
            div = div[0].split("=");
            String[] div1 = select1.split(",");
            div1 = div1[0].split("=");
            select =div[1];
            select1 = div1[1];
            if (select.equals("bio") && select1.equals("fac")){
              a = "bf";
            }
            else if(select.equals("bio") && select1.equals("med")){
                a = "bm";
            }
            else if(select.equals("bio") && select1.equals("dif")){
                a = "bd";
            }
            else if(select.equals("fil") && select1.equals("med")){
                a = "fm";
            }
            if(select.equals("mat")){
                a = "m";
            }

        }
        else if(select.equals("null")){
            mensagem("Por favor selecione uma matéria e um nível");
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
