/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

import cinema_app.enums.CinemaTicketPriceEnum;
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
    
    // PART 1: CREATING SEATS AND RELATED CODES
    
        // PART 1.0 :   Create empty seats in the CinemaAuditorium
    
    public CinemaAuditorium create48emptySeats(){
        //  I feel curious to know if this method is or not efficient
        CinemaAuditorium the48seats = new CinemaAuditorium();
        for (int i = 0; i < numberOfSeats4auditorium; i++) {
            CinemaSeat auxSeat2add = new CinemaSeat(i, false);
            the48seats.getSeatsInCinema().add(auxSeat2add);
        }
        return the48seats;
    }
    
        // PART 1.1     CREATE the SeatCodes that we will eventually apply to the seats 
        
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
    
        // PART 1.2     Create a collection of seats (aka a CinemaAuditorium object)starting with the code of each seat
    
    public CinemaAuditorium createAuditoriumFromListOfSeatCodes(String[] everySeatCode){
        // I already have an array with the codes in the correct order
        // I need to create a collection of objects CinemaSeats, which is the attribute for CinemaAuditorium
        ArrayList<CinemaSeat> aCollectionOfSeats = new ArrayList<>();
        int seatIndexCounter = 0;
        for (String eachSeatCode : everySeatCode) {
            /*
                int seatIndexInArray; ----------------> we set with the counter (from 0 to amount in the list with codes)
                boolean seatWithSomeone; -------------> false
                String seatSpectatorName; ------------> null
                String seatCode2; --------------------> taken from the list (in the parameter of the method)
            */
            CinemaSeat auxSeat2add = new CinemaSeat(seatIndexCounter, false, eachSeatCode);
            aCollectionOfSeats.add(auxSeat2add);
            seatIndexCounter++;
        }
        CinemaAuditorium room2return = new CinemaAuditorium(aCollectionOfSeats);
        setAmountOccupied2zero(room2return);
        return room2return;
    }
    
    public CinemaAuditorium createFullEmptyAuditorium(){
        return createAuditoriumFromListOfSeatCodes(createAllTheSeatCodes());
    }
    
    
   // PART 2: DISPLAYING SEATS, VISUAL ASPECTS
    
        // PART 2.1:   Displaying seats in the console
    public void displayAuditoriumInConsole(CinemaAuditorium aCinemaRoom){
        ArrayList<String> the48codesIneed = listSeatCodes4display(aCinemaRoom);
        
        display48seatsHomoSapiensMethod(the48codesIneed);
    }
    
    
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
    
       
    public List<String> separateJustOneRowOfSeats(ArrayList<String> the48codes, int startHereInclusive, int endHereExclusive){
         // We get a trimmed list with only the 6 seats in one row
        List<String> josephMushroomDa1st = (List) the48codes;
        return josephMushroomDa1st.subList(startHereInclusive, endHereExclusive);
    }
    
        
  public ArrayList<String> listSeatCodes4display(CinemaAuditorium aSeatsCollection){
      // We add "X" or " " just to display/print. The attribute seatCode remains the same.
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
  
        // PART 2.2: Displaying info about management of the movies
  
  public void displayInfoAboutNextMovieManagement(CinemaManager nextMovie){
      System.out.println("");
      System.out.println("MOVIE JUST CREATED. IMPORTANT INFO:");
      System.out.println("------------------------------------------");
      System.out.println("Current movie on billboard: " + nextMovie.getFilmPlayingNow().getFilmTitle() + 
              " by " + nextMovie.getFilmPlayingNow().getFilmDirector());
      System.out.println("Price for the ticket: USD " + nextMovie.getFilmTicketPrice() );
      System.out.println("Auditorium for this film has already sold: NO TICKETS SOLD JET.");
      System.out.println("------------------------------------------");
      System.out.println("");
  }
  
 public void displayInfoAboutNextMovieManagementAfterSellingTickets(CinemaManager nextMovie){
      System.out.println("");
      System.out.println("IMPORTANT INFO ABOUT THIS MOVIE MANAGEMENT");
      System.out.println("------------------------------------------");
      System.out.println("Current movie on billboard: " + nextMovie.getFilmPlayingNow().getFilmTitle() + 
              " by " + nextMovie.getFilmPlayingNow().getFilmDirector());
      System.out.println("Price for the ticket: USD " + nextMovie.getFilmTicketPrice() );
      System.out.println("Auditorium for this film has already sold: " + displayStringInfoPeopleWithTicket(nextMovie) + ".");
      System.out.println("------------------------------------------");
      System.out.println("");
  }
  
  public String displayStringInfoPeopleWithTicket(CinemaManager nextSaturdayFilm){
        int amountSoldTickets = nextSaturdayFilm.getSpectatorsWithTicket().size();
        String string2return = Integer.toString(amountSoldTickets) + " tickets sold";
        return string2return;
  }     
  
// PART 3: DEALING WITH CUSTOMERS  

// PART 3.1 : Creating customers  
    
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
    
     // PART 3.2 Simulating the asignment of customers to seats
     
     /*
        I understand that the assignation of a seat involves  
                                a) checking age, 
                                b) checking money, 
                                c) checking available seat
     */
     
     // AGE ISSUES **********************************
       public boolean checkOldEnough(int spectatorAge, int minAge4film){
         boolean allesGut = false;
         if(spectatorAge >= minAge4film){
             allesGut = true;
         }
         return allesGut;
     }
     
       public CinemaCustomers filterCustomersAgeMoney(CinemaCustomers custormersBeforeFilter, int minAge, double ticketPrice){
           ArrayList<Spectator> listBeforeFilter = custormersBeforeFilter.getListOfSpectators();
           ArrayList<Spectator> listFilteredByAge = filterSpectatorsAge(listBeforeFilter, minAge);
           ArrayList<Spectator> listFilteredByAgeAndMoney = filterSpectatorsMoney(listFilteredByAge, ticketPrice);
          return new CinemaCustomers(listFilteredByAgeAndMoney);
        }
       
        // Here a FILTER completeListSpectators >>> filteredListOfSpectators
     public ArrayList<Spectator> filterSpectatorsAge (ArrayList<Spectator> fullListSpectators, int minAge) {
         ArrayList<Spectator> filteredListSpectators = new ArrayList();
         int spectatorsNotOldEnough = 0;
         for (Spectator spectator2check : fullListSpectators) {
             boolean oldEnough = checkOldEnough(spectator2check.getSpectatorAge(), minAge);
             if (oldEnough){
                 filteredListSpectators.add(spectator2check);
             } else spectatorsNotOldEnough++;
         }
         //System.out.println(Integer.toBinaryString(spectatorsNotOldEnough) + " spectators where not old enough");
         return filteredListSpectators;
     }
       
       
    // MONEY ISSUES ***********************************   
     public ArrayList<Spectator> filterSpectatorsMoney (ArrayList<Spectator> fullListSpectators, double ticketPrice) {
         ArrayList<Spectator> filteredListSpectators = new ArrayList();
         for (Spectator spectator2check : fullListSpectators) {
             boolean spectHasMoney = checkEnoughMoney(spectator2check.getSpectatorAvailMoney(), ticketPrice);
             if (spectHasMoney){
                 filteredListSpectators.add(spectator2check);
             }
         }
         
         return filteredListSpectators;
     }
     
     
     
     
     
     
     public boolean checkEnoughMoney(double moneySpectatorHas, double moneyTheMovieCosts){
         boolean allesGut = false;
         if(moneySpectatorHas >= moneyTheMovieCosts){
             allesGut = true;
         }     
         return allesGut;
     }
     
   
     
     
     public boolean checkIfSeatIsEmpty(CinemaSeat seat){
         // Even if it's obvious... this returns TRUE if the seat is empty
         boolean nodobyThere = false; //(let's assume it's occupied)
         if(!seat.isSeatWithSomeone()){
             nodobyThere = true;
         }
         return nodobyThere;
     }
     
     public void setAmountOccupied2zero(CinemaAuditorium aCinemaRoom){
         aCinemaRoom.setAmountOccupiedSeats(0);
     }
     
    
     
      
     
     // Here my only concern is placing a persona which already has a ticket. 
     // If he/she has a ticket I don't need to check if there's still place available
     // That issue should be dealt somewhere else
     public CinemaAuditorium placeOneSpectatorRandomSeatHomoSapiensMethod(CinemaAuditorium allSeatsbefore, Spectator spectatorWithTicket){
         CinemaAuditorium roomAfterPlacement = allSeatsbefore;
         
         int randomSeatIndex = returnRandomIndexMax47();
         String spectName = spectatorWithTicket.getSpectatorFullName();
         CinemaSeat chosenSeat = allSeatsbefore.getSeatsInCinema().get(randomSeatIndex);
         String chosenSeatCode = chosenSeat.getSeatCode2();
         System.out.println("Let's check if " + chosenSeatCode + " is available");
         boolean iCanKeepGoing = checkIfSeatIsEmpty(chosenSeat);
         if(iCanKeepGoing){
             System.out.println("Dear " + spectName + "your seat is " + chosenSeatCode + " \n Enjoy the movie!");
         } else System.out.println("We're sorry, the randomly selected seat is occupied. Let's try again.  ");
         
        
         return roomAfterPlacement;
     }
     

     
     // WARNING : SOME PROBLEM HERE SINCE AF
     public CinemaAuditorium placeOneSpectatorRandomlyTry3times(CinemaAuditorium allSeatsbefore, Spectator spectatorWithTicket){
         // I start with 48 seats, some of them are empty, some are occupied
        CinemaAuditorium roomAfterPlacement = allSeatsbefore;   // This will be the return statement. 
         // Now I should try to find an empty seat, but only 3 times. 
        int counter = 1;
        boolean keepGoing = true;                           // Keep looking for an empty seat  
        boolean iDidntFoundAnEmptySeat = true;              // If I couldn't find, I keep going (the idea es to have allways true)
        CinemaSeat seat2replace = new CinemaSeat();         // If I don't instantiate the thing I can't keep going
        do {
            System.out.print("Test time #" + counter + "/3. ");
            CinemaSeat seat2test = findRandomSeat(allSeatsbefore);
            System.out.println("We test seat " + seat2test.getSeatCode2() + " to check if it is empty");
            boolean seatIsEmpty = checkIfSeatIsEmpty(seat2test);
            System.out.println("It is " + seatIsEmpty + " that I found an empty seat RANDOMLY");
            System.out.println("");
         
             // If I found an empty seat, I have to place the Spectator there (and that I should code separately)    
                        
            if (seatIsEmpty){
                /* Remember:
                    placeSpectatorInSeat(CinemaSeat emptySeat, Spectator spectatorWithTicket){}
                    returns the seat now occupied by this spectator
                */
                seat2replace = placeSpectatorInSeat(seat2test, spectatorWithTicket);
                int indexSeat2replace = seat2replace.getSeatIndexInArray();
                roomAfterPlacement.getSeatsInCinema().set(indexSeat2replace, seat2test);
                keepGoing = false;
            } else {
                if (counter >= 3){
                    keepGoing = false;
                    System.out.println("We tried 3 times to find a seat Randomly, so now we find a seat Manually");
                    //displayNextEmptySeat(allSeatsbefore);
                    CinemaSeat emptySeatChosenManually = findAnEmptySeat(allSeatsbefore);
                    System.out.println("We found that seat " + emptySeatChosenManually.getSeatCode2() + " is empty.");
                
                    seat2replace = placeSpectatorInSeat(emptySeatChosenManually, spectatorWithTicket);
                    // seat2replce is the OCCUPIED SEAT WITH THE CUSTOMER INFO
                    int indexSeat2replace = seat2replace.getSeatIndexInArray();
                    roomAfterPlacement.getSeatsInCinema().set(indexSeat2replace, seat2replace);
                    
                } 
                counter++;
            }
            
            
        } while (keepGoing);
        
        
        return roomAfterPlacement;
     }
     
     public CinemaAuditorium place4SpectatorsInListCavemanMethod(CinemaAuditorium roomB4, CinemaCustomers listSpectators2place){
         /*
         the method I already have needs    a) the collection of seats
                                            b) a spectator
         */
         
        // PLACEMENT OF SPECTATOR #01 
        // I get 1st spectator
        Spectator spectator01 = listSpectators2place.getListOfSpectators().get(0);
        // the room before i have it in the parameter
        CinemaAuditorium roomB4spectator01 = roomB4;
        
        CinemaAuditorium roomAfterSpectator01 = placeOneSpectatorRandomlyTry3times(roomB4, spectator01);
        
        // PLACEMENT OF SPECTATOR #02 
        // I get 2nd spectator
        Spectator spectator02 = listSpectators2place.getListOfSpectators().get(1);
        // the room before i have it in the parameter
        CinemaAuditorium roomB4spectator02 = roomAfterSpectator01;
        
        CinemaAuditorium roomAfterSpectator02 = placeOneSpectatorRandomlyTry3times(roomB4spectator02, spectator02);
        
        // PLACEMENT OF SPECTATOR #03 
        // I get 3rd spectator
        Spectator spectator03 = listSpectators2place.getListOfSpectators().get(2);
        // the room before i have it in the parameter
        CinemaAuditorium roomB4spectator03 = roomAfterSpectator02;
        
        CinemaAuditorium roomAfterSpectator03 = placeOneSpectatorRandomlyTry3times(roomB4spectator03, spectator03);
        
        // PLACEMENT OF SPECTATOR #04
        // I get 4th spectator, (the one with index 3)
        Spectator spectator04 = listSpectators2place.getListOfSpectators().get(3);
        // the room before i have it in the parameter
        CinemaAuditorium roomB4spectator04 = roomAfterSpectator03;
        
        CinemaAuditorium roomAfterSpectator04 = placeOneSpectatorRandomlyTry3times(roomB4spectator04, spectator04);
        
        /*
        ....
        */
       
        return roomAfterSpectator04;
     }
     
//     public CinemaAuditorium placeOneSpectatorInNextEmptySeat(CinemaAuditorium allSeatsbefore, Spectator spectatorWithTicket){
//         CinemaAuditorium roomAfterPlacement = allSeatsbefore;
//         CinemaSeat firstSeatThatIsEmpty = findAnEmptySeat(roomB4);
//         return roomAfterPlacement;
//     }
                
    public void displayNextEmptySeat(CinemaAuditorium roomB4){
        CinemaSeat seat2display = findAnEmptySeat(roomB4);
        System.out.println("I found that seat " + seat2display.getSeatCode2() + " is empty");
    }
     
    public CinemaSeat findAnEmptySeat(CinemaAuditorium roomB4){
        CinemaSeat seat2return = new CinemaSeat();
        int indexOfSeat2return = 0;
        boolean iFoundEmptySeat = false;
        int counter = 0;
        do {
            // analize seat corresponding to counter
            CinemaSeat seat2analize = roomB4.getSeatsInCinema().get(counter);
            iFoundEmptySeat = checkIfSeatIsEmpty(seat2analize);
            counter++;
            if(iFoundEmptySeat){
                seat2return = seat2analize;
            }
        } while (!iFoundEmptySeat || (counter > roomB4.getSeatsInCinema().size()));
        
        return seat2return;
    }            
                
     public CinemaAuditorium returnRoomB4_n_Spectator(CinemaAuditorium cinemaRoom, int indexOfspectator){
         CinemaAuditorium returnThisCinemaRoom = cinemaRoom;
         if (indexOfspectator==0){
             returnThisCinemaRoom = cinemaRoom;
         }
         
         return returnThisCinemaRoom;
     }
     

     
     public CinemaSeat placeSpectatorInSeat(CinemaSeat emptySeat, Spectator spectatorWithCorrectMoneyAge){
         // Using empty seat and Spectator as parameter, it returns the occupied seat with attached info
         // It would be better to validate (seat is really empty)
         /*     ORIGINAL SEAT > > > > > > > > > > > > > > > > > > > WE RETURN THIS SEAT 
            int seatIndexInArray;     yes                           int seatIndexInArray;       the same
            boolean seatWithSomeone;  false (at instantiation)      boolean seatWithSomeone;    TRUE
            String seatSpectatorName; null                          String seatSpectatorName;   Name from Spectator parameter
            String seatCode2;         yes                           String seatCode2;           the same
            
         */  
         CinemaSeat seatWithSomeone = emptySeat;
         seatWithSomeone.setSeatWithSomeone(true);
         String spectName = spectatorWithCorrectMoneyAge.getSpectatorFullName();
         seatWithSomeone.setSeatSpectatorName(spectName);
         displaySeatInfo(seatWithSomeone); // Can't we put this somewheare else??? :/
         return seatWithSomeone;
     }
     
     public void displaySeatInfo(CinemaSeat seat){
         //System.out.println("");
         System.out.print("Seat #" + seat.getSeatCode2());
         System.out.println(" Only valid for " + seat.getSeatSpectatorName());
         System.out.println("");
     }
     
     public CinemaSeat findRandomSeat(CinemaAuditorium theFullRoom){
         int randomIndexSeat = returnRandomIndexMax47();
         CinemaSeat chosenSeat = theFullRoom.getSeatsInCinema().get(randomIndexSeat);
         return chosenSeat;
     }
     
     
     // We assign one customer to one seat RANDOMLY
     // WARNING: this method might consume an EXCESS OF MEMORY
     public CinemaAuditorium randomOneSpectatorPlacementCavemanMethod(CinemaAuditorium allSeatsbefore, Spectator spect){
        CinemaAuditorium allseatsafter = allSeatsbefore;
         
        int occupiedSeats = allSeatsbefore.getAmountOccupiedSeats();
        int totalAmountSeats = allSeatsbefore.getSeatsInCinema().size();
        String spectName = spect.getSpectatorFullName();
        
        if (totalAmountSeats > occupiedSeats){
            // 1) look for an empty RANDOM seat since I do NOT want to seat everybody TOGETHER
                // 1.1a) I choose a random index between 0 and 47
                int randomSeatIndex = returnRandomIndexMax47();
                CinemaSeat chosenSeat = allSeatsbefore.getSeatsInCinema().get(randomSeatIndex);
                String chosenSeatCode = chosenSeat.getSeatCode2();
                // 1.1b) Explain that you will check if the randomly selected seat is available
                System.out.println("Let's check if " + chosenSeatCode + " is available");
                
                // 1.2) I check if that seat is empty/not empty, so I need CinemaSeat with corresponding index
                
                
                boolean iCanKeepGoing = checkIfSeatIsEmpty(chosenSeat);
                
                if(iCanKeepGoing){  
                    System.out.println("Nice  " + spectName + ", you've got an empty seat, and IT IS FOR YOU!!!");
                    String seatCode = chosenSeat.getSeatCode2();
                    // I change the seat boolean to occupied
                    chosenSeat.setSeatWithSomeone(true);
                    chosenSeat.setSeatSpectatorName(spectName);
                    // now I need to change the disposition of the seats,
                    allseatsafter.getSeatsInCinema().set(randomSeatIndex, chosenSeat);
                    
                    System.out.println("Please accomodate your buttocks over seat " + seatCode);
                } else
                    System.out.println("Sorry, seat "  + chosenSeatCode + " is not empty, \n let's check for another seat ");
        
        
        } else System.out.println("We cannot place another person, since the room is full");
        
       
         System.out.println("");
        return allseatsafter;
     }
     
     public int returnRandomIndexMax47(){
        Random r = new Random();
        int low = 0;
        int high = 47;            
        int result = r.nextInt(high-low) + low;
        return result;
    }
     
     // PART 4: DEALING WITH FILMS
     
     // PART 4.1 Creating a movie
     
     public Film hardcodeOneFilm(){
         // 1h52m = 60 + 52 = 112
         Film movie = new Film("Tacones Lejanos", "Pedro Almodovar", 112, 18);
         
         return movie;
     }
    
     
     // PART 5: CINEMA MANAGEMENT
     
     public CinemaManager generateSpecificCinemaEventExemple(CinemaAuditorium availableCinemaRoom){
         
         
         return new CinemaManager(hardcodeOneFilm(), availableCinemaRoom, CinemaTicketPriceEnum.WEEKEND_DISCOUNT.getTicketPriceUSD());
     }
    
}

/*
Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y
se los ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde
ya este ocupado el asiento).

Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que
sólo se podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada,
si hay espacio libre en la sala y si tiene la edad requerida para ver la película. En caso de
que el asiento este ocupado se le debe buscar uno libre.

Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y
numero de cada asiento o solo las X y espacios vacíos.
*/




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