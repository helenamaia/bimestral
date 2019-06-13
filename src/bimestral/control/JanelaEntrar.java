package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
import bimestral.model.Pergunta;
import javafx.fxml.FXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JanelaEntrar extends Controlador {


    @FXML
    public void initialize(){

    }

    @FXML
    public void jogar() {

        try{
            Scanner scan = new Scanner(new File("ExemploPerguntas.txt"));
            ArrayList<String> texto = new ArrayList<>();
            while(scan.hasNextLine()){
                String str = scan.nextLine();
                texto.add(str);
            }
            String res = texto.get(1);
            int numres = Integer.parseInt(res);
            String per = texto.get(0);
            int numper = Integer.parseInt(per);
            int cont =0, total = numres + 2, cont2 = 0, cont3=0;
            String enunciado = "", a = "";
            int respostaFinal = 0;
            ArrayList<String> respostas = null;
            for(int i=0; i<texto.size(); i++){
                if(i>1){
                    if(cont==0){
                        respostas = new ArrayList<>();
                        enunciado=texto.get(i);
                        cont++;
                    }
                    else if(cont2 != numres){
                        respostas.add(texto.get(i));
                        cont2++;
                    }
                    else if(cont3 == 0){
                        a = texto.get(i);
                        respostaFinal = Integer.parseInt(a);
                        cont3++;
                    }
                    if(cont>0 && cont2 == numres && cont3>0){
                        Pergunta p = new Pergunta(enunciado, respostas, respostaFinal);
                        Jogo.getInstance().cadastrarper(p);
                        cont=0;
                        cont2 = 0;
                        cont3 = 0;
                    }
                }
            }
            System.out.println(Jogo.getInstance().getListap());
            scan.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        NavegadorCenas.loadJanela(NavegadorCenas.JOGAR);

    }

    @FXML
    public void ajuda(){
        NavegadorCenas.loadJanela(NavegadorCenas.AJUDA);
    }

    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }


}
