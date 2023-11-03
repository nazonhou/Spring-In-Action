package bj.nazonhou.springinaction.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bj.nazonhou.springinaction.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

  private final JdbcTemplate jdbcTemplate;

  public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Book> getBooks() {
    String sql = "SELECT * FROM books";

    return jdbcTemplate.query(sql, (ResultSet resultSet, int rowNumber) -> getBookFromResultSet(resultSet));
  }

  @Override
  public List<Book> getAuthorBooks(Long authorId) {
    String sql = "SELECT * FROM books WHERE author_id = ?";

    return jdbcTemplate.query(sql,
        (ResultSet resultSet, int rowNumber) -> getBookFromResultSet(resultSet),
        authorId);
  }

  @Override
  public Optional<Book> getBook(Long id) {
    String sql = "SELECT * FROM books WHERE id = ?";
    List<Book> books = jdbcTemplate.query(sql, (ResultSet resultSet, int rowNumber) -> getBookFromResultSet(resultSet),
        id);

    return books.size() == 0 ? Optional.empty() : Optional.of(books.get(0));
  }

  private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
    return new Book(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getLong("author_id"));
  }

}
