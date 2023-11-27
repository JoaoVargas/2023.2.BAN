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
    public int inserirReserva(Connection con, Reserva r) {
        try {
            String query = "INSERT INTO \"Reservas\" (\"dataRealizada\") VALUES (date(?))";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, r.getDataRealizada());

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
    public int inserirAlocacao(Connection con, Alocacao a) {
        try {
            String query = "INSERT INTO \"Alocacoes\" (\"codReserva\", \"codQuarto\", \"dataCheckIn\", \"dataCheckOut\") VALUES (?, ?, date(?), date(?))";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getCodReserva());
            ps.setInt(2, a.getCodQuarto());
            ps.setString(3, a.getDataCheckIn());
            ps.setString(4, a.getDataCheckOut());

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
    public int inserirResponsavel(Connection con, Responsavel r) {
        try {
            String query = "INSERT INTO \"Responsaveis\" (\"codCliente\", \"codReserva\") VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, r.getCodCliente());
            ps.setInt(2, r.getCodReserva());

            ps.executeUpdate();

//            ResultSet rs = ps.getGeneratedKeys();
//
//            int chave = 0;
//            if (rs.next()) {
//                chave = rs.getInt(1);
//            }

            int chave = 1;
            return chave;
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }
    public int inserirHospede(Connection con, Hospede h) {
        try {
            String query = "INSERT INTO \"Hospedes\" (\"codCliente\", \"codReserva\") VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, h.getCodCliente());
            ps.setInt(2, h.getCodReserva());

            ps.executeUpdate();

//            ResultSet rs = ps.getGeneratedKeys();
//
//            int chave = 0;
//            if (rs.next()) {
//                chave = rs.getInt(1);
//            }

            int chave = 1;
            return chave;
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }

    public ResultSet listarClientesHospedes(Connection con) {
        try {
            String query = "SELECT * FROM \"Clientes\"  WHERE \"codCliente\" IN (SELECT \"codCliente\" FROM \"Hospedes\") ORDER BY \"codCliente\" ASC ";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    public ResultSet listarClientesResponsaveis(Connection con) {
        try {
            String query = "SELECT * FROM \"Clientes\"  WHERE \"codCliente\" IN (SELECT \"codCliente\" FROM \"Responsaveis\") ORDER BY \"codCliente\" ASC ";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }


}
