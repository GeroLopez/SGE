package Modelo;

import java.util.Date;

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
     * @param cedula La cédula.
     * @param nombre Nombre.
     * @param apellido Apellido.
     * @param telefono1 El teléfono1 del usuario.
     * @param tipoDeUsuario Representa el tipo de usuario.
     * @param seccion Indica a que sección del observatorio pertenece.
     * @param fechaCreado Fecha en la que se creo el usuario.
     * @param email El email del estudiante.
     * @param password La contraseña del estudiante.
     */
    public Estudiante(int cedula, String nombre, String apellido, int telefono1,
            int tipoDeUsuario, int seccion, String fechaCreado, String email, String password) {
        super(cedula, nombre, apellido, telefono1, tipoDeUsuario, seccion, fechaCreado, email, password);
    }

    public Estudiante(int id, int cedula, String nombre, String apellido, int telefono1,
            int telefono2, String direccion, String email, String nombreDeUsuario,
            boolean activado, int tipoDeUsuario, int seccion, String fechaCreado, boolean monitoreo, boolean investigacion) {

        super(id, cedula, nombre, apellido, telefono1, telefono2, direccion, email, nombreDeUsuario, activado, tipoDeUsuario, seccion, fechaCreado);
        this.esMonitoreo = monitoreo;
        this.esInvestigacion = investigacion;
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
