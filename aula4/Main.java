import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Tarefa> listaDeTarefas = new ArrayList<>();

        System.out.println("\n---bem vindo ao sistem de tarefas---\n");
        int opcao = 0;
        while(opcao !=4) {
            System.out.println("\n1 - Adicionar Nova Tarefa" +
                               "\n2 - Listar Tarefas" +
                               "\n3 - Marcar Tarefa como Comcluida" +
                               "\n4 - Sair" +
                               "\n5 - Remover Tarefa" +
                               "\n6 - Estatisticas" +
                               "\n7 - Pesquisar Palavra Chave" +
                               "\nInforme a Opção Desejada: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1){
                System.out.println("\nInforme a Descrição de sua Tarefa: ");
                String descricao = scanner.nextLine();

                Tarefa novaTarefa = new Tarefa(descricao);

                listaDeTarefas.add(novaTarefa);
                System.out.println("\nTarefa Adicionada com Sucesso\n\n");

            } else if (opcao == 2) {
                if(listaDeTarefas.isEmpty()) {
                    System.out.println("\nLista de Tarefas Vazia\n\n");
                } else {
                    for (int i=0; i < listaDeTarefas.size(); i++) {
                        Tarefa t =listaDeTarefas.get(i);
                        t.exibirTarefa(i+1);
                    }
                    System.out.println();
                }

            } else if (opcao == 3) {
                if (listaDeTarefas.isEmpty()){
                    System.out.println("\nSem Tarefas a Concluir\n\n");
                } else {
                    System.out.println("\nQual a Tarefa que Deseja Concluir? ");
                    int numeroTarefa = scanner.nextInt();
                    int indiceReal = numeroTarefa-1;

                    if (indiceReal >= 0 && indiceReal < listaDeTarefas.size()){
                        Tarefa t = listaDeTarefas.get(indiceReal);
                        t.marcarComoConcluido();
                        System.out.println("\nTarefa Concluida com Sucesso\n\n");
                    }
                }
            } else if (opcao == 4) {
                System.out.println("\nTchau\n\n");

            } else if (opcao == 5) {
                if (listaDeTarefas.isEmpty()){
                    System.out.println("\nSem Tarefas para Remover\n\n");
                } else {
                    System.out.println("\nQual a Tarefa que Deseja Remover? ");
                    int numeroTarefa = scanner.nextInt();
                    int indiceReal = numeroTarefa-1;

                    if (indiceReal >= 0 && indiceReal < listaDeTarefas.size()){
                        listaDeTarefas.remove(indiceReal);
                        System.out.println("\nTarefa Removida com Sucesso\n\n");
                    }
                }

            } else if (opcao == 6) {
                if(listaDeTarefas.isEmpty()) {
                    System.out.println("\nLista de Tarefas Vazia\n\n");
                } else {
                    int con=0, pen=0;
                    for (int i=0; i < listaDeTarefas.size(); i++) {
                        Tarefa t =listaDeTarefas.get(i);
                        if(t.isConcluido()){
                            con += 1;
                        } else {
                            pen += 1;
                        }
                    }
                    System.out.println( "Total: " + listaDeTarefas.size() + " | Concluídas: " + con + " | Pendentes: " + pen);
                }

            } else if (opcao == 7) {
                if(listaDeTarefas.isEmpty()) {
                    System.out.println("\nLista de Tarefas Vazia\n\n");
                } else {
                    System.out.println("Digite a Palavra Chave: ");
                    String termo = scanner.nextLine();
                    System.out.println("\nLista de Tarefas com o Termo: "+ termo +"\n");
                    for (int i=0; i < listaDeTarefas.size(); i++) {
                        Tarefa t =listaDeTarefas.get(i);
                        if(t.getDescricao().contains(termo)){
                            t.exibirTarefa(i);
                        }
                    }
                }

            }else {
                System.out.println("\nOpção não Encontrada\n\n");

            }
        }
        scanner.close();
    }
}