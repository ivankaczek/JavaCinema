/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.placement_services;

import cinema_app.entities.CinemaAuditorium;
import cinema_app.entities.CinemaManager;
import cinema_app.entities.CinemaServices;
import cinema_app.entities.Spectator;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class CinemaPlacementServices {
    
    CinemaServices serv = new CinemaServices();
    
    public Spectator getSpectatorIndex_n(CinemaManager cinemaEvent, int n){
        
        ArrayList<Spectator> listOfSpectators = cinemaEvent.getSpectatorsWithTicket();
        return listOfSpectators.get(n);
    }
    
  
    
    public CinemaAuditorium getRoomB4SpectatorIndex_n(CinemaManager cinemaEvent, int n){
        /*
        The parameter CinemaManager includes a CinemaAuditorium were 
            a) some Seats are occupied and 
            b) the rest of the seats are empty
        
        Why am I coding this? Because I need it for the loop of placing someone
        */
        
        // When nobody is jet seated ( n = 0, meaning the spectator #0 in the list has not jet been placed) >>> the Auditorium is empty
        CinemaAuditorium originalEmptyCinemaRoom = serv.createFullEmptyAuditorium();
        
        // Before we seat Spectator with index 'n', the room should 'look like' it did after placing Spectator with index (n-1) 
        CinemaAuditorium roomAsParameterIdontKnowHowManySeatedPeople = cinemaEvent.getRoom4thisFilm();
        
        CinemaAuditorium room2return = new CinemaAuditorium(); // now it's empty
        
        if (n==0){
            room2return = originalEmptyCinemaRoom;    
        } else if (n > 0) {
            int previousSpectatorInTheList = n - 1;
            room2return = getRoomAfterSpectatorIndex_n(cinemaEvent,previousSpectatorInTheList);
        }
        
        return room2return;
    }
    
      public CinemaAuditorium getRoomAfterSpectatorIndex_n(CinemaManager cinemaEvent, int n){
        
          // Originally I wrote this:
            // CinemaAuditorium allSeatsBefore = getRoomB4SpectatorIndex_n(cinemaEvent, n);
            
          // I asume it might go into a loop (since the method getRoomB4 calls this method
          
        CinemaAuditorium seatsB4placement = cinemaEvent.getRoom4thisFilm();
        Spectator spectatorWithTicket = getSpectatorIndex_n(cinemaEvent, n);
                
        return serv.placeOneSpectatorRandomlyTry3times(seatsB4placement, spectatorWithTicket);
    }
    
      
    public void displayVisuallyWhatHappens_B4_PlacingSpectatorIndex_n(CinemaManager cinemaEvent, int n){
        Spectator spectator = getSpectatorIndex_n(cinemaEvent, n);
        CinemaAuditorium roomB4placement = cinemaEvent.getRoom4thisFilm();
        System.out.println("");
        System.out.println("This is the room BEFORE placing " + spectator.getSpectatorFullName());
        System.out.println("Index in the list #" + n);
        serv.displayAuditoriumInConsole(roomB4placement);
        System.out.println("");
    }  
      
    public void displayVisuallyWhatHappens_AFTER_PlacingSpectatorIndex_n(CinemaManager cinemaEvent, int n){
        
        CinemaAuditorium allSeatsbefore = cinemaEvent.getRoom4thisFilm();
        Spectator spectator = getSpectatorIndex_n(cinemaEvent, n);
        serv.placeOneSpectatorRandomlyTry3times(allSeatsbefore, spectator);
        
        System.out.println("");
        System.out.println("This is the room AFTER placing " + spectator.getSpectatorFullName());
        serv.displayAuditoriumInConsole(allSeatsbefore);
        System.out.println("");
    }
      
      
    public CinemaAuditorium getRoomAfterPlacingEverySpectator(CinemaManager nextProjection){
        int amountSpectatorsWithTicket = nextProjection.getSpectatorsWithTicket().size();
        CinemaAuditorium roomAfterPlacement = nextProjection.getRoom4thisFilm();
        for (int i = 0; i < amountSpectatorsWithTicket; i++) {
            roomAfterPlacement = getRoomAfterSpectatorIndex_n(nextProjection, i);
        }
        return roomAfterPlacement;
    }
    
    public void displayRoomB4andAfterPlacingSpectatorIndex_n(CinemaManager nextFilm, int n){
        System.out.println("");
        System.out.println("We are working with index #" + Integer.toString(n));
        Spectator spectatorIndex_n = getSpectatorIndex_n(nextFilm, n);
        CinemaAuditorium roomB4spectIndex_n = getRoomB4SpectatorIndex_n(nextFilm, n);
        System.out.println("Before placing customer " + spectatorIndex_n.getSpectatorFullName() + " the room looks like this");
        serv.displayAuditoriumInConsole(roomB4spectIndex_n);
        System.out.println("");
        CinemaAuditorium roomAfterspectIndex_n = getRoomAfterSpectatorIndex_n(nextFilm, n);
        System.out.println("After the placement, the room looks like this");
        serv.displayAuditoriumInConsole(roomAfterspectIndex_n);
        
    }
    
}

