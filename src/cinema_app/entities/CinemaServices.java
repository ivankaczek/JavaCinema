/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

import cinema_app.enums.FirstNameEnum;
import cinema_app.enums.LastNameEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ivan
 */
public class CinemaServices {
    
    // This 2 attributes are used to create(we no longer use to create, but mayble display) the array with the seats
    private String[] columnLetter = {"A","B","C","D","E","F"};
    private int amountOfRows = 8;
    private int numberOfSeats4auditorium = amountOfRows*columnLetter.length;
    private String[] all48seatCodes = new String[numberOfSeats4auditorium];

    public String[] getAll48seatCodes() {
        return all48seatCodes;
    }

    // Attention: I modify this with the previously coded algorith
    public void setAll48seatCodes() {
        this.all48seatCodes = createAllTheSeatCodes();
    }
   
    
    
    
    
    @SuppressWarnings("empty-statement")
    
    // PART 1 : creating the seats in the CinemaAuditorium
    
    public CinemaAuditorium create48emptySeats(){
        //  I feel curious to know if this method is or not efficient
        CinemaAuditorium the48seats = new CinemaAuditorium();
        for (int i = 0; i < numberOfSeats4auditorium; i++) {
            CinemaSeat auxSeat2add = new CinemaSeat(i, false);
            the48seats.getSeatsInCinema().add(auxSeat2add);
        }
        return the48seats;
    }
    
    // PART 1.1     CREATE the codes that we will eventually apply to the seats 
    //              Attention: for better display, the 48 seatCodes should be: 8A, 8B, 8C, ... 8F, 7A, 7B, 7C, ... , 7F, 6A, ... , 1F
    //              This is easiar if we split in 8 rows, so the #n row would be: nA, nB, nC, ... , nF.
    
    public String[] createArrayWithCode4oneRowOfSeats(int rowNumberInCode){
        String[] aRowOfSeats = new String[columnLetter.length];
        for (int i = 0; i < aRowOfSeats.length; i++) {
            String number4Code = Integer.toString(rowNumberInCode);
            String letter4Code = columnLetter[i];
            String auxSeatCode = number4Code.concat(letter4Code);
            aRowOfSeats[i] = auxSeatCode;
        } 
        return aRowOfSeats;
    }
    
    public String[] createAllTheSeatCodes(){
       String[] allCodes = new String[numberOfSeats4auditorium]; 
        for (int i = 0; i < amountOfRows; i++) {
            int codeOfTheRow2beCreated = amountOfRows - i;
            String[] auxStringWith6codes = createArrayWithCode4oneRowOfSeats(codeOfTheRow2beCreated);
            for (int j = 0; j < columnLetter.length; j++) {
                int index2set = i*columnLetter.length + j;
                allCodes[index2set] = auxStringWith6codes[j];
            }
        }
       return allCodes;
    }
    
    public CinemaAuditorium createAuditoriumFromListOfSeatCodes(String[] everySeatCode){
        // I already have an array with the codes in the correct order
        // I need to create a collection of objects CinemaSeats, which is the attribute for CinemaAuditorium
        ArrayList<CinemaSeat> aCollectionOfSeats = new ArrayList<>();
        int seatIndexCounter = 0;
        for (String eachSeatCode : everySeatCode) {
            CinemaSeat auxSeat2add = new CinemaSeat(seatIndexCounter, false, eachSeatCode);
            aCollectionOfSeats.add(auxSeat2add);
            seatIndexCounter++;
        }
        return new CinemaAuditorium(aCollectionOfSeats);
    }
    
    
   // PART 1.2: DISPLAYING SEATS, VISUAL ASPECTS
    
    // once I undestood the logic it is easy to do a better code
    public void display48seatsHomoSapiensMethod(ArrayList<String> the48codes){
        int amountOfColumns = columnLetter.length;
        for (int i = 0; i < amountOfRows; i++) {
            List<String> theRow2trim = separateJustOneRowOfSeats(the48codes, amountOfColumns*i, (amountOfColumns*i)+amountOfColumns);
            String aux2print = concatJustOneRowOfSeats(theRow2trim);
            System.out.println(aux2print);
        }
        System.out.println("");
    }
    
