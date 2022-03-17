/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app;

import cinema_app.entities.CinemaAuditorium;
import cinema_app.entities.CinemaCustomers;
import cinema_app.entities.CinemaManager;
import cinema_app.entities.CinemaPrices;
import cinema_app.entities.CinemaSeat;
import cinema_app.entities.CinemaServices;
import cinema_app.entities.Spectator;
import cinema_app.placement_services.CinemaPlacementServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Cinema_APP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CinemaServices serv = new CinemaServices();
        CinemaPlacementServices place = new CinemaPlacementServices();
        
    //  1: Dealing with the CINEMA ROOM
    
        CinemaAuditorium room1 = serv.createFullEmptyAuditorium();
     
    //  2: Specification about next Saturday film projection BEFORE SELLING TICKETS
    
        CinemaManager nextSaturdayFilm = serv.generateSpecificCinemaEventExemple(room1);
  
        serv.displayInfoAboutNextMovieManagement(nextSaturdayFilm);
    
    //  3.1: List with potential clients before knowing if they have the available money and the age to buy the movie ticket     
               
        CinemaCustomers aSaturdayNightCollectionOfSpectators = serv.create30randomSpectators();
        
    //  3.2: List with customers that have both the money to pay the ticket and the minimum age    
        
        int minRequiredAge = nextSaturdayFilm.getFilmPlayingNow().getFilmMininumAge();
        double ticketPrice4nextSaturday = nextSaturdayFilm.getFilmTicketPrice();
        CinemaCustomers spectatorsAgeMoney = serv.filterCustomersAgeMoney(aSaturdayNightCollectionOfSpectators, minRequiredAge, ticketPrice4nextSaturday);
    
    //  3.3 Apply that filtered list to the CinemaManager attribute

        nextSaturdayFilm.setSpectatorsWithTicket(spectatorsAgeMoney.getListOfSpectators());
        
    //  3.4 Specification about next Saturday film projection AFTER SELLING TICKETS
    
        serv.displayInfoAboutNextMovieManagementAfterSellingTickets(nextSaturdayFilm);
    
    //  ?.0 Placing everybody

//        place.getRoomAfterPlacingEverySpectator(nextSaturdayFilm);
//        System.out.println("");
//        System.out.println("This is what happens after placing " + nextSaturdayFilm.getSpectatorsWithTicket().size() + " people");
//        serv.displayAuditoriumInConsole(nextSaturdayFilm.getRoom4thisFilm());
        
    //  4:  Placing one person    
    
    //  4.0 Placing the 1st person in the list
    
    //  4.0.0 We show the room BEFORE and AFTER we place the first person (that's why I choose n = 0)
    
        int amountPeople2place = nextSaturdayFilm.getSpectatorsWithTicket().size();
        
        for (int i = 0; i < amountPeople2place; i++) {
            System.out.println("Simulation for placement of customer #" + (i+1) + "/" + amountPeople2place);
            System.out.println("----------------------------------------");
            System.out.println("");
            place.displayVisuallyWhatHappens_AFTER_PlacingSpectatorIndex_n(nextSaturdayFilm, i);
        }
    
    
        //place.displayVisuallyWhatHappens_B4_PlacingSpectatorIndex_n(nextSaturdayFilm, 0);
        //place.displayVisuallyWhatHappens_AFTER_PlacingSpectatorIndex_n(nextSaturdayFilm, 0);
        
     //  4.0.1 We show the room BEFORE and AFTER we place the first person (that's why I choose n = 1)
    
        //place.displayVisuallyWhatHappens_B4_PlacingSpectatorIndex_n(nextSaturdayFilm, 1);
        //place.displayVisuallyWhatHappens_AFTER_PlacingSpectatorIndex_n(nextSaturdayFilm, 1);   
        
        
        
        
        
        
        
    //  4.1 Exemple: I place Spectator #7 in the list (that correspond to index #6)
    
//        int indexOfSpect = 6;
//        Spectator spectatorIndex06 = place.getSpectatorIndex_n(nextSaturdayFilm, indexOfSpect);
//        CinemaAuditorium roomB4spect06 = place.getRoomB4SpectatorIndex_n(nextSaturdayFilm, indexOfSpect);
//        CinemaAuditorium roomAfterspect06 = place.getRoomAfterSpectatorIndex_n(nextSaturdayFilm, indexOfSpect);
        
