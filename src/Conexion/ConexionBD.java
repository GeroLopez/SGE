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

    private ResultSet res = null;
    private Connection con;
    private Statement st = null;
    private String driver;
    private String url;
    private String userDB;
    private String passDB;

    public ConexionBD() {
        this.con = null;
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://127.0.0.1:5432/volcano";
        userDB = "postgres";
        passDB = "admin";
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
            Class.forName(getDriver());
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargal el driver, " + e.toString());
            return -1;
        }
        try {
            setCon(DriverManager.getConnection(getUrl(), getUserDB(), getPassDB()));
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
            getCon().close();
            resultado = true;
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexión, " + e.toString());
        }
        return resultado;
    }

    /**
     * Esta encargado de hacer la confirmación de los datos de inicio a la base
     * de datos.
     *
     * @param sql La sentencia sql a ejecutar.
     * @return El número que indica que tipo de usuario está tratando de iniciar
     * si retorna 1 despliega el formulario de administración, si retorna 2
     * despliega el formulario de registro de entradas y si retorna -1 es porque
     * los datos de inicio son incorrectos.
     */
    public int login(String sql) {
        int resultado = -4;
        try {
            st = getCon().createStatement();
            setRes(st.executeQuery(sql));
            while (getRes().next()) {
                resultado = Integer.parseInt(getRes().getString(1).toString());
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("este es el del mensaje "+e.getMessage());
        }
        return resultado;
    }

    /**
     * Permite realizar consultas a la base de datos.
     *
     * @param sql Sentencia sql a ejecutar.
     */
    public void consultar(String sql) {
        setRes(null);
        try {
            st = getCon().createStatement();
            setRes(st.executeQuery(sql));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Realiza inserciones a la base de datos a partir del sql proporcionado.
     * @param sql
     * @return una cadena que indica el estado de la inserción, en caso exitoso
     * retorna la cadena "exito", en caso contrario retorna un mensaje con la 
     * causa del error.
     */
    public String insertar(String sql) {
        String respuesta="exito";
        try {
            st = getCon().createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("esta es la bd "+e.toString());  
            respuesta=e.toString().split("\n")[1].substring(9);
        }
        return respuesta;
    }

    /**
     * @return the res
     */
    public ResultSet getRes() {
        return res;
    }

    /**
     * @param res the res to set
     */
    public void setRes(ResultSet res) {
        this.res = res;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the st
     */
    public Statement getSt() {
        return st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(Statement st) {
        this.st = st;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the userDB
     */
    public String getUserDB() {
        return userDB;
    }

    /**
     * @param userDB the userDB to set
     */
    public void setUserDB(String userDB) {
        this.userDB = userDB;
    }

    /**
     * @return the passDB
     */
    public String getPassDB() {
        return passDB;
    }

    /**
     * @param passDB the passDB to set
     */
    public void setPassDB(String passDB) {
        this.passDB = passDB;
    }
}
