package bj.nazonhou.springinaction.repository;

import java.util.List;
import java.util.Optional;

import bj.nazonhou.springinaction.domain.Author;

public interface AuthorRepository {
  public List<Author> getAuthors();

  public Optional<Author> getAuthor(Long id);

  public Author createAuthor(Author author);
}
