package Controlador;

import Conexion.ConexionBD;
import Modelo.Turno;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Realiza la mediación entre las interfaces graficas con la clase Turno y 
 * la base de datos.
 * @author Genaro López
 * @version 21/08/2014
 */
public class DAO_Turno extends Turno {

    public LinkedList<Turno> turnos;
    public ConexionBD conexion;

    /**
     * Constructor
     * @param idEstudiante Identificador del estudiante.
     * @param idTipoDeTurno Identificador del tipo  de turno.
     * @param fecha fecha del turno.
     */
    public DAO_Turno(int idEstudiante, int idTipoDeTurno, String fecha) {
        super(idEstudiante, idTipoDeTurno, fecha);
        conexion = new Conexion.ConexionBD();
    }

    /**
     * Constructor
     */
    public DAO_Turno() {
        conexion = new Conexion.ConexionBD();
    }

    /**
     * Registra un nuevo turno de investigación en la base de datos.
     * @param cedula Cédula del estudiante.
     * @param contraseña Contraseña del estudiante.
     * @return
     */
    public int agregarTurno(int cedula, String contraseña) {
        String sql = "SELECT agregar_entrada_inv(" + cedula + ",'" + contraseña + "')";
        return conexion.login(sql);
    }

    /**
     * Registra el final de un turno de investigación en la base de datos.
     * @param cedula Cédula del estudiante.
     * @param contraseña Contraseña del estudiante.
     * @param descripcion Descripción de las tares realizadas en el turno.
     * @return
     */
    public int cerrarTurno(int cedula, String contraseña, String descripcion) {
        String sql = "SELECT terminar_turno(" + cedula + ",'" + contraseña + "','" + descripcion + "')";
        return conexion.login(sql);
    }

    /**
     * Consulta en la base de datos los turnos del día en curso, los cuales
     * guarda en la lista turnos.
     * @return Mensaje indicando si la consulta se realizó exitosamento o no.
     */
    public String consultarTurnos() {
        String respuesta = "exito";
        turnos = new LinkedList<Turno>();
        String sql = "select u.first_name, u.last_name, t.fecha_inicio,t.duracion,t.descripcion, t.id, t.tipo, u.id from users as u inner join turno as t on u.id = t.estudiante and  EXTRACT(DAY from t.fecha_inicio) > EXTRACT (DAY from 'yesterday'::timestamp with time zone) order by t.fecha_inicio";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                String realizadoPor = conexion.getRes().getString(1) + " " + conexion.getRes().getString(2);
                String fechaI = conexion.getRes().getString(3);
                int duracion = 0;
                try {
                    duracion = Integer.parseInt(conexion.getRes().getString(4));
                } catch (SQLException | NumberFormatException e) {
                }
                String descripcion = conexion.getRes().getString(5);
                int id = Integer.parseInt(conexion.getRes().getString(6));
                int idTurno = Integer.parseInt(conexion.getRes().getString(7));
                int idEstudiante = Integer.parseInt(conexion.getRes().getString(8));

                Turno turno = new Turno(id, idEstudiante, idTurno, fechaI);
                turno.setRealizadoPor(realizadoPor);
                turno.setDuración(duracion);
                turno.setDescripcion(descripcion);
                if (duracion != 0) {
                    Timestamp fe = Timestamp.valueOf(fechaI);
                    Calendar ca = Calendar.getInstance();
                    ca.setTime(fe);
                    ca.add(Calendar.MINUTE, duracion);
                    fe = new Timestamp(ca.getTimeInMillis());
                    String fechaFinal = fe.toString();
                    turno.setFechaFinal(fechaFinal);
                }
                turnos.add(turno);
            }
        } catch (SQLException e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }
}
