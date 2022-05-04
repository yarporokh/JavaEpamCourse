package com.advanced.practice7;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBWorker dbWorker = new DBWorker();
        System.out.println(dbWorker.recentFilms());
        System.out.println(dbWorker.actorsInFilm("Pirates of the Caribbean: The Curse of the Black Pearl"));
        System.out.println(dbWorker.actorsFromSeveralFilms(5));
        System.out.println(dbWorker.actorAndDirector());
        dbWorker.deleteByDate(2034);
    }
}
