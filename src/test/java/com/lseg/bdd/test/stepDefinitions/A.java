//package com.lseg.bdd.test.stepDefinitions;
//
//import java.awt.print.Book;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class BookStore {
//    private List<Book> books = new ArrayList<>();
//
//    public void addBook(Book book) {
//        books.add(book);
//    }
//
//    public List<Book> booksByAuthor(String author) {
//        return books.stream()
//                .filter(book -> Objects.equals(author, book.getAuthor()))
//                .collect(Collectors.toList());
//    }
//
//    public Optional<Book> bookByTitle(String title) {
//        return books.stream()
//                .filter(book -> book.getTitle().equals(title))
//                .findFirst();
//    }
//}