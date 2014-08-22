package Modelo;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Turno {

    private int id;
    private int idEstudiante;
    private int idTipoDeTurno;
    private String fechaInicial;
    private String fechaFinal;
    private int duración;
    private String descripcion;
    private boolean estado;
    private String realizadoPor;

    public Turno(int idEstudiante, int idTipoDeTurno, String fecha) {
        this.idEstudiante = idEstudiante;
        this.idTipoDeTurno = idTipoDeTurno;
        this.fechaInicial = fecha;
    }
    
    public Turno(int id,int idEstudiante, int idTipoDeTurno, String fecha) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idTipoDeTurno = idTipoDeTurno;
        this.fechaInicial = fecha;
    }

    public Turno() {
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
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the fechaInicial
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the duración
     */
    public int getDuración() {
        return duración;
    }

    /**
     * @param duración the duración to set
     */
    public void setDuración(int duración) {
        this.duración = duración;
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

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the idTipoDeTurno
     */
    public int getIdTipoDeTurno() {
        return idTipoDeTurno;
    }

    /**
     * @param idTipoDeTurno the idTipoDeTurno to set
     */
    public void setIdTipoDeTurno(int idTipoDeTurno) {
        this.idTipoDeTurno = idTipoDeTurno;
    }

    /**
     * @return the realizadoPor
     */
    public String getRealizadoPor() {
        return realizadoPor;
    }

    /**
     * @param realizadoPor the realizadoPor to set
     */
    public void setRealizadoPor(String realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    /**
     * @return the fechaFinal
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

}
