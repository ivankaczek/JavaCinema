/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

/**
 *
 * @author Ivan
 */
public class Spectator {
    private String spectatorFullName;
    private int spectatorAge;
    private double spectatorAvailMoney;

    public Spectator() {
    }

    public Spectator(String spectatorFullName, int spectatorAge, double spectatorAvailMoney) {
        this.spectatorFullName = spectatorFullName;
        this.spectatorAge = spectatorAge;
        this.spectatorAvailMoney = spectatorAvailMoney;
    }

    public String getSpectatorFullName() {
        return spectatorFullName;
    }

    public void setSpectatorFullName(String spectatorFullName) {
        this.spectatorFullName = spectatorFullName;
    }

    public int getSpectatorAge() {
        return spectatorAge;
    }

    public void setSpectatorAge(int spectatorAge) {
        this.spectatorAge = spectatorAge;
    }

    public double getSpectatorAvailMoney() {
        return spectatorAvailMoney;
    }

    public void setSpectatorAvailMoney(double spectatorAvailMoney) {
        this.spectatorAvailMoney = spectatorAvailMoney;
    }

    @Override
    public String toString() {
        return "Spectator{" + "spectatorFullName=" + spectatorFullName + ", spectatorAge=" + spectatorAge + ", spectatorAvailMoney=" + spectatorAvailMoney + '}';
    }
    
    
    
}
