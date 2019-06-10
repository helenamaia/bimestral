package bimestral.control;

import bimestral.NavegadorCenas;
import javafx.fxml.FXML;

public class JanelaEntrar extends Controlador {


    @FXML
    public void initialize(){

    }

    @FXML
    public void jogar(){
        NavegadorCenas.loadJanela(NavegadorCenas.JOGAR);
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
