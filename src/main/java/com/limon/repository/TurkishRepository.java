package com.limon.repository;

import com.limon.entity.Category;
import com.limon.entity.Turkish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurkishRepository extends JpaRepository<Turkish,Long> {
    Turkish findByWord(String name);

}
