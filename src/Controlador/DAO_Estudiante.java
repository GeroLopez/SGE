package Controlador;

import Conexion.ConexionBD;
import Modelo.Estudiante;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class DAO_Estudiante extends Estudiante {

    public ConexionBD conexion;

    public DAO_Estudiante(int cedula, String nombre, String apellido,
            int telefono1, int tipoDeUsuario, int seccion, String fechaCreado,
            String email, String password,
            boolean esMonitoreo, boolean esInvestigacion) {
        super(cedula, nombre, apellido, telefono1, tipoDeUsuario, seccion,
                fechaCreado, email, password, esMonitoreo, esInvestigacion);
        conexion = new ConexionBD();
    }

    /**
     * Agrega un nuevo usuario y estudiante a la base de datos.
     *
     * @return
     */
    public boolean AgregarEstudiante() {
        boolean resultado = false;
//        try {
            String sql = "SELECT insertar_usuario_estudiante('" + this.getEmail() + "',"
                    + "'" + this.getPassword() + "',true,'" + this.getFechaCreado() + "','"
                    + this.getFechaCreado() + "','" + this.getNombre() + "','"
                    + this.getApellido() + "','" + this.getNombreDeUsuario() + "','"
                    + this.getTelefono1() + "','" + this.getTelefono2() + "',2," + this.getSeccion() + ","
                    + this.getCedula() + ","
                    + this.isEsMonitoreo() + "," + this.isEsInvestigacion() + ")";
            resultado = conexion.insertar(sql);
//        } catch (Exception e) {
//            
//            System.out.println("el error esta aca " +e.);
//        }
        return resultado;
    }
}
