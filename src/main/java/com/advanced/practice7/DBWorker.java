package com.advanced.practice7;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Date;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/video_library?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;
    private Statement statement;
    private Driver driver;


    public DBWorker() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
        driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
    }

    public List<Film> recentFilms() throws SQLException {
        List<Film> films = new ArrayList<>();


        ResultSet result = statement.executeQuery("SELECT * FROM films WHERE YEAR(date)=2022 OR YEAR(date)=2021");

        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            Date date = result.getDate(3);
            String country = result.getString(4);
            films.add(new Film(id, name, date, country));
        }

        return films;
    }

    public List<Person> actorsInFilm(String filmName) throws SQLException {
        List<Person> actors = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM people WHERE person_id IN " +
                "(SELECT person_id FROM actors WHERE film_id = " +
                "(SELECT film_id FROM films WHERE name='" + filmName + "'))");

        getPeopleList(actors, result);

        return actors;
    }


    public List<Person> actorsFromSeveralFilms(int numberOfFilms) throws SQLException {
        List<Person> actors = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        ResultSet result = statement.executeQuery("SELECT person_id FROM actors");
        while (result.next()) {
            int id = result.getInt(1);
            map.merge(id, 1, Integer::sum);
        }

        List<Integer> idList = map.entrySet().stream().filter(x -> x.getValue() >= numberOfFilms).map(Map.Entry::getKey).collect(Collectors.toList());

        String array = idList.toString().replace("[", "(").replace("]", ")");
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM people WHERE person_id IN " + array);

        result = pstmt.executeQuery();
        getPeopleList(actors, result);

        return actors;
    }

    public List<Person> actorAndDirector() throws SQLException {
        List<Person> actors = new ArrayList<>();
        Set<Person> set = new HashSet<>();

        ResultSet result = statement.executeQuery("SELECT * FROM people WHERE person_id IN (SELECT person_id FROM actors WHERE person_id IN (SELECT person_id FROM directors))");

        while (result.next()) {
            int id = result.getInt(1);
            String fullname = result.getString(2);
            Date date = result.getDate(3);
            set.add(new Person(id, fullname, date));
        }
        actors.addAll(set);

        return actors;
    }

    public void deleteByDate(int year) throws SQLException {
        String query = "DELETE FROM films WHERE YEAR(date) = " + year;
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.execute();
    }


    private void getPeopleList(List<Person> actors, ResultSet result) throws SQLException {
        while (result.next()) {
            int id = result.getInt(1);
            String fullname = result.getString(2);
            Date date = result.getDate(3);
            actors.add(new Person(id, fullname, date));
        }
    }
}
