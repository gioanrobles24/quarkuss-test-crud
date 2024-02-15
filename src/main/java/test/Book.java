package test;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  private int numPages;

  private LocalDate pubDate;

  private String description;

  private String genre;

  @CreationTimestamp
  private LocalDate createDate;

  @CreationTimestamp
  private LocalDate updateDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getNumPages() {
    return numPages;
  }

  public void setNumPages(int numPages) {
    this.numPages = numPages;
  }

  public void setPubDate(LocalDate pubDate) {
    this.pubDate = pubDate;
  }

  public LocalDate getPubDate() {
    return pubDate;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDate createDate) {
    this.createDate = createDate;
  }

  public LocalDate getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalDate updateDate) {
    this.updateDate = updateDate;
  }

  @Override
  public String toString() {
    return "book [title = " + title + ", numPages= " + numPages + ", pubDate= " + pubDate + "]";
  }
}
