package Modelo;

/**
 * Representa las secciones del observatorio.
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Seccion {

    private int id;
    private String nombre;
    private String descripcion;

    /**
     * Constructor con 2 parámetros.
     *
     * @param id id de la sección.
     * @param nombre Nombre de la sección.
     */
    public Seccion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor con 3 parámetros.
     *
     * @param id id de la sección.
     * @param nombre Nombre de la sección.
     * @param descripcion Descripción de la sección.
     */
    public Seccion(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
