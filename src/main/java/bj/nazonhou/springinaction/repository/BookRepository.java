package bj.nazonhou.springinaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bj.nazonhou.springinaction.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
