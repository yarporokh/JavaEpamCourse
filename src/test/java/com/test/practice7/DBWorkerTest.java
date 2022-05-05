package com.test.practice7;

import com.advanced.practice7.DBWorker;
import com.advanced.practice7.Film;
import com.advanced.practice7.Person;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

class DBWorkerTest {
    DBWorker dbWorker = new DBWorker();

    DBWorkerTest() throws SQLException {
    }

    @Test
    void recentFilms() throws SQLException {
        Film film = dbWorker.recentFilms().get(0);
        assertEquals(7,film.getId());
        assertEquals("King Richard", film.getName());
        assertEquals("USA", film.getCountry());
    }

    @Test
    void actorsInFilm() throws SQLException {
        List<Person> list = dbWorker.actorsInFilm("Pirates of the Caribbean: The Curse of the Black Pearl");
        assertEquals("Johnny Depp", list.get(0).getFullname());
        assertEquals("Geoffrey Rush", list.get(1).getFullname());
        assertEquals("Orlando Bloom", list.get(2).getFullname());
    }

    @Test
    void actorsFromSeveralFilms() throws SQLException {
        List<Person> list = dbWorker.actorsFromSeveralFilms(5);
        assertEquals("Johnny Depp", list.get(0).getFullname());
        assertEquals("Geoffrey Rush", list.get(1).getFullname());
    }

    @Test
    void actorAndDirector() throws SQLException {
        List<Person> list = dbWorker.actorAndDirector();
        assertEquals("Johnny Depp", list.get(0).getFullname());
    }
}