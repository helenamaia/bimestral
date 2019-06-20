package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogador;
import bimestral.model.Jogo;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Collections;

public class Ranking {

    @FXML
    ListView<Jogador> ltvRanking;



    @FXML
    public void initialize(){

        Jogo.getInstance().cadastraRanking();
        ltvRanking.setItems(Jogo.getInstance().getListaRanking());

    }
    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }
}
