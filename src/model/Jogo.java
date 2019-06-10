package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Jogo {


    public static String ARQUIVO = "ExemploPerguntas.bin";

    private ObservableList<Pergunta> perguntas;

    private ObservableList<Jogador> jogadores;


    private static Jogo instance = new Jogo();

    private Jogo(){
        jogadores = FXCollections.observableArrayList();
        perguntas = FXCollections.observableArrayList();
    }
    public static Jogo getInstance(){
        return  instance;
    }


    public void carregaDados() throws IOException,ClassNotFoundException{

        perguntas.clear();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File(ARQUIVO)
                )
        );

        ArrayList<Pergunta> temp = (ArrayList)ois.readObject();

        perguntas.addAll(temp);


        ois.close();

    }

    public void salvaDados() throws IOException{


        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(ARQUIVO))
        );

        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();


    }




}
