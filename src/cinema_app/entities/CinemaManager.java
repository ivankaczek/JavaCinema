/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

import java.util.ArrayList;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We have here everything that is related to the MANAGEMENT that the cinema needs
 * @author Ivan  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
public class CinemaManager {
    
    private Film filmPlayingNow;
    private CinemaAuditorium room4thisFilm;
    private double filmTicketPrice;
    private ArrayList<Spectator> spectatorsWithTicket;
    

    public CinemaManager() {
         this.spectatorsWithTicket = new ArrayList();
    }

    public CinemaManager(Film filmPlayingNow, CinemaAuditorium room4thisFilm, double filmTicketPrice) {
        /*
            When I decide about next proyection, I can choose the film, which room and the price
            But only later, I can fill the list with spectator that buy tickets
        */
        this.filmPlayingNow = filmPlayingNow;
        this.room4thisFilm = room4thisFilm;
        this.filmTicketPrice = filmTicketPrice;
    }

    
    
    
    public CinemaManager(Film filmPlayingNow, CinemaAuditorium room4thisFilm, double filmTicketPrice, ArrayList<Spectator> spectatorsWithTicket) {
        this.filmPlayingNow = filmPlayingNow;
        this.room4thisFilm = room4thisFilm;
        this.filmTicketPrice = filmTicketPrice;
        this.spectatorsWithTicket = spectatorsWithTicket;
    }

    public Film getFilmPlayingNow() {
        return filmPlayingNow;
    }

    public void setFilmPlayingNow(Film filmPlayingNow) {
        this.filmPlayingNow = filmPlayingNow;
    }

    public CinemaAuditorium getRoom4thisFilm() {
        return room4thisFilm;
    }

    public void setRoom4thisFilm(CinemaAuditorium room4thisFilm) {
        this.room4thisFilm = room4thisFilm;
    }

    public double getFilmTicketPrice() {
        return filmTicketPrice;
    }

    public void setFilmTicketPrice(double filmTicketPrice) {
        this.filmTicketPrice = filmTicketPrice;
    }

    public ArrayList<Spectator> getSpectatorsWithTicket() {
        return spectatorsWithTicket;
    }

    public void setSpectatorsWithTicket(ArrayList<Spectator> spectatorsWithTicket) {
        this.spectatorsWithTicket = spectatorsWithTicket;
    }

    


    
}

/*
De Cine nos interesa conocer    la película que se está reproduciendo, 
                                la sala con los espectadores y el 
                                precio de la entrada. 
*/