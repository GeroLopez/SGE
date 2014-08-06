/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Genaro López
 * @version 6/08/2014
 */
public class Turno {

    private int id;
    private int idEstudiante;
    private int idTipoDeTurno;
    private Date fecha;
    private int duración;
    private String descripcion;
    private boolean estado;

    public Turno(int idEstudiante, int idTipoDeTurno, Date fecha) {
        this.idEstudiante = idEstudiante;
        this.idTipoDeTurno = idTipoDeTurno;
        this.fecha = fecha;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

}
