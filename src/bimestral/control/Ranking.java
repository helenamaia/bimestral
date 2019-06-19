package bimestral.control;

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


        ltvRanking.setItems(Jogo.getInstance().getListaRanking());

    }
}
