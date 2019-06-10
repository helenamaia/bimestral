package bimestral.control;

import bimestral.NavegadorCenas;
import javafx.fxml.FXML;

public class Principal extends Controlador{

    @FXML
    public void initialize(){
        System.out.println("incialhdnd");
    }

    @FXML
    public void entrar(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }

    @FXML
    public void criarConta(){
        NavegadorCenas.loadJanela(NavegadorCenas.CADASTRAR);
    }
}
