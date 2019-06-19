package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogador;
import bimestral.model.Jogo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.Optional;

public class Cadastrar extends Controlador {

    Jogo jog = new Jogo();

    @FXML
    TextField login;

    @FXML
    TextField senha;

    @FXML
    TextField confSenha;

    @FXML
    TextField codigo;

    @FXML
    TextField nome;


    @FXML
    public void initialize(){

    }
    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }
    @FXML
    public void salvar(){
        String log = login.getText();
        String sen = senha.getText();
        String confsen = confSenha.getText();
        int cod = Integer.parseInt(codigo.getText());
        String nom = nome.getText();
        LocalDateTime l = LocalDateTime.now();

        int cont1 = 0, cont2 = 0, cont3 = 0, cont4=0;
        for(Jogador j: Jogo.getInstance().getListaj()){
            if(log.equals(j.getLogin())){
                cont1++;
            }
            else if(cod == j.getCodigo()){
                cont2++;
            }
            else if(nom.equals(j.getNome())){
                cont4++;
            }

        }
        if (sen.equals(confsen)){
            cont3=0;
        }
        else{
            cont3++;
        }
        if(cont1== 0 && cont2 == 0 && cont3==0 && cont4==0){
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION,"Deseja mesmo cadastrar esse usuário?");
            Optional<ButtonType> resultado = alerta.showAndWait();

            if(resultado.isPresent() && resultado.get() == ButtonType.OK){
                Jogador jogador = new Jogador(log, sen, cod, nom, 0, null);
                Jogo.getInstance().cadastrar(jogador);
                NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
            }

        }
        else if (cont1>0){
            mensagem("Esse login já está em uso, por favor insira outro");
        }
        else if(cont2>0){
            mensagem("Esse código já está em uso, por favor insira outro");
        }
        else if(cont3>0){
            mensagem("Senhas não batem");
        }
        else if(cont4>0){
            mensagem("Esse nome já está em uso, por favor insira outro");
        }
    }
}
