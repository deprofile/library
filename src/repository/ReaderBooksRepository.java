package repository;

import configuration.DBConnection;
import entity.Book;
import entity.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReaderBooksRepository {
    String sqlGetReaderBooks = """
            SELECT
            """;
    String sqlBorrowBook = """
            INSERT INTO reader_books(book_id, reader_id)
            VALUES (?, ?)
            """;

    public void borrowBook (long readerId, long bookId){

        try (Connection conn = DBConnection.connect()){
            PreparedStatement ps = conn.prepareStatement(sqlBorrowBook);

            ps.setLong(1, bookId);
            ps.setLong(2, readerId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
