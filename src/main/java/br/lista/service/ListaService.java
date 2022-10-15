package br.lista.service;

import br.lista.dao.ListaDao;
import br.lista.model.Lista;
import br.lista.model.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaService {

    private final ListaDao listaDao;
    private final Scanner scan = new Scanner(System.in);

    public ListaService (ListaDao listaDao) {
        this.listaDao = listaDao;
    }

    public void criarL() {
        Lista lista = new Lista();
        System.out.print("Digite o título da lista: ");
        lista.setTitulo(scan.nextLine());
        listaDao.create(lista);
        int id = listaDao.getIdByTitulo(lista.getTitulo());
        System.out.println("Lista ID " + id + " criada com sucesso!");
    }

    public void excluirL() {
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int idLista = scan.nextInt();
        scan.nextLine();
        Lista lista = listaDao.readOne(idLista);
        System.out.println("Excluindo a lista " + lista.getTitulo() + " (vai excluir todas as tarefas também)");
        listaDao.delete(lista.getId());
        int id = lista.getId();
        System.out.println("Lista ID " + id + " e tarefas excluída com sucesso!");
    }

    public void excluirTodasAsL(){
        System.out.println("Excluindo todas as listas (vai excluir todas as tarefas também)");
        listaDao.deleteAll();
        System.out.println("Todas as listas e tarefas excluídas com sucesso!");
    }

    public void atualizarL() {
        System.out.print("Digite o ID da lista que deseja atualizar: ");
        int idLista = scan.nextInt();
        scan.nextLine();
        Lista lista = listaDao.readOne(idLista);
        System.out.println("Atualizando a lista " + lista.getTitulo());
        listaDao.update(lista);
        int id = lista.getId();
        System.out.println("Lista ID " + id + " atualizada com sucesso!");
    }

    public void listarTodasAsL() {
        System.out.println("| Listando todas as listas");
        ArrayList<Lista> listas = listaDao.readAll();
        for (Lista lista : listas) {
            System.out.println("| Lista ID: " + lista.getId());
            System.out.println("| Título: " + lista.getTitulo());
            if(lista.getTarefas() != null) {
                for (Tarefa tarefa : lista.getTarefas()) {
                    System.out.println("| Tarefa ID: " + tarefa.getId());
                    System.out.println("| Título: " + tarefa.getTitulo());
                    System.out.println("| Texto: " + tarefa.getTexto());
                    System.out.println("| Data de criação: " + tarefa.getDataCriacao());
                    System.out.println("| Data de conclusão: " + tarefa.getDataConclusao());
                    System.out.println("| Concluída: " + tarefa.isConcluida());
                }
            } else {
                System.out.println("| Tarefas: 0");
            }
        }
    }

    public void listarLPorId(){
        System.out.print("| Digite o ID da lista:");
        int idLista = scan.nextInt();
        scan.nextLine();
        System.out.println("| Listando a lista " + idLista);
        Lista lista = listaDao.readOne(idLista);
        System.out.println("| Lista ID: " + lista.getId());
        System.out.println("| Título: " + lista.getTitulo());
        if(lista.getTarefas() != null) {
            for (Tarefa tarefa : lista.getTarefas()) {
                System.out.println("| Tarefa ID: " + tarefa.getId());
                System.out.println("| Título: " + tarefa.getTitulo());
                System.out.println("| Texto: " + tarefa.getTexto());
                System.out.println("| Data de criação: " + tarefa.getDataCriacao());
                System.out.println("| Data de conclusão: " + tarefa.getDataConclusao());
                System.out.println("| Concluída: " + tarefa.isConcluida());
            }
        } else {
            System.out.println("| Tarefas: 0");
        }
    }

}
