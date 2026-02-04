package entities;

public class Professor {

    private String nome;
    private String formacao;

    public Professor(String nome, String formacao) {
        this.nome = nome;
        this.formacao = formacao;
    }

    public String getNome() {
        return nome;
    }

    public String getFormacao() {
        return formacao;
    }

    @Override
    public String toString() {
        return nome + " (" + formacao + ")";
    }
}
