package com.limon.repository;

import com.limon.entity.Category;
import com.limon.entity.English;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnglishRepository extends JpaRepository<English,Long> {
    English findByWord(String name);

}
