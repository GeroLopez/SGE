package Modelo;

import java.sql.Date;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Errores {

    private int id;
    private int idturno;
    private Date fechaSolucion;
    private String error;

    public Errores(int id,int idturno, String error) {
        this.id = id;
        this.idturno = idturno;
        this.error = error;
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
     * @return the idturno
     */
    public int getIdturno() {
        return idturno;
    }

    /**
     * @param idturno the idturno to set
     */
    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    /**
     * @return the fechaSolucion
     */
    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    /**
     * @param fechaSolucion the fechaSolucion to set
     */
    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

}
