package Controlador;

import Conexion.ConexionBD;
import Modelo.Turno;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

/**
 *
 * @author Genaro López
 * @version 21/08/2014
 */
public class DAO_Turno extends Turno {

    public LinkedList<Turno> turnos;
    public ConexionBD conexion;

    public DAO_Turno(int idEstudiante, int idTipoDeTurno, String fecha) {
        super(idEstudiante, idTipoDeTurno, fecha);
        conexion = new Conexion.ConexionBD();
    }

    public DAO_Turno() {
        conexion = new Conexion.ConexionBD();
    }

    public int agregarTurno(int cedula, String contraseña) {
        String sql = "SELECT agregar_entrada_inv(" + cedula + ",'" + contraseña + "')";
        return conexion.login(sql);
    }

    public int cerrarTurno(int cedula, String contraseña, String descripcion) {
        String sql = "SELECT terminar_turno(" + cedula + ",'" + contraseña + "','" + descripcion + "')";
        return conexion.login(sql);
    }

    public void consultarTurnos() {
        turnos = new LinkedList<>();
        String sql = "select u.first_name, u.last_name, t.fecha_inicio,t.duracion,t.descripcion from users as u inner join turno as t on u.id = t.estudiante and  EXTRACT(DAY from t.fecha_inicio) > EXTRACT (DAY from 'yesterday'::timestamp with time zone)";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                 String nombre = conexion.getRes().getString(1)+" "+conexion.getRes().getString(2);
                 String fecha = conexion.getRes().getString(3);
                 String duracion = conexion.getRes().getString(4);
                 String descricion = conexion.getRes().getString(5);
                 
                 Timestamp ts = Timestamp.valueOf(fecha);
                 
            }
        } catch (SQLException e) {
            
        }
    }

}
