package Modelo;

/**
 * Es la clase que representa un usuario.
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Usuario {

    // id del usuario en la base de datos.
    private int id;
    // La cédula del usuario.
    private int cedula;
    // El teléfono1 del usuario.
    private int telefono1;
    // El teléfono2 del usuario.
    private int telefono2;
    // Representa el tipo de usuario.
    private int tipoDeUsuario;
    // Indica a que sección del observatorio pertenece.
    private int seccion;
    // El nombre.
    private String nombre;
    // El apellido.
    private String apellido;
    // La dirección del usuario. 
    private String direccion;
    // Es el nick name del usuario.
    private String nombreDeUsuario;
    // La contraseña.
    private String password;
    // email
    private String email;
    // Representa el estado del usuario en el observatorio.
    private boolean activado;
    // Fecha en la que se creo el usuario.
    private String fechaCreado;
    // Fecha de la última actualización del usuario.
    private String fechaActualizado;
    // Fecha de salida del usuario del observatorio.
    private String fechaSalida;

    /**
     * Constructor por defecto para crear un objeto Usuario.
     *
     * @param cedula La cédula.
     * @param nombre Nombre.
     * @param apellido Apellido.
     * @param telefono1 El teléfono1 del usuario.
     * @param tipoDeUsuario Representa el tipo de usuario.
     * @param seccion Indica a que sección del observatorio pertenece.
     * @param fechaCreado Fecha en la que se creo el usuario.
     * @param email e-mail del usuario.
     * @param password contraseña.
     */
    public Usuario(int cedula, String nombre, String apellido, int telefono1,
            int tipoDeUsuario, int seccion, String fechaCreado, String email, String password) {
        this.cedula = cedula;
        this.telefono1 = telefono1;
        this.tipoDeUsuario = tipoDeUsuario;
        this.seccion = seccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCreado = fechaCreado;
        this.fechaActualizado=this.fechaCreado;
        this.activado=true;
        this.email = email;
        this.password = password;
    }

    public Usuario(int id, int cedula, String nombre, String apellido, int telefono1, 
            int telefono2, String direccion, String email, String nombreDeUsuario, 
            boolean activado, int tipoDeUsuario, int seccion, String fechaCreado) {
        this.id = id;
        this.cedula = cedula;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.tipoDeUsuario = tipoDeUsuario;
        this.seccion = seccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.nombreDeUsuario = nombreDeUsuario;
        this.email = email;
        this.activado = activado;
        this.fechaCreado = fechaCreado;
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
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the telefono1
     */
    public int getTelefono1() {
        return telefono1;
    }

    /**
     * @param telefono1 the telefono1 to set
     */
    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * @return the telefono2
     */
    public int getTelefono2() {
        return telefono2;
    }

    /**
     * @param telefono2 the telefono2 to set
     */
    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * @return the tipoDeUsuario
     */
    public int getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    /**
     * @param tipoDeUsuario the tipoDeUsuario to set
     */
    public void setTipoDeUsuario(int tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    /**
     * @return the seccion
     */
    public int getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(int seccion) {
        this.seccion = seccion;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nombreDeUsuario
     */
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * @param nombreDeUsuario the nombreDeUsuario to set
     */
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the activado
     */
    public boolean isActivado() {
        return activado;
    }

    /**
     * @param activado the activado to set
     */
    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    /**
     * @return the fechaCreado
     */
    public String getFechaCreado() {
        return fechaCreado;
    }

    /**
     * @param fechaCreado the fechaCreado to set
     */
    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    /**
     * @return the fechaActualizado
     */
    public String getFechaActualizado() {
        return fechaActualizado;
    }

    /**
     * @param fechaActualizado the fechaActualizado to set
     */
    public void setFechaActualizado(String fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

    /**
     * @return the fechaSalida
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}
