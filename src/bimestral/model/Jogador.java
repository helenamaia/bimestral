package bimestral.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Jogador implements Serializable, Comparable<Jogador> {

    private String login;
    private String senha;
    private int codigo;
    private String nome;
    private int maiorPontuacao;
    private LocalDateTime ultimaJogada;

    public Jogador(String login, String senha, int codigo, String nome, int maiorPontuacao, LocalDateTime ultimaJogada) {
        this.login = login;
        this.senha = senha;
        this.codigo = codigo;
        this.nome = nome;
        this.maiorPontuacao = maiorPontuacao;
        this.ultimaJogada = ultimaJogada;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMaiorPontuacao() {
        return maiorPontuacao;
    }

    public void setMaiorPontuacao(int maiorPontuacao) {
        this.maiorPontuacao = maiorPontuacao;
    }

    public LocalDateTime getUltimaJogada() {
        return ultimaJogada;
    }

    public void setUltimaJogada(LocalDateTime ultimaJogada) {
        this.ultimaJogada = ultimaJogada;
    }

    @Override
    public int compareTo(Jogador jogador) {

        return this.maiorPontuacao-jogador.getMaiorPontuacao();
    }

    @Override
    public String toString() {
        return "\t\t\t\t\t"+nome+"\t\t\t\t\t\t\t"+maiorPontuacao;
    }
}
