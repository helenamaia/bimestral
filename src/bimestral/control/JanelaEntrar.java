package bimestral.control;

import bimestral.NavegadorCenas;
import bimestral.model.Jogo;
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
            int cont = 0;
            int cont2 = 0;
            int okay = 0;
            String enunciado;
            ArrayList<String> res = new ArrayList<>();
            String numperguntas , numrespostas ;

            while(scan.hasNextLine()){
                String str = scan.nextLine();
                String[] he = str.split("\n");
                if(cont == 0 && Jogo.getInstance().getListap()==null){
                    numperguntas=he[0];
                    numrespostas=he[1];
                    int respostas = Integer.parseInt(numrespostas);
                    okay = 2;
                    cont = 2;
                }
                if(cont == 2 && okay == 2){

                    enunciado = str;
                    res.add(enunciado);
                    cont2++;
                }
                else if(cont == 3 && okay == 2){

                }

                cont++;
                System.out.println(str);
            }
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
