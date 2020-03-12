package Databeis;

import java.sql.*;

public class Database {

    public static void main(String[] args) throws Exception {


        Database p = new Database();
        p.CrearConexion();

        Pantalla r = new Pantalla(p);

        /*for (int i = 0; i <r.tablabase.length; i++) {
            for (int j = 0; j < r.tablabase[0].length ; j++) {

                System.out.println(r.tablabase[i][j][0]);
            }
        }
        System.out.println();
*/
    }


    String namedatabase = "ejercicio27";
    String myDriver= "com.mysql.jdbc.Driver";
    String myUrl= "jdbc:mysql://localhost/" + namedatabase;
    Connection conn;
    Statement st;
    ResultSet rs;

    static String[][][] DATABASE;
    static String[][] COLUMNS;
    static String[] TABLES;

    /*Database(String namedatabase) throws Exception {

        this.namedatabase = namedatabase;

        CrearConexion();

        TABLES = Preguntar("SHOW TABLES","Tables_in_" + namedatabase);

        for (int i = 0; i < TABLES.length; i++) {
            System.out.println(TABLES[i]);
            COLUMNS[i] = Preguntar("show columns from " + TABLES[i], "Field");
        }
        for (int i = 0; i <TABLES.length ; i++) {
            DATABASE[i] = Preguntar("SELECT * FROM", COLUMNS[i]);
        }

        Desconectar();
    }
*/

    public void CrearConexion() throws Exception {

        Class.forName(myDriver);
        conn = DriverManager.getConnection(myUrl, "El_Tuyo", "pene");
        System.out.println("Conectando con la base");
    }
    public void Desconectar() throws SQLException {

        if (conn != null)
        conn.close();
        if (st != null)
        st.close();
        if (rs != null)
        rs.close();
        System.out.println("cerrando conexion");
    }

    public void drop() throws SQLException {
        st = conn.createStatement();
        rs = st.executeQuery("drop " + namedatabase);

    }

    public String[] Preguntar(String query, String lascolumnas) throws Exception {


        st = conn.createStatement();
        rs = st.executeQuery(query);
        int nfilas = 0;
        int i = 0;

        while (rs.next()){
            nfilas ++;
        }

        String[] respuestas = new String[nfilas];

        rs = st.executeQuery(query);
        while (rs.next()){

            respuestas[i] = rs.getString(lascolumnas);
            i++;
        }

        return respuestas;
    }


    public String[][] Preguntar(String query, String[] latabla) throws Exception {


        st = conn.createStatement();
        rs = st.executeQuery(query);
        int nfilas = 0;
        int i = 0;

        while (rs.next()){
            nfilas ++;
        }

        String[][] respuestas = new String[nfilas][latabla.length];

        rs = st.executeQuery(query);
        while (rs.next()){

            for (int j = 0; j <latabla.length ; j++) {

                respuestas[i][j] = rs.getString(latabla[j]);
            }
            i++;



        }

        System.out.println(query);

        for (int j = 0; j < respuestas.length ; j++) {
            for (int k = 0; k < respuestas[j].length ; k++) {

                System.out.print(respuestas[j][k] + "  ");
            }
            System.out.println("");
        }

        return respuestas;
    }
}
