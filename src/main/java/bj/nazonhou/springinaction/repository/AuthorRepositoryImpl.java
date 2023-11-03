package bj.nazonhou.springinaction.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bj.nazonhou.springinaction.domain.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

  private final JdbcTemplate jdbcTemplate;

  public AuthorRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Author> getAuthors() {
    String sql = "SELECT * FROM authors";

    return jdbcTemplate.query(sql, (ResultSet resultSet, int rowNumber) -> {
      return getAuthorFromResultSet(resultSet);
    });
  }

  @Override
  public Optional<Author> getAuthor(Long id) {
    String sql = "SELECT * FROM authors WHERE id = ?";

    List<Author> authors = jdbcTemplate.query(sql, (ResultSet resultSet, int rowNumber) -> {
      return getAuthorFromResultSet(resultSet);
    }, id);

    return authors.size() == 0 ? Optional.empty() : Optional.of(authors.get(0));
  }

  private Author getAuthorFromResultSet(ResultSet resultSet) throws SQLException {
    return new Author(resultSet.getLong("id"), resultSet.getString("name"));
  }

}
