package com.mbasweti.books.controller;

import com.mbasweti.books.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController(){
        initializeBooks();
    }

    private void initializeBooks(){
        books.addAll(List.of(
                new Book("Title one", "Author one", "Science"),
                new Book("Title two", "Author two", "science"),
                new Book("Title three", "Author three", "history"),
                new Book("Title four", "Author four", "math"),
                new Book("Title five", "Author five", "math"),
                new Book("Title six", "Author six", "math")

        ));
    }

    @GetMapping("/api")
    public String firstApi() {
        return "hello mike";
    }

/*
    get all books
    @GetMapping("api/books")
    public List<Book> getBooks(){
        return books;
    }
*/

    @GetMapping("api/books")
    public List<Book> getBooks(@RequestParam(required = false) String category){
        if(category == null){
            return books;
        }

/*
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getCategory().equalsIgnoreCase(category)){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
*/

        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @GetMapping("api/books/{title}")
    public Book getBookByTitle(@PathVariable String title) {

/*
    1st option
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
*/

        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

}
