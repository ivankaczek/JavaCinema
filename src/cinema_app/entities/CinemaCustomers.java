/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

import java.util.ArrayList;

/**
 *  We find here a collection of the clients who are registered in the cinema
 * @author Ivan
 */
public class CinemaCustomers {
    private ArrayList<Spectator> listOfSpectators;

    public CinemaCustomers() {
    }

    public CinemaCustomers(ArrayList<Spectator> listOfSpectators) {
        this.listOfSpectators = listOfSpectators;
    }

    public ArrayList<Spectator> getListOfSpectators() {
        return listOfSpectators;
    }

    public void setListOfSpectators(ArrayList<Spectator> listOfSpectators) {
        this.listOfSpectators = listOfSpectators;
    }
    
    
    
}