//        System.out.println("");
//        System.out.println("Let's see what happens BEFORE we place spectator #" + indexOfSpect + " called " + spectatorIndex06.getSpectatorFullName());
//        System.out.println("");
//        System.out.println("Here follows a display of the room");
//        serv.displayAuditoriumInConsole(roomB4spect06);
//        System.out.println("");
        
        
//        System.out.println("");
//        System.out.println("Let's see what happens after we place spectator #" + indexOfSpect + " called " + spectatorIndex06.getSpectatorFullName());
//        System.out.println("");
//        System.out.println("Here follows a display of the room");
//        serv.displayAuditoriumInConsole(roomAfterspect06);
//        System.out.println("");
//        
//        place.displayRoomB4andAfterPlacingSpectatorIndex_n(nextSaturdayFilm, 8);
        
        
        
        
    //  4: We seat 4 (four) customers in the room
    
        //CinemaAuditorium roomAfter4placements =  serv.place4SpectatorsInListCavemanMethod(room1, spectatorsAgeMoney);
        
        //serv.displayAuditoriumInConsole(roomAfter4placements);











    
        
        
        
        //System.out.println("Here follows a list with the spectators who are old enough to watch the film AND have the money for it");
//        ArrayList<Spectator> people = serv.filterSpectatorsAge(aSaturdayNightCollectionOfSpectators.getListOfSpectators(), nextSaturdayFilm.getFilmPlayingNow().getFilmMininumAge());
//        System.out.println("");
//         ArrayList<Spectator> peopleWithMoney = serv.filterSpectatorsMoney(people,nextSaturdayFilm.getFilmTicketPrice());
//        for (Spectator spectator : peopleWithMoney) {
//            System.out.println(spectator.toString());
//        }
        //System.out.println("");
        
        //Spectator spectatorReady = peopleWithMoney.get(2);
        
        //serv.placeOneSpectatorRandomlyTry3times(room1, spectatorReady);
        
        // let's see if we actually have something inside that array of Spectators
        
//        System.out.println(aSaturdayNightCollectionOfSpectators.getListOfSpectators().get(3).toString());
//        for (Spectator singleSpectator : aSaturdayNightCollectionOfSpectators.getListOfSpectators()) {
//            System.out.println(singleSpectator.toString());
//        }

//      let's check out of that list with spectators, WHICH ONES HAVE THE AGE & THE MONEY TO BUY A TICKET
//      And that's part of my CinemaManager attribute
//      So now I need an ArrayList<Spectators> to use as that attribute
       
        
        
       
        Spectator randomSpect01 = aSaturdayNightCollectionOfSpectators.getListOfSpectators().get(3);
        Spectator randomSpect02 = aSaturdayNightCollectionOfSpectators.getListOfSpectators().get(5);
        Spectator randomSpect03 = aSaturdayNightCollectionOfSpectators.getListOfSpectators().get(7);
        Spectator randomSpect04 = aSaturdayNightCollectionOfSpectators.getListOfSpectators().get(8);

//        CinemaAuditorium hallAfterOnePlacement = serv.randomOneSpectatorPlacementCavemanMethod(room1, randomSpect01);
//        hallAfterOnePlacement = serv.randomOneSpectatorPlacementCavemanMethod(room1, randomSpect02);
//        hallAfterOnePlacement = serv.randomOneSpectatorPlacementCavemanMethod(room1, randomSpect03);
//        hallAfterOnePlacement = serv.randomOneSpectatorPlacementCavemanMethod(room1, randomSpect04);

        // I could code a method to sit them ALL
        
        // I only want to watch the room before and after the placement
        
        
//serv.displayAuditoriumInConsole(room1);

//serv.placeOneSpectatorRandomlyTry3times(room1, spectatorReady);

//serv.displayAuditoriumInConsole(room1);



    }
    
}
/*
ATTENTION: la sala es una colecciónd e asientos
            es mucho más fácil que las butacas sean una lista (arraylist) y la matriz solo para mostrar
                la butaca podría tener como atributo un espectador, o si está ocupada o no

*/


/*
Nos piden hacer un programa sobre un Cine, que tiene una sala con un conjunto de asientos (8 filas por 6 columnas).

De Cine nos interesa conocer    la película que se está reproduciendo, 
                                la sala con los espectadores y el 
                                precio de la entrada. 

Luego, de las películas nos interesa saber      el título, 
                                                duración, 
                                                edad mínima y 
                                                director. 
Por último, del espectador, nos interesa saber      su nombre, 
                                                    edad y el 
                                                    dinero que tiene disponible.
Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son etiquetados por una letra y un número 
la fila A1 empieza al final del mapa como se muestra en la tabla. 
También deberemos saber si el asiento está ocupado por un espectador o no, 
si esta ocupado se muestra una X, sino un espacio vacío.
8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
6 A | 6 B X | 6 C | 6 D X | 6 E X | 6 F
5 A X | 5 B | 5 C X | 5 D X | 5 E X | 5 F X
4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
3 A | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F
1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X

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