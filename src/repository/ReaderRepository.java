package repository;

import configuration.DBConnection;
import entity.Book;
import entity.Reader;

import java.sql.*;
import java.time.LocalDate;

public class ReaderRepository {
    String sqlGetAll = "SELECT * FROM readers";
    String sqlGetById = "SELECT * FROM readers WHERE id = ?";
    String sqlSave = """
            INSERT INTO readers(name, total_books)
            VALUES (?, ?)
            """;

    String sqlUpdate = """
            UPDATE readers
            set name = ?
            WHERE id = ?
            """;

    String sqlDelete = """
            DELETE from readers
            WHERE id = ?
            """;

    public void getAll() {

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

    public Reader getById(long id) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlGetById)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            System.out.println(rs.getLong("id") + "---" + rs.getString("name"));

            return new Reader(rs.getLong("id"),
                    rs.getInt("total_books"),
                    rs.getString("name"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String name,  int totalBooks) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sqlSave)) {

            ps.setString(1, name);
            ps.setInt(2, totalBooks);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Exception save reader");
        }
    }

    public void update(String title, Long id) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlUpdate)) {

            ps.setString(1, title);
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
