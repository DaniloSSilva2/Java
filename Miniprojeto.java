import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Tarefa {
    private int id;
    private String descricao;
    private Date dataConclusao;
    private boolean concluida;

    public Tarefa(int id, String descricao, Date dataConclusao) {
        this.id = id;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
        this.concluida = false; // Status inicial é pendente
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "ID: " + id + " | Descrição: " + descricao + " | Data de conclusão: " + sdf.format(dataConclusao)
                + " | Status: " + (concluida ? "Concluída" : "Pendente");
    }
}

class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas;
    private int contadorId;

    public GerenciadorTarefas() {
        tarefas = new ArrayList<>();
        contadorId = 1; 
    }

    public void adicionarTarefa(String descricao, Date dataConclusao) {
        Tarefa novaTarefa = new Tarefa(contadorId++, descricao, dataConclusao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void concluirTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.concluir();
                System.out.println("Tarefa " + id + " concluída com sucesso!");
                return;
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }

    public void removerTarefasConcluidas() {
        tarefas.removeIf(Tarefa::isConcluida);
        System.out.println("Tarefas concluídas removidas.");
    }

    public void listarTarefas() {
        Collections.sort(tarefas, Comparator.comparing(Tarefa::getDataConclusao));
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }
}

public class Miniprojeto {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n--- Sistema de Gerenciamento de Tarefas ---");
            System.out.println("\n1. Adicionar nova tarefa");
            System.out.println("\n2. Concluir tarefa");
            System.out.println("\n3. Remover tarefas concluídas");
            System.out.println("\n4. Listar tarefas");
            System.out.println("\n5. Sair");
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("\nDigite a data de conclusão (dd/MM/yyyy): ");
                    String dataString = scanner.nextLine();
                    Date dataConclusao = sdf.parse(dataString);
                    gerenciador.adicionarTarefa(descricao, dataConclusao);
                    break;

                case 2:
                    System.out.print("\nDigite o ID da tarefa a ser concluída: ");
                    int idConcluir = scanner.nextInt();
                    gerenciador.concluirTarefa(idConcluir);
                    break;

                case 3:
                    gerenciador.removerTarefasConcluidas();
                    break;

                case 4:
                    gerenciador.listarTarefas();
                    break;

                case 5:
                    rodando = false;
                    System.out.println("\nSaindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}