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
public class CinemaSeat {
    private int seatIndexInArray;
    private boolean seatWithSomeone;
    private String seatSpectatorName;
        // we have a unique seatCode, then for printing we add or not additional info
    private String seatCode2;
    
    // CONSTRUCTORS ACCORDING TO WHAT I NEED
    
// First, an empty constructor which is needed to initialize an object (and it appears by default)
    public CinemaSeat() {
    }
    
    
   // Second, just the arrayIndex and the boolean which false by default (meaning that when instantiated, no one is in that seat)

    public CinemaSeat(int seatIndexInArray, boolean seatWithSomeone) {
        this.seatIndexInArray = seatIndexInArray;
        this.seatWithSomeone = seatWithSomeone; 
    }

   
    public CinemaSeat(int seatIndexInArray, boolean seatWithSomeone, String seatCode2) {
        /*
                I specifically need this constructor for the method:
                public CinemaAuditorium createAuditoriumFromListOfSeatCodes(String[] everySeatCode){ code here}
                This means, I can set everything but the name in the seat (I will know later)
        */
       
        this.seatIndexInArray = seatIndexInArray;
        this.seatWithSomeone = seatWithSomeone;
        this.seatCode2 = seatCode2;
    }
    
    
    
    
    
    
    
    // GETTERS AND SETTERS

    public int getSeatIndexInArray() {
        return seatIndexInArray;
    }

    public void setSeatIndexInArray(int seatIndexInArray) {
        this.seatIndexInArray = seatIndexInArray;
    }

    public boolean isSeatWithSomeone() {
        return seatWithSomeone;
    }

    public void setSeatWithSomeone(boolean seatWithSomeone) {
        this.seatWithSomeone = seatWithSomeone;
    }

    public String getSeatSpectatorName() {
        return seatSpectatorName;
    }

    public void setSeatSpectatorName(String seatSpectatorName) {
        this.seatSpectatorName = seatSpectatorName;
    }

    public String getSeatCode2() {
        return seatCode2;
    }

    public void setSeatCode2(String seatCode2) {
        this.seatCode2 = seatCode2;
    }

  
    
    // TO STRING METHOD

    @Override
    public String toString() {
        return "CinemaSeat{" + "seatIndexInArray=" + seatIndexInArray + ", seatWithSomeone=" + seatWithSomeone + ", seatSpectatorName=" + seatSpectatorName + ", seatCode2=" + seatCode2 + '}';
    }

   
    
    
    
    
}

// I guess that is important to separate what we print from the information that we need

/*
8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
6 A | 6 B X | 6 C | 6 D X | 6 E X | 6 F
5 A X | 5 B | 5 C X | 5 D X | 5 E X | 5 F X
4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
3 A | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F
1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X
*/