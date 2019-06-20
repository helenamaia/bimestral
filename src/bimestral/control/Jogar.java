package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
import bimestral.model.Pergunta;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.HashSet;

public class Jogar extends Controlador{

    int cont = 0, pular = 0, pontos;
    ArrayList<Pergunta> sorteio = new ArrayList<>();
    Pergunta atual = null;

    @FXML
    TextArea taVerPerguntas;

    @FXML
    ToggleGroup grupo;



    @FXML
    public void initialize(){
        sorteio.addAll(Jogo.getInstance().sortear());


        mostraPergunta();



    }
    @FXML
    public void pular(){
        System.out.println(cont+" "+pular);
        if(pular<3){
            pular++;
            mostraPergunta();
        }
        System.out.println(cont+" "+pular);


    }
    @FXML
    public void avancar(){
        int sim=0;
        //System.out.println(cont+" "+pular);
        String select = String.valueOf(grupo.getSelectedToggle());
        if(!select.equals("null")) {
            sim=0;
            String[] div = select.split(",");
            div = div[0].split("=");

            select = div[1];
            Pergunta p = atual;
            if (select.equals(String.valueOf(p.getCorreta()))) {

                pontos=pontos+3;
            } else {

                pontos=pontos-1;
            }
        }
        else if(select.equals("null")){
            mensagem("Por favor selecione uma opção");
            sim=1;
        }
        int auxiliar = cont - pular;

        if(auxiliar<5 && sim==0){
            mostraPergunta();
        }
        else if(auxiliar==5 && sim == 0){
            Jogo.getInstance().adicionaPontuacao(pontos);
            Jogo.getInstance().adicionaUltimajogada();
            NavegadorCenas.loadJanela(NavegadorCenas.FIM);

        }


    }
    private void mostraPergunta(){

        grupo.selectToggle(null);
        String enunciado = "";
        String op1 = "", op2 = "", op3 = "", op4 = "", op5 = "";
        int cont1 = 0, cont2=0;
        ArrayList<String> resposta = null;
        int res = 0;


        atual = sorteio.get(cont);



        resposta = new ArrayList<>();
        resposta = atual.getOpcoes();
        for(int i = 0; i<resposta.size(); i++){
            if(cont1 == 0){
                op1=resposta.get(i);
            }
            else if(cont1 == 1){
                op2=resposta.get(i);
            }
            else if(cont1 == 2){
                op3 = resposta.get(i);
            }
            else if(cont1 == 3){
                op4 = resposta.get(i);
            }
            else if(cont1 == 4){
                op5 = resposta.get(i);
            }
            cont1++;
        }
        enunciado=atual.getEnunciado();
        res = atual.getCorreta();
        taVerPerguntas.setText(enunciado+"\n"+op1+"\n"+op2+"\n"+op3+"\n"+op4+"\n"+op5+"\n\n");
        cont++;

    }

    @FXML
    public void desistir(){
        Jogo.getInstance().adicionaPontuacao(-(pontos));
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }

}
