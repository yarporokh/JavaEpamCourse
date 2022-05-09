package com.advanced.practice8;

import com.advanced.practice8.jdbc.FilmDAO;
import com.advanced.practice8.jdbc.PersonDAO;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        FilmDAO filmDAO = new FilmDAO();

        System.out.println(filmDAO.recentFilms());
        System.out.println(personDAO.actorsInFilm("Pirates of the Caribbean: The Curse of the Black Pearl"));
        System.out.println(personDAO.actorAndDirector());
    }
}
