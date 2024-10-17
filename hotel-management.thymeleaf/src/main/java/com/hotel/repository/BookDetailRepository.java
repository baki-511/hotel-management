package com.hotel.repository;

import com.hotel.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<BookDetail,Integer> {
}
