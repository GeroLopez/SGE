package Controlador;

import Conexion.ConexionBD;
import Modelo.Estudiante;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class DAO_Estudiante extends Estudiante {

    public ConexionBD conexion;

    public DAO_Estudiante(int cedula, String nombre, String apellido,
            int telefono1, int tipoDeUsuario, int seccion, String fechaCreado,
            String email, String password) {
        super(cedula, nombre, apellido, telefono1, tipoDeUsuario, seccion,
                fechaCreado, email, password);
        conexion = new ConexionBD();
    }

    public DAO_Estudiante() {
        super(0, null, null, 0, 0, 0, null, null, null);
        conexion = new Conexion.ConexionBD();
    }

    /**
     * Agrega un nuevo usuario y estudiante a la base de datos.
     *
     * @return una cadena que indica el estado de la inserción, en caso exitoso
     * retorna la cadena "exito", en caso contrario retorna un mensaje con la
     * causa del error.
     */
    public String AgregarEstudiante() {
        String resultado = "";
        try {
            String sql = "SELECT insertar_usuario_estudiante('" + this.getEmail() + "',"
                    + "'" + this.getPassword() + "',true,'" + this.getFechaCreado() + "','"
                    + this.getFechaCreado() + "','" + this.getNombre() + "','"
                    + this.getApellido() + "','" + this.getNombreDeUsuario() + "','"
                    + this.getTelefono1() + "','" + this.getTelefono2() + "',2," + this.getSeccion() + ","
                    + this.getCedula() + ","
                    + this.isEsMonitoreo() + "," + this.isEsInvestigacion() + ")";
            resultado = conexion.insertar(sql);
        } catch (Exception e) {
            System.out.println("el error esta aca " + e.toString());

        }
        return resultado;
    }

    /**
     * Consulta la base de datos para obtener una lista con los estudiantes.
     *
     * @return Una lista con laos estudiantes en la base de datos.
     */
    public LinkedList<Estudiante> consultarEstudiantes() {
        LinkedList<Estudiante> estudiantes = new LinkedList<Estudiante>();
        String sql = "select DISTINCT u.id, u.cedula, u.first_name, u.last_name, u.phone_1, u.phone_2, u.direccion, u.email, u.username, u.activated, u.user_types_id, u.sections_id, u.created_at, e.monitoreo, e.investigacion  \n"
                + "from users as u right JOIN estudiante as e on u.user_types_id=2 and e.id=u.id order by u.id";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                int id = Integer.parseInt(conexion.getRes().getString(1));
                int cedula = Integer.parseInt(conexion.getRes().getString(2));
                String nombre = conexion.getRes().getString(3);
                String apellido = conexion.getRes().getString(4);
                int tel1=0;
                int tel2=0;
                try {
                    tel1 = Integer.parseInt(conexion.getRes().getString(5));
                    tel2 = Integer.parseInt(conexion.getRes().getString(6));
                } catch (NumberFormatException e) {

                }
                try {
                    tel2 = Integer.parseInt(conexion.getRes().getString(6));
                } catch (NumberFormatException e) {

                }
                String direccion = conexion.getRes().getString(7);
                String email = conexion.getRes().getString(8);
                String username = conexion.getRes().getString(9);
                boolean estado = (conexion.getRes().getString(10).equals("true")) ? true : false;
                int tipoUsuario = Integer.parseInt(conexion.getRes().getString(11));
                int seccion = Integer.parseInt(conexion.getRes().getString(12));
                String fechaCreado = conexion.getRes().getString(13);
                boolean monitoreo = (conexion.getRes().getString(14).equals("true")) ? true : false;
                boolean investigacion = (conexion.getRes().getString(15).equals("true")) ? true : false;
                estudiantes.add(new Estudiante(id, cedula, nombre, apellido, tel1, tel2, direccion, email, username, estado, tipoUsuario, seccion, fechaCreado, monitoreo, investigacion));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("hi madafaca " + e.toString());
        }
        return estudiantes;
    }
}
/**
 * u.id, u.cedula, u.first_name, u.last_name, u.phone_1, u.phone_2, u.direccion,
 * u.email, u.username, u.activated, u.user_types_id, u.sections_id,
 * u.created_at, e.monitoreo, e.investigacion
 */
