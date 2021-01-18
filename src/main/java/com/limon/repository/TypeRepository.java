package com.limon.repository;

import com.limon.entity.Category;
import com.limon.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
