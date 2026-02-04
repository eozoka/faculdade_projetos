package entities;

public class Avaliacao {

    private String nomeAluno;
    private int nota;
    private String comentario;

    public Avaliacao(String nomeAluno, int nota, String comentario) {
        this.nomeAluno = nomeAluno;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getNomeAluno() {
        return nomeAluno; }

    public int getNota() {
        return nota; }

    public String getComentario() {
        return comentario; }


    @Override
    public String toString() {
        return nomeAluno + " avaliou com nota " + nota +
                " — Comentário: " + comentario;
    }
}
