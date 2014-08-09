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
    public LinkedList<Estudiante> estudiantes;

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
                    + this.isEsMonitoreo() + "," + this.isEsInvestigacion() + ",'" + this.getDireccion() + "')";
            resultado = conexion.insertar(sql);
        } catch (Exception e) {
            System.out.println("el error esta aca " + e.toString());

        }
        return resultado;
    }

    /**
     * Consulta la base de datos para obtener una lista con los estudiantes.
     */
    public void consultarEstudiantes() {
        estudiantes = new LinkedList<Estudiante>();
        String sql = "select DISTINCT u.id, u.cedula, u.first_name, u.last_name, u.phone_1, u.phone_2, u.direccion, u.email, u.username, u.activated, u.user_types_id, u.sections_id, u.created_at, e.monitoreo, e.investigacion, s.nombre, e.fecha_salida from users as u INNER JOIN estudiante as e on (u.user_types_id=2 and e.id=u.id) INNER JOIN sections s on  u.sections_id=s.id order by u.id";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                int id = Integer.parseInt(conexion.getRes().getString(1));
                int cedula = Integer.parseInt(conexion.getRes().getString(2));
                String nombre = conexion.getRes().getString(3);
                String apellido = conexion.getRes().getString(4);
                int tel1 = 0;
                int tel2 = 0;
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
                direccion = (direccion == null) ? "----" : direccion;
                String email = conexion.getRes().getString(8);
                String username = conexion.getRes().getString(9);
                boolean estado = (conexion.getRes().getString(10).equalsIgnoreCase("t")) ? true : false;
                int tipoUsuario = Integer.parseInt(conexion.getRes().getString(11));
                int seccion = Integer.parseInt(conexion.getRes().getString(12));
                String fechaCreado = conexion.getRes().getString(13);
                boolean monitoreo = (conexion.getRes().getString(14).equalsIgnoreCase("t")) ? true : false;
                boolean investigacion = (conexion.getRes().getString(15).equalsIgnoreCase("t")) ? true : false;
                String nombreSeccion = conexion.getRes().getString(16);
                String fechaSalida = conexion.getRes().getString(17);
                Estudiante es = new Estudiante(id, cedula, nombre, apellido, tel1, tel2, direccion, email, username, estado, tipoUsuario, seccion, fechaCreado, monitoreo, investigacion, nombreSeccion);
                fechaSalida = (fechaSalida == null) ? "----" : fechaSalida;
                es.setFechaSalida(fechaSalida);
                estudiantes.add(es);

            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Obtiene los datos del estudiante del cual se proporciona la cédula.
     *
     * @param cedula Cédula del estudiante.
     */
    public void cargarEstudianteActualizar(int cedula) {
        String sql = "select * from actualizar(" + cedula + ")";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                this.setNombre(conexion.getRes().getString(1));
                this.setApellido(conexion.getRes().getString(2));
                this.setCedula(Integer.parseInt(conexion.getRes().getString(3)));
                try {
                    this.setTelefono1(Integer.parseInt(conexion.getRes().getString(4)));
                    this.setTelefono2(Integer.parseInt(conexion.getRes().getString(5)));
                } catch (NumberFormatException e) {
                }
                String direccion = conexion.getRes().getString(6);
                this.setDireccion((direccion == null) ? "----" : direccion);
                this.setSeccion(Integer.parseInt(conexion.getRes().getString(7)));
                this.setEmail(conexion.getRes().getString(8));
                this.setPassword(conexion.getRes().getString(9));
                this.setEsMonitoreo((conexion.getRes().getString(10).equalsIgnoreCase("t")) ? true : false);
                this.setEsInvestigacion((conexion.getRes().getString(11).equalsIgnoreCase("t")) ? true : false);
                this.setId(Integer.parseInt(conexion.getRes().getString(12)));
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Consulta la base de datos para obtener una lista con las secciones.
     *
     * @return Una lista con las secciones en la base de datos.
     */
    public LinkedList<Integer> consultarCedulas() {
        LinkedList<Integer> cedulas = new LinkedList<Integer>();
        String sql = "SELECT cedula FROM users where user_types_id=2";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                cedulas.add(Integer.parseInt(conexion.getRes().getString(1).toString()));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.toString());
        }
        return cedulas;
    }

    /**
     * Actualiza el registro asociado al estudiante.
     * @return una cadena que indica el estado de la inserción, en caso exitoso
     * retorna la cadena "exito", en caso contrario retorna un mensaje con la
     * causa del error.
     */
    public String actualizarEstudiante() {
        String resultado = "";
        try {
            String sql = "SELECT actualizar_usuario_estudiante('" + this.getEmail() + "',"
                    + "'" + this.getPassword() + "','" + this.getNombre() + "','"
                    + this.getApellido() + "','" + this.getTelefono1() + "','" + this.getTelefono2() + "'," + this.getSeccion() + ","
                    + this.getCedula() + ","
                    + this.isEsMonitoreo() + "," + this.isEsInvestigacion() + ",'" + this.getDireccion() + "'," + this.getId() + ")";
            resultado = conexion.insertar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resultado;
    }
}
