package Controlador;

import Conexion.ConexionBD;
import Modelo.Seccion;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class DAO_Seccion extends Seccion {

    public ConexionBD conexion;

    public DAO_Seccion() {
        super(0, null, null);
        conexion = new Conexion.ConexionBD();
    }

    public DAO_Seccion(int id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
        conexion = new Conexion.ConexionBD();
    }

    /**
     * Consulta la base de datos para obtener una lista con las secciones.
     * @return Una lista con las secciones en la base de datos.
     */
    public LinkedList<Seccion> consultarSecciones() {
        LinkedList<Seccion> secciones = new LinkedList<Seccion>();
        String sql = "SELECT id, nombre FROM sections order by id";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                secciones.add(new Seccion(Integer.parseInt(conexion.getRes().getString(1).toString()),
                        conexion.getRes().getString(2).toString()));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.toString());
        }
        return secciones;
    }

}
