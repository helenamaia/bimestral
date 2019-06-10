package bimestral.control;

import bimestral.NavegadorCenas;
import javafx.fxml.FXML;

public class Cadastrar {


    @FXML
    public void initialize(){

    }
    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }
    @FXML
    public void salvar(){
        System.out.println("salvandoo...");
    }
}
