package bj.nazonhou.springinaction.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.nazonhou.springinaction.domain.Author;
import bj.nazonhou.springinaction.repository.AuthorRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/v1/authors")
@AllArgsConstructor
public class AuthorController {
  private final AuthorRepository authorRepository;

  @GetMapping
  public List<Author> getAuthors() {
    return authorRepository.getAuthors();
  }

  @GetMapping(path = "/{id}")
  public Optional<Author> getAuthor(@PathVariable Long id) {
    return authorRepository.getAuthor(id);
  }
}
