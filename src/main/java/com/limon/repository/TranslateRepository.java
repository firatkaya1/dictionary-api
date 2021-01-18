package com.limon.repository;

import com.limon.entity.Translate;
import com.limon.entity.TranslateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslateRepository extends JpaRepository<Translate,Long> {

    @Query(name = "findByWord",nativeQuery = true)
    List<TranslateDTO> findByWord(@Param("keyword") String keyword);

    @Query(name = "findByWord",nativeQuery = true)
    Page<TranslateDTO> findAllPageable(@Param("keyword") String keyword,Pageable pageable);
}
