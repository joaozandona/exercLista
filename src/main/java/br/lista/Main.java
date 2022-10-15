package br.lista;

import br.lista.dao.ListaDao;
import br.lista.dao.TarefaDao;
import br.lista.service.ListaService;
import br.lista.service.TarefaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        TarefaService tarefaService = new TarefaService(new TarefaDao(), new listaDao());
        ListaService listaService = new ListaService(new listaDao());

        int aux = 0;

        while(true){

            System.out.print("Digite oq precisa: 1- Criar Lista  2- Criar Tarefa em uma Lista  3- Ver uma Lista pelo ID  4- Ver todas as listas  5- Ver uma tarefa pelo ID  6- Concluir uma tarefa pelo ID  7- Desfazer uma tarefa pelo ID  8- Atualizar uma lista pelo ID  9- Atualizar uma tarefa pelo ID  10- Excluir uma lista pelo ID  11- Excluir uma tarefa pelo ID  12- Excluir todas as listas  13- Sair do programa: ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            aux = scan.nextInt();
            scan.nextLine();

            switch (aux){
                case 1:
                    listaService.criarL();
                    break;
                case 2:
                    tarefaService.adicionarTarefaEmUmaLista();
                    break;
                case 3:
                    listaService.listarLPorId();
                    break;
                case 4:
                    listaService.listarTodasAsL();
                    break;
                case 5:
                    tarefaService.listarUmaT();
                    break;
                case 6:
                    tarefaService.concluirT();
                    break;
                case 7:
                    tarefaService.desfazerT();
                    break;
                case 8:
                    listaService.atualizarLista();
                    break;
                case 9:
                    tarefaService.atualizarT();
                    break;
                case 10:
                    listaService.excluirLista();
                    break;
                case 11:
                    tarefaService.excluirT();
                    break;
                case 12:
                    listaService.excluirTodasAsL();
                    break;
                case 13:
                    scan.close();
                    System.out.println("Encerrando programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inexistente!");
                    break;
            }
        }
    }
}
