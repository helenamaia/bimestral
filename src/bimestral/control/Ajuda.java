package bimestral.control;

import bimestral.NavegadorCenas;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Ajuda {
    @FXML
    TextArea taVerAjuda;


    @FXML
    public void initialize(){
        taVerAjuda.setText("Este quiz tem como intuito testar seus conhecimentos em diversas áreas. \nO jogo te proporciará diversas matérias, no qual possui seus respectivos níveis\n\nPorém, a pontuação por cada pergunta certa é modificada devido a escolha de niveis:\n" +
                "Fácil: 3 pontos\nMédio: 4 pontos\nDifícil: 5 pontos");
    }

    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }
}
