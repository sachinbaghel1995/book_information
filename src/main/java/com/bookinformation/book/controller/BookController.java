package com.bookinformation.book.controller;

import com.bookinformation.book.pojo.BookRequest;
import com.bookinformation.book.pojo.BookResponse;
import com.bookinformation.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> getBook(@RequestBody BookRequest request) {
        try {
            BookResponse response = bookService.getBookDetails(request.getIsbn());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
