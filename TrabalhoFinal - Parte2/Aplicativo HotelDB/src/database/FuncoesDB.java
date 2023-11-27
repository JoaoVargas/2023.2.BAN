package database;

import dados.*;

import java.sql.*;

public class FuncoesDB {
    public Connection conectarDB(String nomeDB, String user, String password) {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeDB, user, password);
            if (con != null) {
                System.out.println("Conexão bem sucedida");
            } else {
                System.out.println("Erro: Conexão com DB");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

//    public void criarTabela(Connection con, String nomeTabela, String query) {
//        try {
//            query = "CREATE TABLE " + nomeTabela + query;
//            Statement st = con.createStatement();
//            st.executeUpdate(query);
//            System.out.println("Tabela criada");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

//    public void inserirLinha(Connection con, String nomeTabela, String nome, String endereco) {
//        try {
//            String query = String.format("INSERT INTO %s(nome, endereco) values('%s', '%s')", nomeTabela, nome, endereco);
//            Statement st = con.createStatement();
//            st.executeUpdate(query);
//            System.out.println("Linha inserida");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

//    public void inserirQuarto(Connection con, String numero, String luxo, String manutencao) {
//        try {
//            String query = String.format("", numero, luxo, manutencao);
//            Statement st = con.createStatement();
//            st.executeUpdate(query);
//            System.out.println("Linha inserida");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

    public ResultSet listarTabela(Connection con, String tabela, String chaveOrdem) {
        try {
            Statement st = con.createStatement();

            String query = "SELECT * FROM \"%s\" ORDER BY \"%s\" ASC ".formatted(tabela, chaveOrdem);

            return st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public int inserirPessoa(Connection con, Pessoa p) {
        try {
            String query = "INSERT INTO \"Pessoas\" (\"nome\", \"cpf\", \"sexo\", \"cep\", \"telefone\") VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getSexo());
            ps.setString(4, p.getCep());
            ps.setString(5, p.getTelefone());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            int chave = 0;
            if (rs.next()) {
                chave = rs.getInt(1);
            }

            return chave;
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }
    public int inserirCliente(Connection con, Cliente c) {
        try {
            String query = "INSERT INTO \"Clientes\" (\"codPessoa\", \"emailPessoal\") VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getCodPessoa());
            ps.setString(2, c.getEmailPessoal());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            int chave = 0;
            if (rs.next()) {
                chave = rs.getInt(1);
            }

            return chave;
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }
    public int inserirQuarto(Connection con, Quarto q) {
        try {
            String query = "INSERT INTO \"Quartos\" (\"numeroQuarto\", \"tipoLuxo\", \"emManutencao\") VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, q.getNumeroQuarto());
            ps.setBoolean(2, q.isTipoLuxo());
            ps.setBoolean(3, q.isEmManutencao());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            int chave = 0;
            if (rs.next()) {
                chave = rs.getInt(1);
            }

            return chave;
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }


}
