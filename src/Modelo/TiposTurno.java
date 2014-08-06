package Modelo;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class TiposTurno {

    private int id;
    private String nombre;
    private String descripción;

    /**
     * Constructor por defecto de la clase.
     * @param id Es el id único de cada tipo de turno.
     * @param nombre Nomre del turno.
     * @param descripción Descripción del turno.
     */
    public TiposTurno(int id, String nombre, String descripción) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
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
     * @return the descripción
     */
    public String getDescripción() {
        return descripción;
    }

    /**
     * @param descripción the descripción to set
     */
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

}
