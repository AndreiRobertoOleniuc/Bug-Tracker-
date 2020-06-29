/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Database;

/**
 *
 * @author Andrei Oleniuc
 */
public class Administration {
    private int idAdministration;
    private int idUser;
    private int idBug;

    public Administration(int idAdministration, int idUser, int idBug) {
        this.idAdministration = idAdministration;
        this.idUser = idUser;
        this.idBug = idBug;
    }

    public int getIdAdministration() {
        return idAdministration;
    }

    public void setIdAdministration(int idAdministration) {
        this.idAdministration = idAdministration;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBug() {
        return idBug;
    }

    public void setIdBug(int idBug) {
        this.idBug = idBug;
    }
    
}
