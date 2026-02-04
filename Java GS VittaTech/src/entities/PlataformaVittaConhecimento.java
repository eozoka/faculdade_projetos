package entities;

public class PlataformaVittaConhecimento {
    private Usuario[] usuarios = new Usuario[100];
    private Curso[] cursos = new Curso[100];

    private int totalUsuarios = 0;
    private int totalCursos = 0;

    public void adicionarUsuario(Usuario u) {
        usuarios[totalUsuarios++] = u;
    }

    public void adicionarCurso(Curso c) {
        cursos[totalCursos++] = c;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public int getTotalCursos() {
        return totalCursos;
    }

    public Usuario getUsuario(int index) {
        if (index < 0 || index >= totalUsuarios) return null;
        return usuarios[index];
    }

    public Curso getCurso(int index) {
        if (index < 0 || index >= totalCursos) return null;
        return cursos[index];
    }

    public void listarUsuariosSimples() {
        if (totalUsuarios == 0) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println((i + 1) + " - " + usuarios[i].getNome());
        }
    }

    public void listarCursosSimples() {
        if (totalCursos == 0) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        for (int i = 0; i < totalCursos; i++) {
            System.out.println((i + 1) + " - " + cursos[i].getNome());
        }
    }

    public void listarUsuariosSimplesSemNumeros() {
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println(usuarios[i].getNome());
        }
    }

    public void listarCursos() {
        if (totalCursos == 0) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        for (int i = 0; i < totalCursos; i++) {
            System.out.println(cursos[i].toString());
        }
    }
}
