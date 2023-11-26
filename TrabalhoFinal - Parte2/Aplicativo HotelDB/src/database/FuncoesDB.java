package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FuncoesDB {
    public FuncoesDB() {
    }

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
        } catch (Exception var6) {
            System.out.println(var6);
        }

        return con;
    }

    public void criarTabela(Connection con, String nomeTabela, String query) {
        try {
            query = "CREATE TABLE " + nomeTabela + query;
            Statement st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Tabela criada");
        } catch (Exception var6) {
            System.out.println(var6);
        }

    }

    public void inserirLinha(Connection con, String nomeTabela, String nome, String endereco) {
        try {
            String query = String.format("INSERT INTO %s(nome, endereco) values('%s', '%s')", nomeTabela, nome, endereco);
            Statement st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Linha inserida");
        } catch (Exception var7) {
            System.out.println(var7);
        }

    }

    public void inserirQuarto(Connection con, String numero, String luxo, String manutencao) {
        try {
            String query = String.format("INSERT INTO \"Quartos\" (\"numeroQuarto\", \"tipoLuxo\", \"emManutencao\") values(%s, %s, %s)", numero, luxo, manutencao);
            Statement st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Linha inserida");
        } catch (Exception var7) {
            System.out.println(var7);
        }

    }
}
