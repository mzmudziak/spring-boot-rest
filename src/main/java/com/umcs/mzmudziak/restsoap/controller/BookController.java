package com.umcs.mzmudziak.restsoap.controller;

import com.umcs.mzmudziak.restsoap.entity.BookEntity;
import com.umcs.mzmudziak.restsoap.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {
  private final BookRepository bookRepository;

  @RequestMapping(method = RequestMethod.GET)
  public List<BookEntity> findAll() {
    return bookRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public BookEntity create(@RequestBody BookEntity book) {
    return bookRepository.save(book);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
  public BookEntity update(@RequestBody BookEntity book, @PathVariable Long id) {
    BookEntity b = bookRepository.getOne(id);
    b.setAuthor(book.getAuthor());
    b.setTitle(book.getTitle());
    return bookRepository.save(b);
  }
}