/*
 int indexOfSpect = 6;
        Spectator spectatorIndex06 = place.getSpectatorIndex_n(nextSaturdayFilm, indexOfSpect);
        CinemaAuditorium roomB4spect06 = place.getRoomB4SpectatorIndex_n(nextSaturdayFilm, indexOfSpect);
        CinemaAuditorium roomAfterspect06 = place.getRoomAfterSpectatorIndex_n(nextSaturdayFilm, indexOfSpect);
*/

/*

Look at this output... it testes 3 times, then it finds out an empty seat... but it is later NOT USED   
and the Spectator remains un-seated. The problem appears in the loop when the checkIfSeatIsEmpty(); returns FALSE.
Let's analize that part of the code

Test time #1/3 It is false that I found an empty seat
Test time #2/3 It is false that I found an empty seat
Test time #3/3 It is false that I found an empty seat
We tried 3 times to find a seat Randomly
I found that seat 8D is empty

This is the room AFTER placing ALICE MERRYWEATHER
| 8AX | 8BX | 8CX | 8D  | 8EX | 8FX | 
| 7A  | 7B  | 7C  | 7DX | 7EX | 7FX | 
| 6A  | 6BX | 6C  | 6D  | 6E  | 6FX | 
| 5AX | 5BX | 5CX | 5D  | 5E  | 5F  | 
| 4A  | 4B  | 4CX | 4DX | 4EX | 4F  | 
| 3AX | 3BX | 3C  | 3DX | 3EX | 3FX | 
| 2AX | 2B  | 2C  | 2D  | 2E  | 2F  | 
| 1A  | 1B  | 1C  | 1DX | 1E  | 1F  |
*/

/*
Test time #1/3 It is false that I found an empty seat
Test time #2/3 It is false that I found an empty seat
Test time #3/3 It is false that I found an empty seat
We tried 3 times to find a seat Randomly, so now we find a seat Manually
We found that seat 8B is empty.

This is the room AFTER placing ALICE SANCHEZ
| 8AX | 8B  | 8C  | 8DX | 8EX | 8F  | 
| 7AX | 7BX | 7C  | 7D  | 7EX | 7F  | 
| 6AX | 6BX | 6CX | 6D  | 6E  | 6FX | 
| 5A  | 5B  | 5CX | 5DX | 5EX | 5FX | 
| 4AX | 4BX | 4CX | 4DX | 4E  | 4FX | 
| 3AX | 3BX | 3C  | 3DX | 3E  | 3F  | 
| 2A  | 2BX | 2C  | 2DX | 2E  | 2F  | 
| 1A  | 1B  | 1C  | 1D  | 1E  | 1F  | 
*/

