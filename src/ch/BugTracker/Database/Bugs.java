/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Database;

import java.sql.Date;

/**
 *
 * @author Andrei Oleniuc
 */
public class Bugs {
    private int idBug;
    private String name;
    private String status;
    private Date datum;
    private String programmingL;

    public Bugs(int idBug, String name, String status, Date datum, String programmingL) {
        this.idBug = idBug;
        this.name = name;
        this.status = status;
        this.datum = datum;
        this.programmingL = programmingL;
    }

    public int getIdBug() {
        return idBug;
    }

    public void setIdBug(int idBug) {
        this.idBug = idBug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getProgrammingL() {
        return programmingL;
    }

    public void setProgrammingL(String programmingL) {
        this.programmingL = programmingL;
    }
    
}
