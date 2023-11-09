package bj.nazonhou.springinaction.repository;

import org.springframework.data.repository.CrudRepository;

import bj.nazonhou.springinaction.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
