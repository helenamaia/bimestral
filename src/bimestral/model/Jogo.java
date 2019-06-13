package bimestral.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {


    public static final String ARQUIVO = "jogadores.bin";

    private ObservableList<Pergunta> perguntas;

    private ObservableList<Jogador> jogadores;

    private ObservableList<Jogador> atual;

    private static Jogo instance = new Jogo();

    public Jogo(){
        atual = FXCollections.observableArrayList();
        jogadores = FXCollections.observableArrayList();
        perguntas = FXCollections.observableArrayList();
    }
    public static Jogo getInstance(){
        return  instance;
    }

    public ObservableList<Jogador> getListaj(){
        return FXCollections.unmodifiableObservableList(jogadores);
    }

    public ObservableList<Jogador> getListaa(){
        return FXCollections.unmodifiableObservableList(atual);
    }

    public ObservableList<Pergunta> getListap(){
        return FXCollections.unmodifiableObservableList(perguntas);
    }

    public void cadastrarAtual(Jogador j){atual.add(j); }

    public void cadastrarper(Pergunta p){
        perguntas.add(p);
    }

    public void cadastrar(Jogador j){
        jogadores.add(j);
    }

    public void remover(){atual.removeAll();}


    public void carregaDados() throws IOException,ClassNotFoundException{

        jogadores.clear();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File(ARQUIVO)
                )
        );

        ArrayList<Jogador> temp = (ArrayList)ois.readObject();


        jogadores.addAll(temp);


        ois.close();

    }

    public void salvaDados() throws IOException{


        /*System.out.println("\n\n\nhelp\n\n\n");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(ARQUIVO))
        );
        System.out.println("\n\n\nhelp com h\n\n\n");
        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();*/


        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(ARQUIVO))
        );

        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();


    }
    public void carregarPerguntas(String tema){


        try{
            Scanner scan = null;
            if(tema.equals("a")){
                scan = new Scanner(new File("ExemploPerguntas.txt"));
            }
            else if(tema.equals("b")){
                scan = new Scanner(new File("InglesFacil.txt"));
            }
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

    }



}
