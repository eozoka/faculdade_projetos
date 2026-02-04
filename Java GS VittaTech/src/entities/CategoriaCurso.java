package entities;

public class CategoriaCurso {

    private String nome;
    private String descricao;

    public CategoriaCurso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome; }

    public String getDescricao() {
        return descricao; }

    @Override
    public String toString() {
        return nome + " - " + descricao;
    }
}
