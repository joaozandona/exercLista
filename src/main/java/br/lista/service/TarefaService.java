package br.lista.service;

import br.lista.dao.ListaDao;
import br.lista.dao.TarefaDao;
import br.lista.model.Tarefa;

import java.time.LocalDate;
import java.util.Scanner;

public class TarefaService {

    private final TarefaDao tarefaDao;
    private final ListaDao listaDao;
    private final Scanner scan = new Scanner(System.in);

    public TarefaService (TarefaDao tarefaDao, ListaDao listaDao) {
        this.tarefaDao = tarefaDao;
        this.listaDao = listaDao;
    }

    public void adicionarTarefaEmUmaLista() {
        Tarefa tarefa = new Tarefa();
        System.out.print("Digite o título da tarefa: ");
        tarefa.setTitulo(scan.nextLine());
        System.out.print("Digite o texto da tarefa: ");
        tarefa.setTexto(scan.nextLine());
        System.out.print("Digite o ID da lista que deseja adicionar a tarefa: ");
        tarefa.setLista(listaDao.readOne(scan.nextInt()));
        tarefaDao.create(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void concluirT() {
        System.out.print("Digite o ID da tarefa que deseja concluir: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Concluindo a tarefa " + tarefa.getTitulo());
        tarefa.setConcluida(true);
        tarefa.setDataConclusao(LocalDate.now());
        tarefaDao.update(tarefa);
        System.out.println("Tarefa concluída com sucesso!");
    }

    public void desfazerT() {
        System.out.print("Digite o ID da tarefa que deseja desfazer: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Desfazendo a tarefa " + tarefa.getTitulo());
        tarefa.setConcluida(false);
        tarefa.setDataConclusao(null);
        tarefaDao.update(tarefa);
        System.out.println("Tarefa desfeita com sucesso!");
    }

    public void excluirT() {
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Excluindo a tarefa " + tarefa.getTitulo());
        tarefaDao.delete(tarefa.getId());
        System.out.println("Tarefa excluída com sucesso!");
    }

    public void atualizarT() {
        System.out.print("Digite o ID da tarefa que deseja atualizar: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Atualizando a tarefa " + tarefa.getTitulo());
        tarefaDao.update(tarefa);
        System.out.println("Tarefa atualizada com sucesso!");
    }

    public Tarefa listarUmaT() {
        System.out.print("Digite o ID da tarefa: ");
        int idTarefa = scan.nextInt();
        scan.nextLine();
        System.out.println("Buscando a tarefa " + idTarefa);
        Tarefa tarefa = tarefaDao.readOne(idTarefa);
        System.out.println("Tarefa encontrada com sucesso!");
        return tarefa;
    }
}
