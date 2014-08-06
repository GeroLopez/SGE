package Controlador;

import Conexion.ConexionBD;
import Modelo.Login;

/**
 * Clase encargada de mediar entre la GUI y el modelo para realizar el login
 *
 * @author Genaro López
 * @version 5/08/2014
 */
public class DAO_Login extends Login {

    public Conexion.ConexionBD conexion;

    /**
     * Constructor por defecto.
     *
     * @param usuario es la cedula del usuario.
     * @param contraseña la contraseña.
     */
    public DAO_Login(int usuario, String contraseña) {
        super(usuario, contraseña);
        conexion = new ConexionBD();
    }

    /**
     * Realiza la petición a la base de datos
     *
     * @return El número que indica que tipo de usuario está tratando de iniciar
     * si retorna 1 despliega el formulario de administración, si retorna 2
     * despliega el formulario de registro de entradas y si retorna -1 es porque
     * los datos de inicio son incorrectos.
     */
    public int login() {
        String sql = "select login(" + this.getUsuario() + ",'" + this.getContraseña() + "')";
        return conexion.login(sql);
    }

}
