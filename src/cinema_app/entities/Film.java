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
public class Film {
    private String filmTitle;
    private String filmDirector;
    private int filmDurationMinutes;
    private int filmMininumAge;

    public Film() {
    }

    public Film(String filmTitle, String filmDirector, int filmDurationMinutes, int filmMininumAge) {
        this.filmTitle = filmTitle;
        this.filmDirector = filmDirector;
        this.filmDurationMinutes = filmDurationMinutes;
        this.filmMininumAge = filmMininumAge;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public int getFilmDurationMinutes() {
        return filmDurationMinutes;
    }

    public void setFilmDurationMinutes(int filmDurationMinutes) {
        this.filmDurationMinutes = filmDurationMinutes;
    }

    public int getFilmMininumAge() {
        return filmMininumAge;
    }

    public void setFilmMininumAge(int filmMininumAge) {
        this.filmMininumAge = filmMininumAge;
    }

    @Override
    public String toString() {
        return "Film{" + "filmTitle=" + filmTitle + ", filmDirector=" + filmDirector + ", filmDurationMinutes=" + filmDurationMinutes + ", filmMininumAge=" + filmMininumAge + '}';
    }
    
    
    
}

/*
Luego, de las películas nos interesa saber      el título, 
                                                duración, 
                                                edad mínima y 
                                                director. 
*/


