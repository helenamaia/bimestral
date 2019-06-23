package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogador;
import bimestral.model.Jogo;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Principal extends Controlador{


    @FXML
    TextField tfLogin;

    @FXML
    PasswordField tfSenha;


    @FXML
    public void initialize(){

    }

    @FXML
    public void entrar(){
        Jogo.getInstance().remover();
        String log = tfLogin.getText();
        String sen = tfSenha.getText();
        Boolean okay = false;
        int codigo = 0;
        String nome = " ";
        int pontuação = 0;
        LocalDateTime lo = null;
        for (Jogador l: Jogo.getInstance().getListaj()) {
            if(l.getLogin().equals(log) && l.getSenha().equals(sen)){
                codigo = l.getCodigo();
                nome = l.getNome();
                pontuação = l.getMaiorPontuacao();
                okay = true;

            }
        }

        if(okay==true){
            Jogador novo = new Jogador(log, sen, codigo, nome, pontuação, lo);
            Jogo.getInstance().cadastrarAtual(novo);
            NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
        }
        else if(okay==false){
            mensagem("Senha ou login incorretos");
        }

    }

    @FXML
    public void criarConta(){
        NavegadorCenas.loadJanela(NavegadorCenas.CADASTRAR);
    }
}
