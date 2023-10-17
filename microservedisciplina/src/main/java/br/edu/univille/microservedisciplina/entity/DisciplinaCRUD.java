package br.edu.univille.microservedisciplina.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisciplinaCRUD {
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Disciplina");
            System.out.println("2. Listar Disciplinas");
            System.out.println("3. Atualizar Disciplina");
            System.out.println("4. Excluir Disciplina");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarDisciplina();
                    break;
                case 2:
                    listarDisciplinas();
                    break;
                case 3:
                    atualizarDisciplina();
                    break;
                case 4:
                    excluirDisciplina();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Programa encerrado.");
    }

    private static void adicionarDisciplina() {
        System.out.println("Adicionar Disciplina:");

        System.out.print("ID: ");
        String idDisciplina = scanner.next();

        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();

        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();

        Disciplina disciplina = new Disciplina(idDisciplina, cargaHoraria, semestre);
        disciplinas.add(disciplina);

        System.out.println("Disciplina adicionada com sucesso.");
    }

    private static void listarDisciplinas() {
        System.out.println("Listar Disciplinas:");

        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }

    private static void atualizarDisciplina() {
        System.out.println("Atualizar Disciplina:");

        System.out.print("ID da Disciplina a ser atualizada: ");
        String idDisciplina = scanner.next();

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getIdDisciplina().equals(idDisciplina)) {
                System.out.print("Nova Carga Horária: ");
                int cargaHoraria = scanner.nextInt();

                System.out.print("Novo Semestre: ");
                int semestre = scanner.nextInt();

                disciplina.setCargaHoraria(cargaHoraria);
                disciplina.setSemestre(semestre);

                System.out.println("Disciplina atualizada com sucesso.");
                return;
            }
        }

        System.out.println("Disciplina não encontrada.");
    }

    private static void excluirDisciplina() {
        System.out.println("Excluir Disciplina:");

        System.out.print("ID da Disciplina a ser excluída: ");
        String idDisciplina = scanner.next();

        disciplinas.removeIf(disciplina -> disciplina.getIdDisciplina().equals(idDisciplina));

        System.out.println("Disciplina excluída com sucesso.");
    }
}

