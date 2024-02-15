package test;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

public record PaginatedResponse<E>(List<E> data, int page , int totalPages) {

  public PaginatedResponse(PanacheQuery<E> query) {
    this(query.list(), query.page().index + 1, query.pageCount());
  }
}
