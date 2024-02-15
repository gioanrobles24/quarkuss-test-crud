package test;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Book extends PanacheEntity {

  private String title;

  private int numPages;

  private LocalDate pubDate;

  private String description;

 
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  @Override
  public String toString() {
    return "book [title = " + title + ", numPages= " + numPages + ", pubDate= " + pubDate + "]";
  }
}
