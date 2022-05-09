package com.advanced.practice8.jdbc;

import com.advanced.practice8.connection.ConnectionCreator;
import com.advanced.practice8.model.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO implements DAO {
    private static final String SQL_SELECT_ALL_FILMS = "SELECT * FROM films";
    private static final String SQL_FIND_FILM_BY_ID = "SELECT * FROM films WHERE id = (?)";
    private static final String SQL_ADD_FILM = "INSERT INTO films (film_id, name, date, country) VALUES (?, ?, ?, ?)";
    private static final String SQL_REMOVE_FILM = "DELETE FROM films WHERE id = (?)";
    private static final String SQL_UPDATE_FILM = "UPDATE films SET name = (?), date = (?), country = (?) WHERE id = (?)";

    private static final String SQL_SELECT_RECENT_FILMS = "SELECT * FROM films WHERE YEAR(date)=2022 OR YEAR(date)=2021";
    private static final String SQL_DELETE_BY_YEAR = "DELETE FROM films WHERE YEAR(date) = (?)";

    @Override
    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FILMS);
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt("film_id"));
                film.setName(resultSet.getString("name"));
                film.setDate(resultSet.getDate("date"));
                film.setCountry(resultSet.getString("country"));
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return films;
    }

    @Override
    public Object findEntityById(Object id) {
        Film film = new Film();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_FIND_FILM_BY_ID);
            pstmt.setInt(1, (Integer) id);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                film.setId(resultSet.getInt(1));
                film.setName(resultSet.getString(2));
                film.setDate(resultSet.getDate(3));
                film.setCountry(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }

        return film;
    }

    @Override
    public boolean delete(Object id) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();

            PreparedStatement pstmt = connection.prepareStatement(SQL_REMOVE_FILM);
            pstmt.setInt(1, (Integer) id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }

        return true;
    }

    @Override
    public boolean create(Object o) {
        Film film = (Film) o;
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_ADD_FILM);
            pstmt.setInt(1, film.getId());
            pstmt.setString(2, film.getName());
            pstmt.setDate(3, film.getDate());
            pstmt.setString(4, film.getCountry());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return true;
    }

    @Override
    public Object update(Object o) {
        Film film = (Film) o;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE_FILM);
            pstmt.setString(1, film.getName());
            pstmt.setDate(2, film.getDate());
            pstmt.setString(3, film.getCountry());
            pstmt.setInt(4, film.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return true;
    }

    public List<Film> recentFilms() {
        List<Film> films = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(SQL_SELECT_RECENT_FILMS);

            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                Date date = result.getDate(3);
                String country = result.getString(4);
                films.add(new Film(id, name, date, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
            close(statement);
        }
        return films;
    }

    public void deleteByDate(int year) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE_BY_YEAR);
            pstmt.setInt(1, year);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
            close(statement);
        }

    }
}
