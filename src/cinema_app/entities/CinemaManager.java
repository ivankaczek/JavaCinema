/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We have here everything that is related to the MANAGEMENT that the cinema needs
 * @author Ivan  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
public class CinemaManager {
    
    private Film filmPlayingNow;
    private CinemaAuditorium room4thisFilm;
    private double filmTicketPrice;

    public CinemaManager() {
    }

    public CinemaManager(Film filmPlayingNow, CinemaAuditorium room4thisFilm, double filmTicketPrice) {
        this.filmPlayingNow = filmPlayingNow;
        this.room4thisFilm = room4thisFilm;
        this.filmTicketPrice = filmTicketPrice;
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

    @Override
    public String toString() {
        return "CinemaManager{" + "filmPlayingNow=" + filmPlayingNow + ", room4thisFilm=" + room4thisFilm + ", filmTicketPrice=" + filmTicketPrice + '}';
    }
    
    
}

/*
De Cine nos interesa conocer    la película que se está reproduciendo, 
                                la sala con los espectadores y el 
                                precio de la entrada. 
*/