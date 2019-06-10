package bimestral.control;

import bimestral.NavegadorCenas;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Ajuda {
    @FXML
    TextArea taVerAjuda;


    @FXML
    public void initialize(){
        taVerAjuda.setText("....");
    }

    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }
}
