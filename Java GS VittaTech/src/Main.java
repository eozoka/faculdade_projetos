import entities.*;

static PlataformaVittaConhecimento plataforma = new PlataformaVittaConhecimento();
static Scanner scan = new Scanner(System.in);

void main() {
    while (true) {
        IO.println("""
                ---- MENU PRINCIPAL DO VITTA TECH ----
                1 - Cadastrar Usuário
                2 - Criar Curso
                3 - Listar Usuários
                4 - Listar Cursos
                5 - Cadastrar Professor e Vincular ao Curso
                6 - Listar Alunos e Avaliações de um Curso
                7 - Matricular Aluno em Curso
                8 - Avaliar Curso
                9 - Sair!
                Escolha uma das opções:
                """);

        int opcao = scan.nextInt();
        scan.nextLine();

        switch (opcao) {
            case 1 -> cadastrarUsuario();
            case 2 -> criarCurso();
            case 3 -> plataforma.listarUsuariosSimples();
            case 4 -> plataforma.listarCursos();
            case 5 -> cadastrarProfessor();
            case 6 -> listarDetalhesCurso();
            case 7 -> matricularAluno();
            case 8 -> avaliarCurso();
            case 9 -> {
                IO.println("Saindo... Muito obrigado!");
                scan.close();
                return;
            }
            default -> IO.println("Opção inválida! Tente um numero de 1 a 9!");
        }
    }
}

private static void cadastrarUsuario() {
    IO.print("Nome do usuário: ");
    String nome = scan.nextLine();

    IO.print("Idade: ");
    int idade = scan.nextInt();
    scan.nextLine();

    plataforma.adicionarUsuario(new Usuario(nome, idade));
    IO.println("Usuário cadastrado!");
}

private static void criarCurso() {
    IO.print("Nome do curso: ");
    String nomeCurso = scan.nextLine();

    IO.print("Categoria do curso: ");
    String categoriaNome = scan.nextLine();

    IO.print("Descrição da categoria: ");
    String categoriaDesc = scan.nextLine();

    IO.print("Descrição do curso: ");
    String descr = scan.nextLine();

    CategoriaCurso cat = new CategoriaCurso(categoriaNome, categoriaDesc);
    Curso curso = new Curso(nomeCurso, null, cat, descr);

    plataforma.adicionarCurso(curso);
    IO.println("Curso criado!");
}

private static void cadastrarProfessor() {
    if (plataforma.getTotalCursos() == 0) {
        IO.println("Crie cursos antes de cadastrar professores.");
        return;
    }

    IO.print("Nome do professor: ");
    String nomeProf = scan.nextLine();

    IO.print("Formação: ");
    String formacao = scan.nextLine();

    Professor professor = new Professor(nomeProf, formacao);

    IO.println("Escolha o curso para vincular:");

    plataforma.listarCursosSimples();
    int index = scan.nextInt() - 1;
    scan.nextLine();

    Curso curso = plataforma.getCurso(index);

    if (curso == null) {
        IO.println("Curso inválido.");
        return;
    }

    curso.setProfessor(professor);
    IO.println("Professor vinculado!");
}

private static void matricularAluno() {
    if (plataforma.getTotalUsuarios() == 0 || plataforma.getTotalCursos() == 0) {
        IO.println("Cadastre usuários e cursos antes.");
        return;
    }

    IO.println("Escolha o aluno:");
    plataforma.listarUsuariosSimples();
    int alunoIndex = scan.nextInt() - 1;
    scan.nextLine();

    Usuario aluno = plataforma.getUsuario(alunoIndex);

    IO.println("Escolha o curso:");
    plataforma.listarCursosSimples();
    int cursoIndex = scan.nextInt() - 1;
    scan.nextLine();

    Curso curso = plataforma.getCurso(cursoIndex);

    curso.adicionarAluno(aluno);
    IO.println("Aluno matriculado!");
}

private static void avaliarCurso() {
    if (plataforma.getTotalCursos() == 0) {
        IO.println("Nenhum curso cadastrado.");
        return;
    }

    IO.println("Escolha o curso para avaliar:");
    plataforma.listarCursosSimples();
    int index = scan.nextInt() - 1;
    scan.nextLine();

    Curso curso = plataforma.getCurso(index);

    IO.print("Nome do aluno: ");
    String aluno = scan.nextLine();

    IO.print("Nota (0 a 10): ");
    int nota = scan.nextInt();
    scan.nextLine();

    IO.print("Comentário: ");
    String comentario = scan.nextLine();

    Avaliacao avaliacao = new Avaliacao(aluno, nota, comentario);
    curso.adicionarAvaliacao(avaliacao);

    IO.println("Avaliação registrada!");
}

private static void listarDetalhesCurso() {
    if (plataforma.getTotalCursos() == 0) {
        IO.println("Nenhum curso cadastrado.");
        return;
    }

    IO.println("Escolha o curso:");
    plataforma.listarCursosSimples();
    int index = scan.nextInt() - 1;
    scan.nextLine();

    Curso curso = plataforma.getCurso(index);

    IO.println("----- DETALHES DO CURSO -----");
    IO.println(curso);
    curso.listarAlunos();
    curso.listarAvaliacoes();
    IO.println("-----------------------------");
}
