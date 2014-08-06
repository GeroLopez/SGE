package Modelo;

import java.sql.Date;

/**
 * Es la clase que representa un estudiante.
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Estudiante extends Usuario {

    private boolean enActividad;
    private boolean esMonitoreo;
    private boolean esInvestigacion;
    private float horasDebe;
    private Date ultimaLecturaBitacora;

    /**
     * Constructor por defecto de la clase.
     *
     * @param id El id del usuario.
     * @param cedula La cédula.
     * @param nombre Nombre.
     * @param apellido Apellido.
     * @param telefono1 El teléfono1 del usuario.
     * @param tipoDeUsuario Representa el tipo de usuario.
     * @param seccion Indica a que sección del observatorio pertenece.
     * @param fechaCreado Fecha en la que se creo el usuario.
     * @param esMonitoreo Indica si realiza tareas de monitoreo.
     * @param esInvestigacion Indica si realiza tareas de investigación.
     */
    public Estudiante(int id, int cedula, String nombre, String apellido, int telefono1,
            int tipoDeUsuario, int seccion, Date fechaCreado, boolean esMonitoreo,
            boolean esInvestigacion) {
        super(id, cedula, nombre, apellido, telefono1, tipoDeUsuario, seccion, fechaCreado);
    }

    /**
     * @return the enActividad
     */
    public boolean isEnActividad() {
        return enActividad;
    }

    /**
     * @param enActividad the enActividad to set
     */
    public void setEnActividad(boolean enActividad) {
        this.enActividad = enActividad;
    }

    /**
     * @return the esMonitoreo
     */
    public boolean isEsMonitoreo() {
        return esMonitoreo;
    }

    /**
     * @param esMonitoreo the esMonitoreo to set
     */
    public void setEsMonitoreo(boolean esMonitoreo) {
        this.esMonitoreo = esMonitoreo;
    }

    /**
     * @return the esInvestigacion
     */
    public boolean isEsInvestigacion() {
        return esInvestigacion;
    }

    /**
     * @param esInvestigacion the esInvestigacion to set
     */
    public void setEsInvestigacion(boolean esInvestigacion) {
        this.esInvestigacion = esInvestigacion;
    }

    /**
     * @return the horasDebe
     */
    public float getHorasDebe() {
        return horasDebe;
    }

    /**
     * @param horasDebe the horasDebe to set
     */
    public void setHorasDebe(float horasDebe) {
        this.horasDebe = horasDebe;
    }

    /**
     * @return the ultimaLecturaBitacora
     */
    public Date getUltimaLecturaBitacora() {
        return ultimaLecturaBitacora;
    }

    /**
     * @param ultimaLecturaBitacora the ultimaLecturaBitacora to set
     */
    public void setUltimaLecturaBitacora(Date ultimaLecturaBitacora) {
        this.ultimaLecturaBitacora = ultimaLecturaBitacora;
    }

}
