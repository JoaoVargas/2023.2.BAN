package apresentacao;

import database.FuncoesDB;
import java.sql.Connection;

public class Principal {
    public Principal() {
    }

    public static void main(String[] args) {
        FuncoesDB db = new FuncoesDB();
        Connection con = db.conectarDB("HotelDB-JoaoGuilhermeVargas", "postgres", "230505");
        db.inserirQuarto(con, "1003", "FALSE", "FALSE");
        db.inserirQuarto(con, "1004", "FALSE", "TRUE");
        db.inserirQuarto(con, "1005", "FALSE", "FALSE");
        db.inserirQuarto(con, "1006", "FALSE", "FALSE");
        db.inserirQuarto(con, "1007", "FALSE", "FALSE");
        db.inserirQuarto(con, "1008", "FALSE", "TRUE");
        db.inserirQuarto(con, "1009", "FALSE", "FALSE");
        db.inserirQuarto(con, "1010", "FALSE", "FALSE");
        db.inserirQuarto(con, "1101", "TRUE", "FALSE");
        db.inserirQuarto(con, "1102", "TRUE", "FALSE");
        db.inserirQuarto(con, "1103", "TRUE", "TRUE");
        db.inserirQuarto(con, "1104", "TRUE", "FALSE");
        db.inserirQuarto(con, "1105", "TRUE", "FALSE");
        db.inserirQuarto(con, "1106", "TRUE", "FALSE");
        db.inserirQuarto(con, "1107", "TRUE", "TRUE");
        db.inserirQuarto(con, "1108", "TRUE", "FALSE");
        db.inserirQuarto(con, "1109", "TRUE", "FALSE");
        db.inserirQuarto(con, "1110", "TRUE", "TRUE");
    }
}
