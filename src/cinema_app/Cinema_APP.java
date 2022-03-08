/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app;

import cinema_app.entities.CinemaAuditorium;
import cinema_app.entities.CinemaCustomers;
import cinema_app.entities.CinemaServices;
import cinema_app.entities.Spectator;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class Cinema_APP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // PART ONE: Dealing with the cinema room
        
        CinemaServices serv = new CinemaServices();
        
//        String[] the48kodes = serv.createAllTheSeatCodes();
//        
//        for (String oneCode : the48kodes) {
//            System.out.print(oneCode+" ");
//        }
        
        // now let's create the full auditorium
        CinemaAuditorium room1 = serv.createAuditoriumFromListOfSeatCodes(serv.createAllTheSeatCodes());
        ArrayList<String> temporaryListJust2check = serv.listSeatCodes4display(room1);
        serv.displayStringArrayList(temporaryListJust2check);
        
        // let's 'occupy' some seats to check if it works
        room1.getSeatsInCinema().get(0).setSeatWithSomeone(true);
        room1.getSeatsInCinema().get(1).setSeatWithSomeone(true);
        room1.getSeatsInCinema().get(2).setSeatWithSomeone(true);
        room1.getSeatsInCinema().get(3).setSeatWithSomeone(true);
        room1.getSeatsInCinema().get(4).setSeatWithSomeone(true);
        
        // and let's show again the seats to check if it worked
        ArrayList<String> anotherTemporaryListJust2check = serv.listSeatCodes4display(room1);
         serv.displayStringArrayList(anotherTemporaryListJust2check);
        
        // let's check and bring info about a seat
        
        //System.out.println(room1.getSeatsInCinema().get(25).toString());
        
        /*
        It apparently works since I get to following output
        run:
CinemaSeat{seatIndexInArray=25, seatWithSomeone=false, seatSpectatorName=null, seatCode2=4B}
BUILD SUCCESSFUL (total time: 0 seconds)
        */
        
        // PART TWO: Dealing with the spectators
       
        ArrayList<String> temporaryArrayWith30FullNames = serv.create30randomFullNames();
        
        // Now let's check if the collection of spectators actually worked
        
        CinemaCustomers aSaturdayNightCollectionOfSpectators = serv.create30randomSpectators();
        
        // let's see if we actually have something inside that array of Spectators
        
//        System.out.println(aSaturdayNightCollectionOfSpectators.getListOfSpectators().get(3).toString());
//        for (Spectator singleSpectator : aSaturdayNightCollectionOfSpectators.getListOfSpectators()) {
//            System.out.println(singleSpectator.toString());
//        }
        
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