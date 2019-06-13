package bimestral.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

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




}
