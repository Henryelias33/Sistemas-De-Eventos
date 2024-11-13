import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Evento {
    private String nome;
    private String data;
    private String descricao;
    private List<String> participantes;

    public Evento(String nome, String data, String descricao) {
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void adicionarParticipante(String participante) {
        participantes.add(participante);
    }

    public void removerParticipante(String participante) {
        participantes.remove(participante);
    }

    @Override
    public String toString() {
        return "Evento: " + nome + "\nData: " + data + "\nDescrição: " + descricao + "\nParticipantes: " + participantes;
    }
}

class GerenciadorDeEventos {
    private List<Evento> eventos;

    public GerenciadorDeEventos() {
        eventos = new ArrayList<>();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void removerEvento(String nome) {
        eventos.removeIf(evento -> evento.getNome().equals(nome));
    }

    public Evento buscarEvento(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome)) {
                return evento;
            }
        }
        return null;
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento);
            System.out.println("---------------------------");
        }
    }
}

public class SistemaDeEventos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeEventos gerenciador = new GerenciadorDeEventos();

        while (true) {
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Remover Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Adicionar Participante em Evento");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data do evento: ");
                    String data = scanner.nextLine();
                    System.out.print("Descrição do evento: ");
                    String descricao = scanner.nextLine();
                    Evento evento = new Evento(nome, data, descricao);
                    gerenciador.adicionarEvento(evento);
                    System.out.println("Evento adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome do evento a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    gerenciador.removerEvento(nomeRemover);
                    System.out.println("Evento removido com sucesso!");
                    break;
                case 3:
                    System.out.println("Lista de eventos:");
                    gerenciador.listarEventos();
                    break;
                case 4:
                    System.out.print("Nome do evento para adicionar participante: ");
                    String nomeEvento = scanner.nextLine();
                    Evento eventoEncontrado = gerenciador.buscarEvento(nomeEvento);
                    if (eventoEncontrado != null) {
                        System.out.print("Nome do participante: ");
                        String participante = scanner.nextLine();
                        eventoEncontrado.adicionarParticipante(participante);
                        System.out.println("Participante adicionado com sucesso!");
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
