package repository;

import configuration.DBConnection;
import entity.Author;

import java.sql.*;

public class AuthorRepository {

    String sqlGetAll = "SELECT * FROM authors";
    String sqlGetById = "SELECT * FROM authors WHERE id = ?";
    String sqlSave = """
            INSERT INTO authors(name)
            VALUES (?)
            """;

    String sqlUpdate = """
            UPDATE authors
            set name = ?
            WHERE Id = ?
            """;

    String sqlDelete = """
            DELETE from authors
            WHERE id = ?
            """;

    void getAll() {

        try (Connection conn = DBConnection.connect()) {
            PreparedStatement ps = conn.prepareStatement(sqlGetAll);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getLong("id") + "---" + rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Author getById(long id) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlGetById)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            System.out.println(rs.getLong("id") + "---" + rs.getString("name"));

            return new Author(rs.getString("name"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String name) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlSave)) {

            ps.setString(1, name);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void update(String name, Long id) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlUpdate)) {

            ps.setString(1, name);
            ps.setLong(2, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void remove(Long id) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlDelete)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
}
