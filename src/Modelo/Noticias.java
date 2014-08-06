package Modelo;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Noticias {

    private int id;
    private int idTurno;
    private String contenido;
    
    public Noticias(int id,int idTurno, String contenido) {
        this.id = id;
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
}
