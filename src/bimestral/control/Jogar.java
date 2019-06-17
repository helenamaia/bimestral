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

public class Jogar {

    int cont = 0, pular = 0;
    ArrayList<Pergunta> sorteio = new ArrayList<>();

    @FXML
    TextArea taVerPerguntas;

    @FXML
    ToggleGroup grupo;



    @FXML
    public void initialize(){

        sorteio.addAll(Jogo.getInstance().sortear());
        System.out.println("\n\n\naaaa"+sorteio);

        mostraPergunta();



    }
    @FXML
    public void pular(){
        if(pular<3){
            pular++;
            mostraPergunta();
        }



    }
    @FXML
    public void avancar(){
        String select = String.valueOf(grupo.getSelectedToggle());
        if(!select.equals("null")) {
            String[] div = select.split(",");
            div = div[0].split("=");

            select = div[1];
            Pergunta p = sorteio.get(cont);
            if (select.equals(String.valueOf(p.getCorreta()))) {
                Jogo.getInstance().adicionaPontuacao(3);
            } else {
                Jogo.getInstance().adicionaPontuacao(-1);
            }
        }
        int auxiliar = cont - pular;
        System.out.println("meudeus"+auxiliar);

        if(auxiliar<5){
            mostraPergunta();
        }
        else {
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


        Pergunta p = sorteio.get(cont);



        resposta = new ArrayList<>();
        resposta = p.getOpcoes();
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
        enunciado=p.getEnunciado();
        res = p.getCorreta();
        taVerPerguntas.setText(enunciado+"\n"+op1+"\n"+op2+"\n"+op3+"\n"+op4+"\n"+op5+"\n\n");
        cont++;




    }

    @FXML
    public void desistir(){
        NavegadorCenas.loadJanela(NavegadorCenas.ENTRAR);
    }

}
