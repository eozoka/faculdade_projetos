package entities;

public class Curso {

    private String nome;
    private Professor professor;
    private CategoriaCurso categoria;
    private String descricao;

    private Usuario[] alunos = new Usuario[100];
    private Avaliacao[] avaliacoes = new Avaliacao[100];

    private int totalAlunos = 0;
    private int totalAvaliacoes = 0;

    public Curso(String nome, Professor professor, CategoriaCurso categoria, String descricao) {
        this.nome = nome;
        this.professor = professor;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }

    public void setProfessor(Professor p) {
        this.professor = p;
    }

    public void adicionarAluno(Usuario u) {
        alunos[totalAlunos++] = u;
    }

    public void adicionarAvaliacao(Avaliacao a) {
        avaliacoes[totalAvaliacoes++] = a;
    }

    public void listarAlunos() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno matriculado.");
            return;
        }
        System.out.println("----Alunos matriculados: ----");
        for (int i = 0; i < totalAlunos; i++) {
            System.out.println("- " + alunos[i].getNome());
        }
    }

    public void listarAvaliacoes() {
        if (totalAvaliacoes == 0) {
            System.out.println("Ainda sem avaliações.");
            return;
        }

        System.out.println("Avaliações:");
        for (int i = 0; i < totalAvaliacoes; i++) {
            System.out.println(avaliacoes[i].toString());
        }
    }

    @Override
    public String toString() {
        return "Curso: " + nome +
                " Categoria: " + categoria +
                " Professor: " + (professor == null ? "Sem professor" : professor) +
                " escrição: " + descricao + " ";
    }
}
