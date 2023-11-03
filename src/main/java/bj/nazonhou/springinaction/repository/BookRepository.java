package bj.nazonhou.springinaction.repository;

import java.util.List;
import java.util.Optional;

import bj.nazonhou.springinaction.domain.Book;

public interface BookRepository {
  public List<Book> getBooks();

  public List<Book> getAuthorBooks(Long authorId);

  public Optional<Book> getBook(Long id);
}
