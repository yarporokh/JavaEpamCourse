package com.advanced.practice8.jdbc;

import com.advanced.practice8.connection.ConnectionCreator;
import com.advanced.practice8.model.Person;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class PersonDAO implements DAO {
    private static final String SQL_SELECT_ALL_PEOPLE = "SELECT * FROM people";
    private static final String SQL_FIND_PERSON_BY_ID = "SELECT * FROM people WHERE id = (?)";
    private static final String SQL_ADD_PERSON = "INSERT INTO people (person_id, fullname, date) VALUES (?, ?, ?)";
    private static final String SQL_REMOVE_PERSON = "DELETE FROM people WHERE id = (?)";
    private static final String SQL_UPDATE_PERSON = "UPDATE people SET fullname = (?), date = (?) WHERE id = (?)";

    private static final String SQL_SELECT_ACTORS_FROM_FILM = "SELECT p.person_id, p.fullname, p.date\n" +
            "FROM films f\n" +
            "JOIN actors a ON f.film_id=a.film_id\n" +
            "JOIN people p ON a.person_id=p.person_id " +
            "WHERE f.name = (?)";
    private static final String SQL_SELECT_ACTORS = "SELECT person_id FROM actors";
    private static final String SQL_ALL_ROLES = "SELECT * FROM people WHERE person_id IN (?)";
    private static final String SQL_ACTORS_AND_DIRECTORS = "SELECT p.person_id, p.fullname, p.date\n" +
            "FROM people p\n" +
            "JOIN actors a ON a.person_id = p.person_id\n" +
            "JOIN directors d ON d.person_id = a.person_id";


    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PEOPLE);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFullname(resultSet.getString("fullname"));
                person.setDate(resultSet.getDate("date"));
                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return people;
    }

    @Override
    public Person findEntityById(Object id) {
        Person person = new Person();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();

            PreparedStatement pstmt = connection.prepareStatement(SQL_FIND_PERSON_BY_ID);
            pstmt.setInt(1, (Integer) id);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setFullname(resultSet.getString(2));
                person.setDate(resultSet.getDate(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }

        return person;
    }

    @Override
    public boolean delete(Object id) {
        Connection connection = null;

        try {
            connection = ConnectionCreator.createConnection();

            PreparedStatement pstmt = connection.prepareStatement(SQL_REMOVE_PERSON);
            pstmt.setInt(1, (Integer) id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }

        return true;
    }

    @Override
    public boolean create(Object o) {
        Person p = (Person) o;
        Connection connection = null;

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_ADD_PERSON);
            pstmt.setInt(1, p.getId());
            pstmt.setString(2, p.getFullname());
            pstmt.setDate(3, (Date) p.getDate());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return true;
    }

    @Override
    public Object update(Object o) {
        Person p = (Person) o;
        Connection connection = null;

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE_PERSON);
            pstmt.setString(1, p.getFullname());
            pstmt.setString(2, String.valueOf(p.getDate()));
            pstmt.setInt(3, p.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return true;
    }

    public List<Person> actorsInFilm(String filmName) {
        List<Person> actors = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_ACTORS_FROM_FILM);
            pstmt.setString(1, filmName);
            ResultSet result = pstmt.executeQuery();

            getPeopleList(actors, result);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return actors;
    }


    public List<Person> actorsFromSeveralFilms(int numberOfFilms) {
        List<Person> actors = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(SQL_SELECT_ACTORS);
            while (result.next()) {
                int id = result.getInt(1);
                map.merge(id, 1, Integer::sum);
            }

            List<Integer> idList = map.entrySet().stream().filter(x -> x.getValue() >= numberOfFilms).map(Map.Entry::getKey).collect(Collectors.toList());
            String array = idList.toString().replace("[", "(").replace("]", ")");
            PreparedStatement pstmt = connection.prepareStatement(SQL_ALL_ROLES);
            pstmt.setString(1, array);


            result = pstmt.executeQuery();
            getPeopleList(actors, result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
            close(statement);
        }

        return actors;
    }


    public List<Person> actorAndDirector() {
        List<Person> actors = new ArrayList<>();
        Set<Person> set = new HashSet<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(SQL_ACTORS_AND_DIRECTORS);
            while (result.next()) {
                int id = result.getInt(1);
                String fullname = result.getString(2);
                Date date = result.getDate(3);
                set.add(new Person(id, fullname, date));
            }
            actors.addAll(set);



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
            close(statement);
        }

        return actors;
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
