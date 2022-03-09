/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_app.entities;

import java.util.ArrayList;

/**
 * A collection of the movies which are available
 * @author Ivan
 */
public class FilmCatalogue {
    
    // maybe I can avoid using this, and just adding the catalogue as part of the manager class... let's see
    // This is just for pleasure, a collection of a few movies that I love :)
    
    private ArrayList<Film> moviesThatIvanLoves;

    public FilmCatalogue() {
    }

    public FilmCatalogue(ArrayList<Film> moviesThatIvanLoves) {
        this.moviesThatIvanLoves = moviesThatIvanLoves;
    }

    public ArrayList<Film> getMoviesThatIvanLoves() {
        return moviesThatIvanLoves;
    }

    public void setMoviesThatIvanLoves(ArrayList<Film> moviesThatIvanLoves) {
        this.moviesThatIvanLoves = moviesThatIvanLoves;
    }

    @Override
    public String toString() {
        return "FilmCatalogue{" + "moviesThatIvanLoves=" + moviesThatIvanLoves + '}';
    }
    
    
    
}
