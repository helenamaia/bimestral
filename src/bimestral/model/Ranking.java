package bimestral.model;

public class Ranking {

    String nome;
    int pontuacao;

    public Ranking(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "nome='" + nome + '\'' +
                ", pontuacao=" + pontuacao +
                '}';
    }
}
