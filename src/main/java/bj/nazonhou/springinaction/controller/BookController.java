package bj.nazonhou.springinaction.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.nazonhou.springinaction.domain.Book;
import bj.nazonhou.springinaction.repository.BookRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/v1/books")
@AllArgsConstructor
public class BookController {
 
  public final BookRepository bookRepository;

  @PostMapping
  public Book createBook(@Valid Book book) {
    return bookRepository.createBook(book);
  }
}
