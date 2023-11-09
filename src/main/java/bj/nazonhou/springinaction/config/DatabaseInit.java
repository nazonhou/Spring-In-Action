package bj.nazonhou.springinaction.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.github.javafaker.Faker;

import bj.nazonhou.springinaction.domain.Author;
import bj.nazonhou.springinaction.domain.Book;
import bj.nazonhou.springinaction.repository.AuthorRepository;
import bj.nazonhou.springinaction.repository.BookRepository;

@Configuration
public class DatabaseInit {
  @Bean
  @Order(1)
  public ApplicationRunner seedAuthors(AuthorRepository authorRepository) {
    return new ApplicationRunner() {
      public void run(ApplicationArguments args) {
        int authors = 10;

        for (int counter = 0; counter < authors; counter++) {
          authorRepository.save(Author.builder().name(new Faker().book().author()).build());
        }
      }
    };
  }

  @Bean
  @Order(2)
  public ApplicationRunner seedBooks(BookRepository bookRepository, AuthorRepository authorRepository) {
    return (ApplicationArguments args) -> {
      List<Author> authors = new ArrayList<Author>();

      authorRepository.findAll().forEach(author -> {authors.add(author);});

      int books = 5;

      for (int counter = 0; counter < books; counter++) {
        bookRepository.save(
            Book.builder()
                .authorId(authors.get(new Random().nextInt(authors.size())).getId())
                .name(new Faker().book().title()).build());
      }
    };
  }
}
