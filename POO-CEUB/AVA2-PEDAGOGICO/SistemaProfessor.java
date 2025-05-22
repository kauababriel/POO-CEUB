import java.util.Scanner;

// Classe Aluno
class Aluno {
    String nome;
    String turma;

    Aluno(String nome, String turma) {
        this.nome = nome;
        this.turma = turma;
    }
}

// Classe Atividade
class Atividade {
    String titulo;
    String descricao;

    Atividade(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}

// Classe Professor
class Professor {
    String nome;
    String senha;

    Professor(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    boolean fazerLogin(String nomeDigitado, String senhaDigitada) {
        return nome.equals(nomeDigitado) && senha.equals(senhaDigitada);
    }
}

// Classe principal do sistema
public class SistemaProfessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Login do professor
        Professor professor = new Professor("professor", "1234");
        System.out.println("=== LOGIN PROFESSOR ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (!professor.fazerLogin(nome, senha)) {
            System.out.println("Login inválido. Encerrando...");
            return;
        }

        System.out.println("Login realizado com sucesso!");

        // Menu principal
        Aluno aluno = null;
        Atividade atividade = null;
        double nota = 0;

        int opcao;
        do {
            System.out.println("\n=== MENU DO PROFESSOR ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Atividade");
            System.out.println("3. Lançar Nota");
            System.out.println("4. Ver Dados Lançados");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = sc.nextLine();
                    System.out.print("Turma do aluno: ");
                    String turma = sc.nextLine();
                    aluno = new Aluno(nomeAluno, turma);
                    System.out.println("Aluno cadastrado!");
                    break;

                case 2:
                    System.out.print("Título da atividade: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    atividade = new Atividade(titulo, descricao);
                    System.out.println("Atividade cadastrada!");
                    break;

                case 3:
                    if (aluno == null || atividade == null) {
                        System.out.println("Cadastre um aluno e uma atividade antes.");
                    } else {
                        System.out.print("Nota do aluno: ");
                        nota = sc.nextDouble();
                        sc.nextLine(); // limpar buffer
                        System.out.println("Nota lançada!");
                    }
                    break;

                case 4:
                    System.out.println("\n=== DADOS LANÇADOS ===");
                    if (aluno != null)
                        System.out.println("Aluno: " + aluno.nome + " - Turma: " + aluno.turma);
                    if (atividade != null)
                        System.out.println("Atividade: " + atividade.titulo + " - " + atividade.descricao);
                    if (nota > 0)
                        System.out.println("Nota: " + nota);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
