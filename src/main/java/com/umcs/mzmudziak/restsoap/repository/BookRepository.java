package com.umcs.mzmudziak.restsoap.repository;

import com.umcs.mzmudziak.restsoap.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
