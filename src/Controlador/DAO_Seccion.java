package Controlador;

import Modelo.Seccion;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class DAO_Seccion extends Seccion {

    public Conexion.ConexionBD conexion;

    public DAO_Seccion() {
        super(0, null, null);
        conexion = new Conexion.ConexionBD();
    }

    public DAO_Seccion(int id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
        conexion = new Conexion.ConexionBD();
    }

    public LinkedList<Seccion> consultarSecciones() {
        LinkedList<Seccion> secciones = new LinkedList<Seccion>();
        String sql = "";
        try {
            conexion.consultar(sql);
            while (conexion.getRes().next()) {
                secciones.add(new Seccion(Integer.parseInt(conexion.getRes().getString(1).toString()),
                        conexion.getRes().getString(2).toString(), conexion.getRes().getString(2).toString()));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.toString());
        }
        return secciones;

    }

}
