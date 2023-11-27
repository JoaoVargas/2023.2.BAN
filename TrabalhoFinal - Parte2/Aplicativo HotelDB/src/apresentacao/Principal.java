package apresentacao;

import dados.*;
import negocio.*;

import java.util.Scanner;

import dados.*;
import negocio.*;

public class Principal {
    private static Sistema sys = new Sistema();
    private static final Scanner s = new Scanner(System.in);
    private static String err = "";

    public static void main(String[] args) {
        int escolha = -1;

        while (escolha != 0) {
            menuPrincipal();
            System.out.println(err);
            mensagemErro("");

            escolha = Integer.parseInt(s.nextLine());

            switch (escolha){
                default -> mensagemErro("Erro: Digite um valor válido");
                case 0 -> mensagemErro("Adeus");
                case 1 -> addCliente();
//                case 2 -> addQuarto();
//                case 3 -> realizarReserva();
                case 4 -> lisClientes();
                case 5 -> lisQuartos();
//                case 6 -> lisReservas();
                case 7 -> lisPessoas();
//                case 8 -> lisHospedes();
//                case 9 -> lisResponsaveis();
//                case 10 -> lisAlocacoes();
            }

            limparTela();
        }

    }

    public static void limparTela(){
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }
    public static void mensagemErro(String msg){
        err = msg;
    }

    public static void menuPrincipal(){
        System.out.println("""
                -----Gestão de Hotel-----
                Digite a opção:
                1 - Adicionar Cliente       6 - Listar Reservas                     0 - Sair
                2 - Adicinar Quarto         7 - Listar Pessoas
                3 - Realizar Reserva        8 - Listar Clientes Hospedes
                4 - Listar Clientes         9 - Listar Clientes Responsáveis
                5 - Listar Quartos          10 - Listar Alocações""");
    }
    public static void menuListarClientes(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Clientes-
                Digite a opção:
                0 - Voltar
                1 - Listar Todos
                2 - Listar os que possuem Reserva""");
    }
    public static void menuListarQuartos(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Quartos-
                Digite a opção:
                0 - Voltar
                1 - Listar Todos
                2 - Listar os que possuem Reserva ativa""");
    }
    public static void menuListarReservas(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Reservas-
                Digite a opção:
                0 - Voltar
                1 - Listar Todas""");
    }
    public static void menuListarPessoas(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Pessoas-
                Digite a opção:
                0 - Voltar
                1 - Listar Todas
                2 - Listar apenas não Clientes""");
    }
    public static void menuListarHospedes(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Hospedes-
                Digite a opção:
                0 - Voltar
                1 - Listar Todos""");
    }
    public static void menuListarResponsaveis(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Responsáveis-
                Digite a opção:
                0 - Voltar
                1 - Listar Todos""");
    }
    public static void menuListarAlocacoes(){
        System.out.println("""
                -----Gestão de Hotel-----
                -Listar Alocações-
                Digite a opção:
                0 - Voltar
                1 - Todas
                2 - Apenas as abertas em certa data""");
    }

    public static void addCliente(){
        limparTela();

        System.out.println("Digite o nome:");
        String nome = s.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = s.nextLine();
        System.out.println("Digite o sexo (H/M/N):");
        String sexo = s.nextLine();
        System.out.println("Digite o CEP:");
        String cep = s.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = s.nextLine();

        Pessoa p = new Pessoa(nome, cpf, sexo, cep, telefone);

        if(sys.adicionarPessoa(p) == 0){
            mensagemErro("Erro: Adicionar cliente(pessoa)");
            return;
        }

        System.out.println("Digite o email pessoal:");
        String emailp = s.nextLine();

        Cliente c = new Cliente(emailp, p);

        if(sys.adicionarCliente(c) == 0){
            mensagemErro("Erro: Adicionar cliente(cliente)");
            return;
        }
    }
    public static void lisClientes(){
        limparTela();

        int escolha = -1;

        while (escolha != 0) {
            menuListarClientes();
            System.out.println(err);
            mensagemErro("");

            escolha = Integer.parseInt(s.nextLine());

            switch (escolha){
                default -> mensagemErro("Erro: Digite um valor válido");
                case 0 -> mensagemErro("");
                case 1 -> lisClientesTodos();
//                case 2 -> lisPessoasNClientes();
            }
        }
    }
    public static void lisClientesTodos(){
        sys.listarClientes();
    }
    public static void lisQuartos(){
        limparTela();

        int escolha = -1;

        while (escolha != 0) {
            menuListarQuartos();
            System.out.println(err);
            mensagemErro("");

            escolha = Integer.parseInt(s.nextLine());

            switch (escolha){
                default -> mensagemErro("Erro: Digite um valor válido");
                case 0 -> mensagemErro("");
                case 1 -> lisQuartosTodos();
//                case 2 -> lisPessoasNClientes();
            }
        }
    }
    public static void lisQuartosTodos(){
        sys.listarQuartos();
    }
    public static void lisPessoas(){
        limparTela();

        int escolha = -1;

        while (escolha != 0) {
            menuListarPessoas();
            System.out.println(err);
            mensagemErro("");

            escolha = Integer.parseInt(s.nextLine());

            switch (escolha){
                default -> mensagemErro("Erro: Digite um valor válido");
                case 0 -> mensagemErro("");
                case 1 -> lisPessoasTodas();
//                case 2 -> lisPessoasNClientes();
            }
        }
    }
    public static void lisPessoasTodas(){
        sys.listarPessoas();
    }

}