/*
When I thought everything was ok I disocvered another fail in the system... someone is seated twice since we sold 25 tickets
but 25 X are shown... I extract this from the output. (...) After careful inspection the problem was the the counter++ was 
in the incorrect place, so 2 parts of the loop were activated in the same loop

Test time #1/3 It is false that I found an empty seat
Test time #2/3 It is false that I found an empty seat
Test time #3/3 It is true that I found an empty seat
We tried 3 times to find a seat Randomly, so now we find a seat Manually
We found that seat 8A is empty.
Seat #8A Only valid for PETER SMITH

Seat #8C Only valid for PETER SMITH


This is the room AFTER placing PETER SMITH
| 8AX | 8B  | 8CX | 8D  | 8EX | 8F  | 
| 7A  | 7B  | 7C  | 7D  | 7E  | 7F  | 
| 6AX | 6B  | 6C  | 6D  | 6E  | 6F  | 
| 5A  | 5B  | 5C  | 5D  | 5E  | 5F  | 
| 4A  | 4B  | 4C  | 4D  | 4E  | 4F  | 
| 3A  | 3BX | 3C  | 3D  | 3E  | 3F  | 
| 2A  | 2B  | 2CX | 2D  | 2E  | 2F  | 
| 1A  | 1B  | 1C  | 1D  | 1E  | 1F  | 

(...) and the last simulations shows 25 people seated

Test time #1/3 It is false that I found an empty seat
Test time #2/3 It is false that I found an empty seat
Test time #3/3 It is false that I found an empty seat
We tried 3 times to find a seat Randomly, so now we find a seat Manually
We found that seat 7B is empty.
Seat #7B Only valid for ALICE MERRYWEATHER


This is the room AFTER placing ALICE MERRYWEATHER
| 8AX | 8BX | 8CX | 8DX | 8EX | 8FX | 
| 7AX | 7BX | 7CX | 7DX | 7E  | 7F  | 
| 6AX | 6B  | 6C  | 6D  | 6E  | 6FX | 
| 5A  | 5B  | 5CX | 5DX | 5EX | 5F  | 
| 4A  | 4B  | 4C  | 4D  | 4E  | 4F  | 
| 3AX | 3BX | 3C  | 3DX | 3E  | 3FX | 
| 2AX | 2BX | 2CX | 2DX | 2EX | 2F  | 
| 1A  | 1B  | 1CX | 1D  | 1E  | 1F  | 

*/


/*
Still not working :(

This is the room AFTER placing ALICE SMITH
| 8A  | 8B  | 8C  | 8D  | 8E  | 8F  | 
| 7AX | 7BX | 7CX | 7DX | 7E  | 7F  | 
| 6AX | 6B  | 6C  | 6DX | 6EX | 6F  | 
| 5AX | 5BX | 5C  | 5D  | 5E  | 5FX | 
| 4A  | 4BX | 4C  | 4D  | 4E  | 4F  | 
| 3A  | 3B  | 3CX | 3DX | 3EX | 3FX | 
| 2A  | 2BX | 2C  | 2D  | 2E  | 2FX | 
| 1AX | 1BX | 1C  | 1DX | 1E  | 1F  | 


Test time #1/3 It is false that I found an empty seat
Test time #2/3 It is false that I found an empty seat
Test time #3/3 It is false that I found an empty seat
Test time #4/3 It is true that I found an empty seat
We tried 3 times to find a seat Randomly, so now we find a seat Manually
We found that seat 8A is empty.
Seat #8A Only valid for ALICE FERGUSON

Seat #7E Only valid for ALICE FERGUSON


This is the room AFTER placing ALICE FERGUSON
| 8AX | 8B  | 8C  | 8D  | 8E  | 8F  | 
| 7AX | 7BX | 7CX | 7DX | 7EX | 7F  | 
| 6AX | 6B  | 6C  | 6DX | 6EX | 6F  | 
| 5AX | 5BX | 5C  | 5D  | 5E  | 5FX | 
| 4A  | 4BX | 4C  | 4D  | 4E  | 4F  | 
| 3A  | 3B  | 3CX | 3DX | 3EX | 3FX | 
| 2A  | 2BX | 2C  | 2D  | 2E  | 2FX | 
| 1AX | 1BX | 1C  | 1DX | 1E  | 1F  | 

*/