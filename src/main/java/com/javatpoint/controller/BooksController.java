package com.javatpoint.controller;

import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mark the class as a controller
@RestController

public class BooksController {
    //autowire the booksservice class
    @Autowired
    BooksService booksService;

    //creating a get mapping that retrieves all the book detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    //create a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid){
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specific book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid){
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books.getBookid();

    }

    //creating put ,apping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books;
    }
}
