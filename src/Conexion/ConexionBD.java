package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * La clase conexion es la encargada de gestionar la conexión y consultas a la
 * base de datos.
 *
 * @author Genaro López
 * @version 5/08/2014
 */
public class ConexionBD {

    ResultSet res = null;
    private Connection con;
    Statement st = null;
    String driver;
    String url;
    String userDB;
    String passDB;

    public ConexionBD() {
        this.con = null;
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://127.0.0.1:5432/volcano";
        userDB = "postgres";
        passDB = "admin";
        System.out.println("resultado = " + conectar());
    }

    /**
     * Establece la conexión con la base de datos.
     *
     * @return -1 en caso de que no se logre cargar el driver de postgres, -2 si
     * no se logra establecer conexión por motivo diferente al driver, 1 en caso
     * de establecer la conexión con éxito.
     */
    public final int conectar() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargal el driver, " + e.toString());
            return -1;
        }
        try {
            con = DriverManager.getConnection(url, userDB, passDB);
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la conexion, " + e.toString());
            return -2;
        }
        return 1;
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @return true en caso de cerrarse la conexión éxitosamente, false en caso
     * contrario.
     */
    public boolean cerrarConexion() {
        boolean resultado = false;
        try {
            con.close();
            resultado = true;
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexión, " + e.toString());
        }
        return resultado;
    }

    public int login(int cedula, String contrasena) {
        int resultado = 0;
        String sql = "select login(" + cedula + ",'" + contrasena + "')";
        try {
            Statement stament = con.createStatement();
            res = stament.executeQuery(sql);
            while (res.next()) {
                resultado = Integer.parseInt(res.getString(1).toString());
            }           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}
