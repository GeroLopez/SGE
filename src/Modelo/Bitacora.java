package Modelo;

import java.awt.Image;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Bitacora {

    private int id;
    private int idTurno;
    private String contenido;
    private int resaltado;
    private Image imagen;

    public Bitacora(int idTurno, String contenido) {
        this.idTurno = idTurno;
        this.contenido = contenido;
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
     * @return the idTurno
     */
    public int getIdTurno() {
        return idTurno;
    }

    /**
     * @param idTurno the idTurno to set
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the resaltado
     */
    public int getResaltado() {
        return resaltado;
    }

    /**
     * @param resaltado the resaltado to set
     */
    public void setResaltado(int resaltado) {
        this.resaltado = resaltado;
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
