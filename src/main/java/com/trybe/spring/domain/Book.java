package com.trybe.spring.domain;

import java.util.UUID;

public class Book {

  private UUID id;

  private String name;

  private String author;

  // constructor sem parametro (vazio) implementado por causa do IoC (inversão de controle do
  // Spring)
  Book() {
    this.id = UUID.randomUUID();
  }

  public Book(String name, String author) {
    this.id = UUID.randomUUID(); // toda nova instância terá um novo id
    this.name = name;
    this.author = author;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj instanceof Book) {
      Book book = (Book) obj;

      if (book.getName().equals(this.getName())) {
        return true;
      }
    }

    return false;
  }
}
