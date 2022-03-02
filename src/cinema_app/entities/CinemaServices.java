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
public class CinemaServices {
    private String columnLetter[] = {"A","B","C","D","E","F"};
    private String rowNumber[] = {"1","2","3","4","5","6","7","8"};
   
    @SuppressWarnings("empty-statement")
    public CinemaAuditorium create48seatsInExplicitWay(){
        // The empty constructor (SHOULD/IS SUPOSED TO) provid an empty 8X6 String Array
        //CinemaAuditorium cinemaSeats = new CinemaAuditorium();
       // Now I need to create 8 rows of seats, each time with a different letter
       // We create row #1. Maybe it is better to construct a [8][6] Array and then just use the constructor
       // to "build" the cinemaSeats
       
       // ATTENTION HERE! in Array[amountOfRows][amountOfColumns]
       String[][] temporary8x6Array = new String[6][8];
       String[] row1 = createRowOfSeats(columnLetter[0], 8);
       String[] row2 = createRowOfSeats(columnLetter[1], 8);
       String[] row3 = createRowOfSeats(columnLetter[2], 8);
       String[] row4 = createRowOfSeats(columnLetter[3], 8);
       String[] row5 = createRowOfSeats(columnLetter[4], 8);
       String[] row6 = createRowOfSeats(columnLetter[5], 8);
       
       // ATTENTION: there is a mistake here: the array is 6x8
       //temporary8x6Array = {row1;row2;row3,row4,row5,row6};
       temporary8x6Array[0]=row1;
       temporary8x6Array[1]=row2;
       temporary8x6Array[2]=row3;
       temporary8x6Array[3]=row4;
       temporary8x6Array[4]=row5;
       temporary8x6Array[5]=row6;
       
       CinemaAuditorium the48seats = new CinemaAuditorium();
       the48seats.setCinemaSeats(temporary8x6Array);
       return the48seats;
    }
    
//    public int findPositionOfCharacter(String[] letterArray){
//           
//    }
    
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
    
    // this works when all the letters are in the same row. It is the opposite to this case
   public String[] createRowOfSeats(String columnLetter, int amountOfSeats){
       String[] rowOfSeats = new String[amountOfSeats];
       for (int i = 0; i < amountOfSeats; i++) {
           rowOfSeats[i] = columnLetter.concat(String.valueOf(i+1)).concat(" ");
       }
       return rowOfSeats;
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
    
    public String displayWithForE(String[] rowOfSeats){
        String aux = "";
        for (String rowOfSeat : rowOfSeats) {
            aux = aux.concat(rowOfSeat);
        }
        return aux;
    }
    
    
}
