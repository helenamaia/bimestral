package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Fim {


    @FXML
    public void initialize(){
        System.out.println(Jogo.getInstance().getListaj());
    }
    @FXML
    public void volta(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }




}
