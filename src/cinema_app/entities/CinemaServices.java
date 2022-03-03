/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

import cinema_app.enums.FirstNameEnum;
import cinema_app.enums.LastNameEnum;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ivan
 */
public class CinemaServices {
    
    // This 2 attributes are used to create the array with the seats
    private String columnLetter[] = {"A","B","C","D","E","F"};
    private String rowNumber[] = {"1","2","3","4","5","6","7","8"};
   
    @SuppressWarnings("empty-statement")
    
    // PART ONE : create and display the arrays with seats
    
    public String[] createCorrectRowOfSeats(int numberOfRow){
        String[] correctRowOfSeats = new String[columnLetter.length];
        int i = 0;
        for (String charact : columnLetter) {
            correctRowOfSeats[i]=String.valueOf(numberOfRow).concat(charact).concat(" ");
            i++;
        }
        return correctRowOfSeats;
    }
    
    public CinemaAuditorium create8rows6columns(){
        //remember we have 8 rows and 6 columns
        // rows: 1,2, ... , 8
        // columns: A,B ... F
        String[][] temporary8x6Array = new String[8][6];
        // for each row (1,2, ... ,8) I need to create 6 seats (A to F)
        for (int i = 0; i < rowNumber.length; i++) {
            int auxNumberInRow = rowNumber.length - i;
            temporary8x6Array[i]= createCorrectRowOfSeats(auxNumberInRow);
        }
        //}
        CinemaAuditorium the48seats = new CinemaAuditorium();
       the48seats.setCinemaSeats(temporary8x6Array);
       return the48seats;
        
    }
    
   public void displayTheFull8x6CinemaRoom(CinemaAuditorium room){
       String auxRow2bePrinted = "";
       for (String[] cinemaSeat : room.getCinemaSeats()) {
           auxRow2bePrinted = displayRowOfSeats(cinemaSeat);
           System.out.println(auxRow2bePrinted);
       }
   }
   
    public String displayRowOfSeats(String[] rowOfSeats){
        String row2display = "| ";
        for (String seat : rowOfSeats) {
            row2display = row2display.concat(seat).concat(" | ");
        }
        return row2display;
    }
    
// PART TWO : We deal with the simulation of creating customers   
    
 /**
 *  Here we create an ArrayList with 30 random full names (first name + " " + lastName)
 *  that we need in order to simulate the creation of spectators
 * @author Ivan
 */
    
    // We create an ArrayList of Spectators which will be stored in the CinemaCustomers class as an attibute
    public CinemaCustomers create30randomSpectators(){
        // remember that the only attribute for CinemaCustomers is an ArrayList of Spectators
        // that means that you could create the list, and then use it as a parameter and thus, avoid using the empty constructor
        ArrayList<Spectator> temporaryCollectionSpectators = new ArrayList<>();
        ArrayList<String> names4spectators = create30randomFullNames();
        for (int i = 0; i < names4spectators.size(); i++) {
            String name2useInConstructor = names4spectators.get(i);
            Spectator auxSpectator2add = new Spectator(name2useInConstructor, returnRandomAge(), returnRandomMoney());
            temporaryCollectionSpectators.add(auxSpectator2add);
        }
        CinemaCustomers collectionOfSpectators = new CinemaCustomers(temporaryCollectionSpectators);
        return collectionOfSpectators;
    }
    
    
    public ArrayList<String> create30randomFullNames(){
        ArrayList<String> thirtyRandomNames = new ArrayList();
        for (FirstNameEnum firstName : FirstNameEnum.values()) {
            for (LastNameEnum lastName : LastNameEnum.values()) {
                String fullName2Add = firstName.toString().concat(" ").concat(lastName.toString());
                thirtyRandomNames.add(fullName2Add);
            }
        }
        
        return thirtyRandomNames;
    }
    
    public void display30randomFullNames(){
        ArrayList<String> thirtyRandomNames = create30randomFullNames();
        for (String eachRandomName : thirtyRandomNames) {
            System.out.println(eachRandomName);
        }
    }
    
    public ArrayList<Integer> create30randomAges(){
        ArrayList<Integer> list30ages = new ArrayList();
                    /************************************************
                     * "Java Generate Random Number Between Two Given Values [duplicate]"
                     * The following was extracted from stack overflow
                     * @author StackOverflow
                     */
        Random r = new Random();
        int low = 5;
        int high = 97;            
        for (int i = 0; i < 30; i++) {
             int result = r.nextInt(high-low) + low;
             list30ages.add(result);    
        } 
        return list30ages;
    }
    
    public void display30randomAges(){
       ArrayList<Integer> thirtyAges = create30randomAges();
        System.out.println("");
        for (Integer anIntegerofAge : thirtyAges) {
            System.out.print(anIntegerofAge);
            System.out.print(" ");
        }  
    }
    
    public int returnRandomAge(){
        Random r = new Random();
        int low = 5;
        int high = 97;            
        int result = r.nextInt(high-low) + low;
        return result;
    }
    
    public double returnRandomMoney(){
        // between USD 10 and USD 50
        Random r = new Random();
        int low = 10;
        int high = 50;            
        int result = r.nextInt(high-low) + low;
        double resultAsDouble = (double) result;
        return resultAsDouble;
    }
    
     public ArrayList<Integer> create30randomAvailableMoney(){
        ArrayList<Integer> list30amountOfDollars = new ArrayList();
                    /************************************************
                     * "Java Generate Random Number Between Two Given Values [duplicate]"
                     * The following was extracted from stack overflow
                     * @author StackOverflow
                     */
        Random r = new Random();
        int low = 10;
        int high = 50;            
        for (int i = 0; i < 30; i++) {
             int result = r.nextInt(high-low) + low;
             //System.out.println(result);
             list30amountOfDollars.add(result);    
        }
         
        return list30amountOfDollars;
    }
    
    
    
    
}
