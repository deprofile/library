package repository;

import configuration.DBConnection;
import entity.Book;

import java.sql.*;
import java.time.LocalDate;


public class BookRepository {

    String sqlGetAll = "SELECT * FROM books";
    String sqlGetById = "SELECT * FROM books WHERE id = ?";
    String sqlSave = """
            INSERT INTO books(title, publication_date)
            VALUES(?, ?)
            """;

    String sqlUpdate = """
            UPDATE books
            SET title = ?
            WHERE id = ?
            """;

    String sqlDelete = """
            DELETE FROM books
            WHERE id = ?
            """;

    String sqlReduceAvailableAmount = """
            UPDATE books
            SET available_amount = available_amount-1
            WHERE id = ?
            """;
    String sqlIncreaseBorrowedCount = """
            UPDATE books
            SET borrowed_count = borrowed_count+1
            WHERE id = ?
            """;

    public void getAll() {

        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlGetAll)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getLong("id") + "---" + rs.getString("title"));
            }

        } catch (Exception e) {

        }
    }

    public Book getById(long id) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlGetById)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getLong("id") + "---" + rs.getString("title"));

                return new Book(rs.getLong("id"),
                        rs.getString("title"),
                        rs.getDate("publication_date").toLocalDate());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void save(String title, LocalDate publicationDate) {
        try (Connection conn = DBConnection.connect();
             var ps = conn.prepareStatement(sqlSave)) {

            ps.setString(1, title);
            ps.setDate(2, Date.valueOf(publicationDate));
            ps.executeUpdate();

        } catch (Exception e) {

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

    public void reduceAvailableAmount (Long bookID) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sqlReduceAvailableAmount)){

            ps.setLong(1, bookID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void increaseBorrowedCount (Long bookID) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sqlReduceAvailableAmount)){

            ps.setLong(1, bookID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



