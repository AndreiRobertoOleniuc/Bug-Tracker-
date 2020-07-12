/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.UI;

import java.sql.Date;

/**
 *
 * @author Andrei Oleniuc
 */
public class Bugs {
    String name;
    String status;
    Date datum;
    String programmingLanguage;
    String assignment;

    public Bugs(String name, String status, Date datum, String programmingLanguage, String assignment) {
        this.name = name;
        this.status = status;
        this.datum = datum;
        this.programmingLanguage = programmingLanguage;
        this.assignment = assignment;
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

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
    
}