    public void display48seatsCavemanMethod(ArrayList<String> the48codes){
        // I need to display the results as a matrix
        // I also need to concatenate an "X" if occupied or " " if empty    (done)
        // I might also display a bar " | " to better show the results
        List<String> listRow8 = separateJustOneRowOfSeats(the48codes, 0, 6);
        List<String> listRow7 = separateJustOneRowOfSeats(the48codes, 6, 12);
        List<String> listRow6 = separateJustOneRowOfSeats(the48codes, 12, 18);
        List<String> listRow5 = separateJustOneRowOfSeats(the48codes, 18, 24);
        List<String> listRow4 = separateJustOneRowOfSeats(the48codes, 24, 30);
        List<String> listRow3 = separateJustOneRowOfSeats(the48codes, 30, 36);
        List<String> listRow2 = separateJustOneRowOfSeats(the48codes, 36, 42);
        List<String> listRow1 = separateJustOneRowOfSeats(the48codes, 42, 48);
        String s8 = concatJustOneRowOfSeats(listRow8);
        String s7 = concatJustOneRowOfSeats(listRow7);
        String s6 = concatJustOneRowOfSeats(listRow6);
        String s5 = concatJustOneRowOfSeats(listRow5);
        String s4 = concatJustOneRowOfSeats(listRow4);
        String s3 = concatJustOneRowOfSeats(listRow3);
        String s2 = concatJustOneRowOfSeats(listRow2);
        String s1 = concatJustOneRowOfSeats(listRow1);
        System.out.println(s8);
        System.out.println(s7);
        System.out.println(s6);
        System.out.println(s5);
        System.out.println(s4);
        System.out.println(s3);
        System.out.println(s2);
        System.out.println(s1);
    }
    
    public String concatJustOneRowOfSeats(List<String> theTrimmedList){
        String text4display = "| ";
        for (String code : theTrimmedList) {
            text4display = text4display.concat(code).concat(" | ");
        }
        return text4display;
    }
    
    // We get a trimmed list with only the 6 seats in one row
    public List<String> separateJustOneRowOfSeats(ArrayList<String> the48codes, int startHereInclusive, int endHereExclusive){
        List<String> josephMushroomDa1st = (List) the48codes;
        return josephMushroomDa1st.subList(startHereInclusive, endHereExclusive);
    }
    
    // We add "X" or " " just to display/print. The attribute seatCode remains the same.
  public ArrayList<String> listSeatCodes4display(CinemaAuditorium aSeatsCollection){
      // this should include the "X" or " " according to the seat being or not occupied with someone
      ArrayList<String> theNewList = new ArrayList();
        for (CinemaSeat cinemaSeat : aSeatsCollection.getSeatsInCinema()) {
             String auxCompletedCode = cinemaSeat.getSeatCode2();
             if (cinemaSeat.isSeatWithSomeone()){
                auxCompletedCode = auxCompletedCode.concat("X");
            } else {
                auxCompletedCode = auxCompletedCode.concat(" ");
            }
             theNewList.add(auxCompletedCode);
        }
      return theNewList;
  }
    
  // More general: just to check if sth works
  public void displayStringArrayList(ArrayList<String> stringArrayList){
      System.out.println("");
      System.out.println("Here we show all the codes + info if seat is occupied or not");
      for (String string : stringArrayList) {
          System.out.print(string + " | ");
      }
      System.out.println(""); // If I miss this line next prints will be displayed in the same line as this.
  }
  
  
// PART THREE : We deal with the simulation of creating customers   
    
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

/*
// THE FIRST IDEA WAS THIS. I was working with an Array of Arrays which proved very difficult to work with
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
*/